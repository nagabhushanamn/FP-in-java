package com.bank.mts.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfig implements WebApplicationInitializer{
	
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("onStartup");
		// -------------------------------------------------------------------------
		// Create the 'root' Spring application context
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MTSConfig.class);
		// Manage the lifecycle of the root application context
		servletContext.addListener(new ContextLoaderListener(rootContext));
		// --------------------------------------------
		//
		// Create the dispatcher servlet's Spring application context
		AnnotationConfigWebApplicationContext childContext = new AnnotationConfigWebApplicationContext();
		childContext.register(MTSMvcConfig.class);

		// Register and map the dispatcher servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher",new DispatcherServlet(childContext));
		dispatcher.setLoadOnStartup(0);
		dispatcher.addMapping("/");

		// ---------------------------------------------
		
	}

}
