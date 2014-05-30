package org.deepak.javatutorial.webservice.client;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * 
 * @author Deepak.Dogra
 *
 */
public class ConversionServiceClient {  
    static final String REST_URI = "http://localhost:8080/JavaRestFulWebservice";  
    static final String F_TO_C = "/ConversionService/FahrenheitToCentigrade/";  
    static final String C_TO_F = "/ConversionService/CentigradeToFahrenheit/";  
  
    public static void main(String[] args) {  
  
        int inch=12;  
        int feet=2;  
  
        ClientConfig config = new DefaultClientConfig();  
        Client client = Client.create(config);  
        WebResource service = client.resource(REST_URI);  
  
        WebResource addService = service.path("rest").path(F_TO_C+inch);  
        System.out.println("Fahrenheit To Centigrade Response: " + getResponse(addService));  
        System.out.println("Fahrenheit_To_Centigrade Output as XML: " + getOutputAsXML(addService));  
        System.out.println("---------------------------------------------------");  
  
        WebResource subService = service.path("rest").path(C_TO_F+feet);  
        System.out.println("Centigrade To Fahrenheit: " + getResponse(subService));  
        System.out.println("Centigrade_To_Fahrenheit Output as XML: " + getOutputAsXML(subService));  
        System.out.println("---------------------------------------------------");  
  
    }  
  
    private static String getResponse(WebResource service) {  
        return service.accept(MediaType.TEXT_XML).get(ClientResponse.class).toString();  
    }  
  
    private static String getOutputAsXML(WebResource service) {  
        return service.accept(MediaType.TEXT_XML).get(String.class);  
    }  
}  

