package howtodo;

import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.stereotype.Component;

@Component
public class JettyCustomizer implements WebServerFactoryCustomizer<JettyServletWebServerFactory> {

	@Override
	public void customize(JettyServletWebServerFactory factory) {
	//	factory.setPort(8081);
	//	factory.setContextPath("/");
	}

}