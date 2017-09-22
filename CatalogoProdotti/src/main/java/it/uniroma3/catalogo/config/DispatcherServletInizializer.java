package it.uniroma3.catalogo.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInizializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses(){   //This specifies the configuration classes for the root application context
		return new Class[] {RootApplicationContextConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {   //This specifies the configuration classes for the Dispatcher servlet application context
		return new Class[] {WebApplicationContextConfig.class };
	}

	@Override
	protected String[] getServletMappings() {  //This specifies the servlet mapping for DispatcherServlet
		return new String[] { "/" };
	}
}
