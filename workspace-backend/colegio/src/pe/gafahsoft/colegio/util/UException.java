package pe.gafahsoft.colegio.util;

public class UException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 631349359036874307L;

	public UException() {
		super();
		
	}

	public UException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public UException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public UException(String message) {
		super(message);
		
	}

	public UException(Throwable cause) {
		super(cause);
		
	}
	
	
	

}
