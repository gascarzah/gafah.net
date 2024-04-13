package pe.gafahsoft.colegio.util;
 
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
 
public class ClientUtility {
 
    private static Context initialContext;
 
    //private static final String PKG_INTERFACES = "org.jboss.ejb.client.naming";
 
    public static Context getInitialContext() throws NamingException {
        if (initialContext == null) {
            Properties properties = new Properties();
            //properties.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
            //properties.put("jboss.naming.client.ejb.context", true);
            
            //properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            properties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            //properties.put(Context.PROVIDER_URL, "remote://localhost:4447");
            
            
            initialContext = new InitialContext(properties);
        }
        return initialContext;
    }
}