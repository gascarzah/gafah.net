package com.gafahtec.consultorio.cron;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gafahtec.consultorio.model.Cita;
import com.gafahtec.consultorio.model.Programacion;
import com.gafahtec.consultorio.model.ProgramacionDetalle;
import com.gafahtec.consultorio.service.ICitaService;
import com.gafahtec.consultorio.service.IProgramacionDetalleService;
import com.gafahtec.consultorio.service.IProgramacionService;

import lombok.AllArgsConstructor;
import net.bytebuddy.TypeCache.Sort;

@Component
@AllArgsConstructor
public class Scheduler {

    IProgramacionService iProgramacionService;
    IProgramacionDetalleService iProgramacionDetalleService;
    ICitaService iCitaService;

    @Scheduled(cron = "${cron.expression}")
    public void scheduleTask() throws Exception {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        ZoneId systemTimeZone = ZoneId.systemDefault();
        Date fechaActual = new Date();
          System.out.println(" fechaActual " + fechaActual);

        String strFechaActual = simpleDateFormat.format(fechaActual);

        List<Programacion> listaProgramacion = iProgramacionService.programacionActiva(0);

        for(Programacion programacion : listaProgramacion) {
            if (!(fechaActual.after(programacion.getFechaInicial()) && fechaActual.before(programacion.getFechaFinal()))) {
                System.out.println("p " + programacion) ;
                programacion.setEstado(1);
              try {
                  iProgramacionService.modificar(programacion);
              } catch (Exception e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
              }
          } else {
//              System.out.println("Programacion esta activa");
          }
        }
        
//        listaProgramacion.forEach(p -> {
//            if (!(fechaActual.after(p.getFechaInicial()) && fechaActual.before(p.getFechaFinal()))) {
//                  System.out.println("p " + p) ;
//                p.setEstado(1);
//                try {
//                    iProgramacionService.modificar(p);
//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            } else {
////                System.out.println("Programacion esta activa");
//            }
//        });

          System.out.println(" listaProgramacion " + listaProgramacion);

        List<ProgramacionDetalle> listaProgramacionDetalle = iProgramacionDetalleService.programacionDias(0);
//          System.out.println(" listaProgramacionDetalle " + listaProgramacionDetalle);

        listaProgramacionDetalle.forEach(det -> {
            ZonedDateTime zonedDateTime = det.getFecha().atStartOfDay(systemTimeZone);
            Date utilDate = Date.from(zonedDateTime.toInstant());
//              System.out.println("fechaActual "+fechaActual + " utilDate "+utilDate);
            String strFechaProgramacion = simpleDateFormat.format(utilDate);
//              System.out.println(" strFechaActual ============ strFechaProgramacion");
//              System.out.println(strFechaActual + " ========== "+ strFechaProgramacion);
            if (fechaActual.after(utilDate) && !StringUtils.equals(strFechaActual, strFechaProgramacion)) {
//                  System.out.println("fechaActual "+fechaActual + " utilDate "+utilDate);
//                  System.out.println(" utilDate "+utilDate);
//                  System.out.println(det.getFecha());
                det.setEstado(1);
                actualizarCitaDelDia(det.getIdProgramacionDetalle());
                try {
                    iProgramacionDetalleService.modificar(det);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    
    
    public void actualizarCitaDelDia(Integer idProgramacionDetalle) {
        Integer noAtendidos = 0;
        List<Cita> citas = iCitaService.listarNoAtendidos(idProgramacionDetalle, noAtendidos);
        
        for(Cita cita : citas) {
            if(null == cita.getCliente()) {
                cita.setAtendido(3); //no programado
            }else {
                cita.setAtendido(2);//no asistio
            }
            System.out.println("valor cita "+ cita);
            iCitaService.modificar(cita);
        }
    }
    
    
}
