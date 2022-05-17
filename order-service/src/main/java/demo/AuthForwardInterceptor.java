package demo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders; 
import org.springframework.stereotype.Component; import org.springframework.web.context.request.RequestContextHolder; import org.springframework.web.context.request.ServletRequestAttributes; 
import feign.RequestInterceptor; 
import feign.RequestTemplate;


@Component
public class AuthForwardInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        template.header(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
    }
}