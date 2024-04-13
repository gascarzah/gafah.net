package pe.gafahsoft.colegio.util;

import javax.naming.Context;
import javax.naming.NamingException;

import pe.gafahsoft.colegio.service.GeneralServiceRemote;
import pe.gafahsoft.colegio.service.impl.GeneralBeanService;

public class ServiceLocator {

	private static ServiceLocator instance;

	public static ServiceLocator getInstance() {

		if (instance == null) {

			instance = new ServiceLocator();
		}
		return instance;
	}

	
	
	public ServiceLocator() {
		super();
		// TODO Auto-generated constructor stub
	}



	public static GeneralServiceRemote doLookup() {
		Context context = null;
		GeneralServiceRemote cIR = null;
		try {
			// 1. Obtaining Context
			context = ClientUtility.getInitialContext();
			// 2. Generate JNDI Lookup name
			String lookupName = getLookupName();
			// 3. Lookup and cast
			System.out.println("EL lookupName es: " + lookupName);
			cIR = (GeneralServiceRemote) context.lookup(lookupName);

		} catch (NamingException e) {
			e.printStackTrace();
		}
		return cIR;
	}

	private static String getLookupName() {
		/*
		 * The app name is the EAR name of the deployed EJB without .ear suffix.
		 * Since we haven't deployed the application as a .ear, the app name for
		 * us will be an empty string
		 */
		String appName = "colegioEAR";

		/*
		 * The module name is the JAR name of the deployed EJB without the .jar
		 * suffix.
		 */
		String moduleName = "colegio-domain";

		/*
		 * AS7 allows each deployment to have an (optional) distinct name. This
		 * can be an empty string if distinct name is not specified.
		 */
		String distinctName = "";

		// The EJB bean implementation class name
		String beanName = GeneralBeanService.class.getSimpleName();

		// Fully qualified remote interface name
		final String interfaceName = GeneralServiceRemote.class.getName();

		// Create a look up string name
		String name = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + interfaceName;
		
		return name;
	}
}
