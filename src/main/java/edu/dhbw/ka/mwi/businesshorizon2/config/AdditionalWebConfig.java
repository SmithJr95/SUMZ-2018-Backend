package edu.dhbw.ka.mwi.businesshorizon2.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AdditionalWebConfig{

/*	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("*")
		.allowedMethods("*")
		.allowedHeaders("*")
		.allowCredentials(true);
		
		System.out.println("*************************************************************************************************");
	}

	@Value("${sumz.client.host}")
	private String clientHost;
	
	public String getClientHost() {
		return clientHost;
	}

	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}*/
	
    /**
     * Allowing all origins, headers and methods here is only intended to keep this example simple.
     * This is not a default recommended configuration. Make adjustments as
     * necessary to your use case.
     *
     */
	
	@Value("${sumz.client.host}")
	private String clientHost;
	
	public String getClientHost() {
		return clientHost;
	}

	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}
	
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}