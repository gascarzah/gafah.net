package pe.gafahsoft.colegio.util;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
public class UWebUtil {
	private static final Logger log = Logger.getLogger(Utiles.class.getName());
	public String obtenerIP(){
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest)contexto.getExternalContext().getRequest();
		String ipAddress = req.getHeader("x-forwarded-for");
        if (ipAddress == null) {
            ipAddress = req.getHeader("X_FORWARDED_FOR");
            if (ipAddress == null){
                ipAddress = req.getRemoteAddr();
            }
        }
        return ipAddress;
	}

	public String obtenerParametroServidor(String parametro){
    	FacesContext contexto = FacesContext.getCurrentInstance();
        HttpServletRequest hSolicitar = (HttpServletRequest)contexto.getExternalContext().getRequest();
        return hSolicitar.getParameter(parametro);
    }
	
	public Object obtenerObjetoSession (String nombreObjeto){
    	return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(nombreObjeto);
    }
    
    public static void establecerObjetoSession ( String nombreObjeto, Object objeto ){
    	FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(nombreObjeto, objeto);
    }
	    
    public HttpSession getSession(boolean arg0)	{
		return (HttpSession)(FacesContext.getCurrentInstance().getExternalContext().getSession(arg0));
	}
	
	public static String obtenerFechaStr(Calendar calendario){
		StringBuffer resultado = new StringBuffer();
		resultado.append(completarCaracterIzquierda(calendario.get(Calendar.DATE), '0', 2) + " de ");
		resultado.append(obtenerNombreMes(calendario.get(Calendar.MONTH)+1) + " del ");
		resultado.append(calendario.get(Calendar.YEAR));
		return resultado.toString();
	}
		
	public static String obtenerFechaStr(Date fecha){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		String resultado = obtenerFechaStr(calendario);
		return resultado;
	}

	public static String completarCaracterIzquierda(Object valor, char caracter, int longitud){
		StringBuffer resultado = new StringBuffer();
		resultado.append(valor.toString());
		if (resultado.length() < longitud){
			while (resultado.length() < longitud){
				resultado.insert(0, caracter);
			}
		}
		return resultado.toString();
	}

	public static String completarCaracterDerecha(Object valor, char caracter, int longitud){
		StringBuffer resultado = new StringBuffer();
		resultado.append(valor.toString());
		if (resultado.length() < longitud){
			while (resultado.length() < longitud){
				resultado.append(caracter);
			}
		}
		return resultado.toString();
	}
	
	public static String obtenerNombreMes(int mes) {
		String resultado = "";
		switch (mes) {
		case 1: 
			resultado = "Enero";
			break;
		case 2: 
			resultado = "Febrero";
			break;
		case 3: 
			resultado = "Marzo";
			break;
		case 4: 
			resultado = "Abril";
			break;
		case 5: 
			resultado = "Mayo";
			break;
		case 6: 
			resultado = "Junio";
			break;
		case 7: 
			resultado = "Julio";
			break;
		case 8: 
			resultado = "Agosto";
			break;	
		case 9: 
			resultado = "Setiembre";
			break;
		case 10: 
			resultado = "Octubre";
			break;
		case 11: 
			resultado = "Noviembre";
			break;
		case 12:
			resultado = "Diciembre";
			break;
		default:
			resultado = "";
		}
		return resultado;
	}

	
	public static String convertirFechaString(Date fecha) {
		String resultado = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			if(fecha!=null){
				resultado = df.format(fecha);
			}
		} catch (Exception e) {
			resultado = "";
			e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);

		}
		return resultado;
	}
	
	public static String convertirHoraString(Date fecha) {
		String resultado = "";
		try {
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
			if(fecha!=null){
				resultado = df.format(fecha);
			}
		} catch (Exception e) {
			resultado = "";
			e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);

		}
		return resultado;
	}
	
    public static String obtenerFechaStr2(Calendar calendario){   
        String dia = String.valueOf(calendario.get(Calendar.DAY_OF_MONTH));;
        String mes = String.valueOf(calendario.get(Calendar.MONTH) + 1);
        String anho = String.valueOf(calendario.get(Calendar.YEAR));        
        dia = dia.length()<2?"0"+dia:dia;        
        mes = mes.length()<2?"0"+mes:mes;        
        String fecha = dia  + "/" + mes + "/" + anho;        
        return fecha;
    }

    public static String obtenerHora(Calendar calendario){    
        String hora = String.valueOf(calendario.get(Calendar.HOUR));
        String minu = String.valueOf(calendario.get(Calendar.MINUTE));
        String segu = String.valueOf(calendario.get(Calendar.SECOND));
                hora = hora.length()<2?"0"+hora:hora;        
        minu = minu.length()<2?"0"+minu:minu; 
        segu = segu.length()<2?"0"+segu:segu;
                String horaCompleta =  hora + ":" + minu + ":" + segu;      
        return horaCompleta;
    }
  
    public static boolean validarFechaInicioFin(Date fechaInicial, Date fechaFinal){
        boolean retorno = true;
        if (fechaInicial.getTime()>fechaFinal.getTime()){
        	retorno = false;
        }
        return retorno;
    }
  
    public static boolean validarFechaFinInicio(Date fechaInicial, Date fechaFinal){
        boolean retorno = true;
        if (fechaFinal.getTime()<fechaInicial.getTime()){
        	retorno = false;
        }
        return retorno;
    }
    
    public static boolean validarFechaMayor(Date fechaInicial, Date fechaEvaluar){
        boolean retorno = true;
        if (fechaInicial.getTime()<fechaEvaluar.getTime() || fechaInicial.getTime()==fechaEvaluar.getTime()){
        	retorno = false;
        }
        return retorno;
    }
    
    public static String obtenerDescripcionItem(List<SelectItem> lista, Object value) {
        if (lista != null && value != null)
            for (SelectItem item : lista) {
                if (item.getValue().toString().equals(value.toString()))
                    return item.getLabel();
            }
        return null;
    }
    
    public static String obtenerCodigoItem(List<SelectItem> lista, Object value) {
        if (lista != null && value != null){
            for (SelectItem item : lista){
                if (item.getLabel().toString().equals(value.toString()))
                    return item.getValue().toString();
            }
        }
        return null;
    }
   
    public static boolean validarFecha(int dia,int mes,int anio){
    	boolean validacion=true;
    	if(mes > 12){
    		validacion=false;
    	}else{ 
    		if(dia > 31){
    			validacion=false;
    		}else{ 
    			if((mes == 4 || mes == 6 || mes == 9 || mes == 11)&&(dia > 30)){
    				validacion=false;
    			}else{
    				if(mes == 2 && bisiesto(anio) && dia > 29){
    					validacion=false;
    				}else if (mes == 2 && !bisiesto(anio) && dia > 28){
    					validacion=false;
    				}
    			}
    		}
    	}
    	return validacion;
    }
   
    public static boolean bisiesto(int anio){
    	if (anio % 400 == 0){
    		return true;
    	}else{
    		if(anio % 4 == 0 && anio % 100 != 0){
    			return true;
    		}else{
    			return false;
    		}
    	}
    } 
  
	public static String obtenerNombreArchivo(String nombre) {
		String nombreFinal = "";
		try {
			nombreFinal = nombre.substring(nombre.lastIndexOf("\\") + 1,nombre.length());
		} catch (Exception e) {
			nombreFinal = "";
			e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);
		}
		return nombreFinal;
	}
	
	public static boolean validarFechaFinSemana(Date fecha){
		boolean indicador = false;
		try{
			Calendar cal = Calendar.getInstance();
			cal.setTime(fecha);
			if(cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
			   cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				indicador = true;
			}
		}catch (Exception e) {
			indicador = false;
			e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);
		}
		return indicador;
	}

	public static int obtenerDiaSemana(Date fecha){
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		int numeroDia= calendario.get(Calendar.DAY_OF_WEEK);
		return numeroDia;
	}
		
	public static String obtenerNumeroMes(String mes) {
		if("Enero".equals(mes))
			mes="01";
		else if("Febrero".equals(mes))
			mes="02";
		else if("Marzo".equals(mes))
			mes="03";
		else if("Abril".equals(mes))
			mes="04";
		else if("Mayo".equals(mes))
			mes="05";
		else if("Junio".equals(mes))
			mes="06";
		else if("Julio".equals(mes))
			mes="07";
		else if("Agosto".equals(mes))
			mes="08";
		else if("Setiembre".equals(mes))
			mes="09";
		else if("Octubre".equals(mes))
			mes="10";
		else if("Noviembre".equals(mes))
			mes="11";
		else if("Diciembre".equals(mes))
			mes="12";
		else
			mes="";
		return mes;
	}

	public static Date convertirFechaDate(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            return fechaDate;
        } catch (Exception e) {
        	e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);
            return fechaDate;
        }
    }
	
	public static Date convertirFechaAnio(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            return fechaDate;
        } catch (Exception e) {
        	e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);
            return fechaDate;
        }
    }

	public static Date convertirFechaMes(String fecha){
        SimpleDateFormat formato = new SimpleDateFormat("MM");
        String strFecha = fecha;
        Date fechaDate = null;
        try {
            fechaDate = formato.parse(strFecha);
            return fechaDate;
        } catch (Exception e) {
        	e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);
            return fechaDate;
        }
    }
	public static Date convertirFormatoHora(String horaFormato){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String strFormatoHora = horaFormato;
        Date formatoHora = null;
        try {
        	formatoHora = formato.parse(strFormatoHora);
            return formatoHora;
        } catch (Exception e) {
        	e.printStackTrace();
//			log.error("Error en convertirFechaString(): "+e);
            return formatoHora;
        }
    }
	
	  public String validarCelular(String celular)
	  {
	    String exp_reg_cel = "^[9][0-9]+$";

	    celular = celular == null ? "" : celular;

	    if ((celular.matches(exp_reg_cel)) && (celular.length() == 9)) {
	      return "1";
	    }
	    return "0";
	  }
	  

	  public String validarCorreoElectronico(String correo)
	  {
	    String exp_reg_correo = "^[a-zA-Z0-9._%-]+@[a-zA-Z0-9._%-]+\\.[a-zA-Z]{2,4}$";

	    correo = correo == null ? "" : correo;

	    if (correo.matches(exp_reg_correo)) {
	      return "1";
	    }
	    return "0";
	  }
	  
	  public String validarNumeroDocumentoIdentidad(long tipoDoc , String numero)
	  {
	    String exp_reg_numero = "[0-9]+$";
		    numero = numero == null ? "" : numero;
		if(tipoDoc==306){
			if ((numero.matches(exp_reg_numero)) && (numero.length() == 8)) {
			      return "1";
			}	
		}
		if(tipoDoc==307){
			if ((numero.matches(exp_reg_numero)) && (numero.length() == 15)) {
			      return "1";
			}	
		}
	    
	   
	    return "0";
	  }
	  
	// Suma o resta los meses recibidos a la fecha  
	  public static Date sumarRestarMesesFecha(Date fecha, int meses){
	  
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(fecha); // Configuramos la fecha que se recibe
	        calendar.add(Calendar.MONTH, meses);  // numero de meses a añadir, o restar en caso de meses<0
	         
	        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	   
	  }
	  
	// Suma o resta los dias recibidos a la fecha  
	  public static Date sumarRestarDiasFecha(Date fecha, int dia){
		  Calendar calendar = Calendar.getInstance();
	        calendar.setTime(fecha); // Configuramos la fecha que se recibe
	        calendar.add(Calendar.DAY_OF_YEAR, dia);  // numero de dias a añadir, o restar en caso de dias<0
	         
	        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas	 
	  }
	  
	  
	  public static String convertirDateFecha(Date date){		  
		  	String vfecha  = ""; 				        
	        try {
	        	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				vfecha = format.format(date);  
	            return vfecha;
	        } catch (Exception e) {
	        	e.printStackTrace();
//				log.error("Error en convertirFechaString(): "+e);
	            return vfecha;
	        }
	    }
	
	  public static boolean esNumerico(String str){
		    for (char c : str.toCharArray()){
		        if (!Character.isDigit(c)) return false;
		    }
		    return true;
		}	
	  
	  public static Date getUltimoDiaDelMes() {
	        Calendar cal = Calendar.getInstance();
			         cal.set(cal.get(Calendar.YEAR),
			         cal.get(Calendar.MONTH),
	                 cal.getActualMaximum(Calendar.DAY_OF_MONTH),
	                 cal.getMaximum(Calendar.HOUR_OF_DAY),
	                 cal.getMaximum(Calendar.MINUTE),
	                 cal.getMaximum(Calendar.SECOND));
			return cal.getTime();
	  }
	  public static Date getPrimerDiaDelMes() {
			 Calendar cal = Calendar.getInstance();
	         		  cal.set(cal.get(Calendar.YEAR),
	                  cal.get(Calendar.MONTH),
	                  cal.getActualMinimum(Calendar.DAY_OF_MONTH),
	                  cal.getMinimum(Calendar.HOUR_OF_DAY),
	                  cal.getMinimum(Calendar.MINUTE),
	                  cal.getMinimum(Calendar.SECOND));
	         return cal.getTime();
	 
	     }
	  

	  public static long enteroPositivo(String str)
	  {
	      DecimalFormatSymbols currentLocaleSymbols = DecimalFormatSymbols.getInstance();
	      char localeMinusSign = currentLocaleSymbols.getMinusSign();

		if (str != null && !str.isEmpty() && !str.equals("-")) {

			if (!Character.isDigit(str.charAt(0))
					&& str.charAt(0) != localeMinusSign)
				return -1;

			boolean isDecimalSeparatorFound = false;
			char localeDecimalSeparator = currentLocaleSymbols
					.getDecimalSeparator();

			for (char c : str.substring(1).toCharArray()) {
				if (!Character.isDigit(c)) {
					if (c == localeDecimalSeparator && !isDecimalSeparatorFound) {
						isDecimalSeparatorFound = true;
						continue;
					}
					return -1;
				}
			}
		}else{
			return -1;
		}
	      
	      return Integer.parseInt(str) > 0 ? Integer.parseInt(str): -1;
	  }/*rpe*/
	  
}
