package com.raghu.webservice.restful.test;
import com.raghu.webservice.restful.dbservices.*;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/gettingstarted")
public class TestClass {
	
	@Path("/hello")
	@GET
	public String hello() {
		DbServices dbServ = new DbServices();
		String str = dbServ.getRecords();
		System.out.println(str);
		return "Hello World!";
	}
	
	@POST
	@Produces("text/plain")
	@Path("/addnew")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNew(String input) {
		System.out.println("Input>>>"+input);
		return "Request Received";
		
	}
	

}
