package org.deepak.javatutorial.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * 
@Path(/your_path_at_class_level) : Sets the path to base URL + /your_path_at_class_level. The base URL is based on your application name, the servlet and the URL pattern from the web.xml" configuration file.
@Path(/your_path_at_method_level): Sets path to base URL + /your_path_at_class_level+ /your_path_at_method_level
@Produces(MediaType.TEXT_XML [, more-types ]): @Produces defines which MIME type is delivered by a method annotated with @GET. In the example text ("text/XML") is produced.
@PathParam: Used to inject values from the URL into a method parameter.This way you inject inch in convertFeetToInch method and convert that to feet.

 * @author Deepak.Dogra
 * 
 */

@Path("ConversionService")
public class FahrenheitToCentigradeAndcentigradeToFahrenheitConversionService {

	@GET
	@Path("/FahrenheitToCentigrade/{f}")
	@Produces(MediaType.TEXT_XML)
	public String convertFahrenheitToCentigrade(@PathParam("f") int f) {

		int fahrenheit = f;
		
		double centigrade = 0;
		centigrade =  (fahrenheit - 32)*5/9;
		
		return "<FahrenheitToCentigradeService>" + "<Fahrenheit>" + fahrenheit
				+ "</Fahrenheit>" + "<Centigrade>" + centigrade + "</Centigrade>"
				+ "</FahrenheitToCentigradeService>";
	}

	@Path("/CentigradeToFahrenheit/{c}")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String convertCentigradeToFahrenheit(@PathParam("c") int c) {
		int centigrade = c;
		int fahrenheit = 0;
		fahrenheit = ((9*centigrade)/5 )+ 32;

		return "<CentigradeToFahrenheitService>" + "<Fahrenheit>" + fahrenheit
				+ "</Fahrenheit>" + "<Centigrade>" + centigrade + "</Centigrade>"
				+ "</CentigradeToFahrenheitService>";
	}
	
	

}
