package com.appspot.js4kgames.servlet;

import org.reflections.Reflections;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * A customer Spring MVC DispatcherServlet sub class that sets up the DispatcherServlet 
 * with a static web application context (i.e. no XML file or annotation based spring config)
 * that contains the minimum programmatically added beans required to support Freemarker as
 * the view technology and @Controller classes annotated with @RequestMapping annotations. This
 * is in an attempt to minimise the overhead of the Spring MVC framework during the GAE cold 
 * start up. Instead of use classpath component scanning, it makes use of the Reflections 
 * library, which uses XML files generated at build time for determining what classes are 
 * annotated with the @Controller annotation.
 * 
 * @author js4kgames
 */
@SuppressWarnings("serial")
public class Js4kGamesServlet extends DispatcherServlet {

	/**
	 * Constructor for Js4kGamesServlet.
	 */
	public Js4kGamesServlet() {
	    super(new StaticWebApplicationContext());
	    
	    // Turn off the attempt of find handlers by type.
	    setDetectAllHandlerAdapters(false);
	    setDetectAllHandlerMappings(false);
	    setDetectAllViewResolvers(false);
	    
	    // Add only the handler beans we need to support RequestMapping annotations.
	    StaticWebApplicationContext context = (StaticWebApplicationContext)getWebApplicationContext();
	    context.registerSingleton(HANDLER_MAPPING_BEAN_NAME, RequestMappingHandlerMapping.class);
	    context.registerSingleton(HANDLER_ADAPTER_BEAN_NAME, RequestMappingHandlerAdapter.class);
	    
	    // Set up FreeMarker as the one and only view technology.
	    MutablePropertyValues freemarkerConfigProps = new MutablePropertyValues();
	    freemarkerConfigProps.add("templateLoaderPath", "/WEB-INF/ftl/");
	    context.registerSingleton("freemarkerConfig", FreeMarkerConfigurer.class, freemarkerConfigProps);
	    MutablePropertyValues freemarkerViewResolverProps = new MutablePropertyValues();
	    freemarkerViewResolverProps.add("cache", true);
	    freemarkerViewResolverProps.add("prefix", "");
	    freemarkerViewResolverProps.add("suffix", ".ftl");
	    context.registerSingleton(VIEW_RESOLVER_BEAN_NAME, FreeMarkerViewResolver.class, freemarkerViewResolverProps);
	    
	    // Register annotated beans using the data collected by Reflections API during the maven build.
	    Reflections reflections = Reflections.collect();
	    for (Class<?> controllerClass : reflections.getTypesAnnotatedWith(Controller.class)) {
	      context.registerSingleton(StringUtils.uncapitalize(controllerClass.getSimpleName()), controllerClass);
	    }
	}
}
