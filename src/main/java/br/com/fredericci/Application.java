package br.com.fredericci;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletConfig;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ServletListenerRegistrationBean;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletConfigAware;

import com.sun.faces.config.ConfigureListener;

@Configuration
@ComponentScan(basePackages = { "br.com.fredericci", "br.com.fredericci.view" })
@EnableAutoConfiguration
public class Application implements ServletConfigAware {

	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		FacesServlet servlet = new FacesServlet();
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.jsf");
		servletRegistrationBean.setLoadOnStartup(1);
		return servletRegistrationBean;
	}

	@Bean
	public ServletListenerRegistrationBean<ConfigureListener> jsfConfigureListener() {
		return new ServletListenerRegistrationBean<ConfigureListener>(new ConfigureListener());
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {

		servletConfig.getServletContext().setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());

	}

}