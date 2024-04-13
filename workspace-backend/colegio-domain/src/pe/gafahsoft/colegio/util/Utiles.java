package pe.gafahsoft.colegio.util;

public class Utiles {

	
	public static String inParametros(int cantidad) {
		StringBuilder stb = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int i = 0;


		while (i < cantidad) {
			if (stb.length() > 0) {
				stb.append(Constantes.SEPARADOR_COMA);
			}
			stb.append(Constantes.SP_PARAMETROS_ENTRADA);

			i++;
		}

		result.append(Constantes.SEPARADOR_PARENTESIS_ABIERTO);
		result.append(stb.toString());
		result.append(Constantes.SEPARADOR_PARENTESIS_CERRADO);

		return result.toString();

	}
}
