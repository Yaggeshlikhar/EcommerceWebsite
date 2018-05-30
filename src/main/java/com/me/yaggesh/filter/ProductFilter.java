package com.me.yaggesh.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductFilter implements Filter {
	
	@Override
	public void init(FilterConfig fc) throws ServletException {
//      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

	@Override
	public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest) sr;
        if (httpRequest.getMethod().equalsIgnoreCase("POST")) {
        	
        	String brand = sr.getParameter("brand");
        	String productName = sr.getParameter("productName");
        	int price = Integer.parseInt(sr.getParameter("price"));
        	String description = sr.getParameter("description");
        	
        	Pattern r1 = Pattern.compile("\\s");
            Pattern r2 = Pattern.compile("[\'\"]");
            Pattern r3 = Pattern.compile("(and|or|null|not|union|select|from|where|group|order|having|limit|into|file|case)");
            Pattern r4 = Pattern.compile("(--|#|\\/\\*)");
            
            if(r1.matcher(brand).find() || r2.matcher(brand).find() || r3.matcher(brand).find() || r4.matcher(brand).find())
            {
            	 HttpServletResponse response = (HttpServletResponse) sr1;

                 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movie title provided");
            }
            if(r1.matcher(productName).find() || r2.matcher(productName).find() || r3.matcher(productName).find() || r4.matcher(productName).find())
            {
            	 HttpServletResponse response = (HttpServletResponse) sr1;

                 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movie title provided");
            }

            if(r1.matcher(description).find() || r2.matcher(description).find() || r3.matcher(description).find() || r4.matcher(description).find())
            {
            	 HttpServletResponse response = (HttpServletResponse) sr1;

                 response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid movie title provided");
            }
        	
        	
        }
        chain.doFilter(sr, sr1);
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
