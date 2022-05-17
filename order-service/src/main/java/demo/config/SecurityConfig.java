package demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
		.authorizeRequests(exchange->exchange.antMatchers("*/h2-console/*").permitAll())
		.authorizeRequests(authorize->authorize.antMatchers("*/order/*").authenticated())
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
