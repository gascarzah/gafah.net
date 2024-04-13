package pe.gafahsoft.colegio.util;

public class Constantes {

	public static final String SEPARADOR_COMA = ",";
	public static final String SEPARADOR_PARENTESIS_ABIERTO = "(";
	public static final String SEPARADOR_PARENTESIS_CERRADO = ")";
	public static final String SP_PARAMETROS_ENTRADA = "?";
	
	public static final int MENU_PADRE_ORIGEN_ID = 0;
	public static final String TABLA_ESTADO = "ESTADO";
	public static final String TABLA_GRADO = "GRADO";
	
//	public static final int OBTENER_TODOS_LOS_CAMPOS = 0;
//	public static final int PARAMETROS_INSERTAR = 1;
//	public static final int PARAMETROS_ACTUALIZAR = 2;
//	
//	
//	public static final int PARAMETROS_BUSQUEDA_TIPO_1 = 4;
	
	public static final int COD_TABLA_ESTADO = 1;
	public static final int COD_TABLA_NIVELES = 4;
	public static final int COD_TABLA_ESTADO_CIVIL = 34;
	
	public static final int ACTIVO = 1;
	public static final int DESACTIVO = 0;
	
	public static final int INSERTAR = 0;
	public static final int ACTUALIZAR = 1;
	public static final int BUSCAR_TODOS = 2;
	public static final int BUSCAR_POR_PADRE = 3;
	public static final int BUSCAR_POR_DNI_ALUMNO = 4;
	public static final int BUSCAR_POR_NIVEL = 5;
	public static final int BUSCAR_POR_ASISTENCIA	 = 6;
	public static final int LOGIN	 = 7;
	public static final int BUSCAR_POR_ID= 8;
	public static final int BUSCAR_TIPO_APODERADO_Y_DNI_ALUMNO=9;
	public static final int BUSCAR_MATRICULA_DNI_ALUMNO=10;
	public static final int BUSCAR_POR_DNI_APODERADO=11;
	public static final int BUSCAR_MATRICULA_POR_ANIO = 12;
	public static final int BUSCAR_CAPACIDAD_POR_AREA = 13;
	public static final int BUSCAR_NIVEL_POR_CAPACIDAD = 14;
	public static final int BUSCAR_POR_INDICADORES = 15;
	public static final int BUSCAR_POR_ID_ALUM_ID_APOD = 16;
	public static final int BUSCAR_POR_DNI_APODERADO_TIP_APO=17;
	public static final int ELIMINAR = 18;
	
	public static final String SQL_AUDITORIA = " m.usu_reg as usuReg , " +
											  " m.fec_reg as fecReg , " +
											  " m.usu_mod as usuMod , " +
											  " m.fec_mod as fecMod , " +
											  " m.maq_reg as maqReg , " +
											  " m.maq_mod as maqMod " ;
	
	public static final int MASCULINO = 23;
	public static final int FEMENINO = 24;
	
	public static final int APODERADO = 26;
	
	public static final int CASADO = 27;
	public static final int SOLTERO = 28;
	
	public static final int PADRE = 32;
	public static final int MADRE = 33;
	
	public static final int GRABAR_MATRICULA = 1;
	public static final int GRABAR_ALUMNO = 2;
	public static final int MODIFICAR_MATRICULA = 3;
	public static final int MODIFICAR_ALUMNO = 4;
	
	public static final int BIMESTRE_1 = 41;
	public static final int BIMESTRE_2 = 42;
	public static final int BIMESTRE_3 = 43;
	public static final int BIMESTRE_4 = 44;
	
}
