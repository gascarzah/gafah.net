package net.gafah.microservicios.gateway.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


@Configuration
public class CorsConfiguration extends org.springframework.web.cors.CorsConfiguration {

//	private final List<String> allowedOrigins = Arrays.asList("*");
	private final List<String> allowedOrigins = Arrays.asList("http://localhost:4200",
	                                                          "https://gascarzah.com",
	                                                          "http://localhost:3000",
	                                                          "http://localhost:5173",
	                                                          "http://127.0.0.1:5173",
	                                                          "http://172.25.208.1:5173",
	                                                          "http://192.168.1.15:5173"
	                                                          );

    @Bean
    public CorsWebFilter  corsWebFilter() {
    	
    	final CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(allowedOrigins);
        corsConfig.setMaxAge(3600L);
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST","PUT", "DELETE", "OPTIONS", "PATCH"));
        corsConfig.addAllowedHeader("*");
        

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return new CorsWebFilter(source);
		
    
	}
	

	
	
}