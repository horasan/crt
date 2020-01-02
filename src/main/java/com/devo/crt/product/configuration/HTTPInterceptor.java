package com.devo.crt.product.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class HTTPInterceptor extends HandlerInterceptorAdapter {
	@Override
    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) throws Exception
    {
     
		/*String requestData = requestServlet.getReader().lines().collect(Collectors.joining());
		System.out.println("HTTP INTERCEPTOR PREHANDLE CALLED");*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception
    {
    	//String requestData = response..lines().collect(Collectors.joining());
    	
        /*System.out.println("HTTP INTERCEPTOR POSTHANDLE CALLED");*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception
    {
        /*System.out.println("HTTP INTERCEPTOR AFTERCOMPLETION CALLED");*/
    }
}
