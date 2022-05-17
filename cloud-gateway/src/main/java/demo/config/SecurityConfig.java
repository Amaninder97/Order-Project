package demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
		
		serverHttpSecurity
		.authorizeExchange(exchange->exchange.pathMatchers("*/h2-console/*").permitAll())
		.authorizeExchange(exchange->exchange.pathMatchers("*/order/*").authenticated())
		.authorizeExchange(exchange->exchange.pathMatchers("*/notificationservice/*").authenticated())
		.oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt);
		serverHttpSecurity.csrf().disable();
	return	serverHttpSecurity.build();
		
	}
	
	
}
