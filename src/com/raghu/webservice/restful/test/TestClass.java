package com.raghu.webservice.restful.test;
import com.raghu.webservice.restful.dbservices.*;


import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
		System.out.println("getData From TestClass"+str);
		return str;
	}
	
	@PUT
	@Produces("text/plain")
	@Path("/addnew")
	@Consumes(MediaType.APPLICATION_JSON)
	public String addNew(String input) {
		
		System.out.println("Input>>>"+input);
		String[] str1 = null;
		StringBuffer sb = new StringBuffer();
		String strValue = "";
		
		input = input.replace('"', ' ').replace('{', ' ').replace('}', ' ').replaceAll("\\s",""); 
		System.out.println("Input after replace >>>"+input);
		
		String[] splitInput = input.split(",");
		//int len = splitInput.length;
		
		for( int i = 0; i <= splitInput.length - 1; i++)
		{
			str1 = splitInput[i].split(":");
			//System.out.println("str1 >>>"+str1[1]);
			sb.append(str1[1]);
			sb.append("|");
			
		}
		
		System.out.println("Values From Test Class ..."+sb.toString());
		DbServices dbServ = new DbServices();
		dbServ.putRecords(sb.toString());
		
		return "Request Received";
		
	}
	

}
