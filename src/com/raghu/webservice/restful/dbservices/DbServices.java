package com.raghu.webservice.restful.dbservices;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbServices {

	public static MongoClient mongoClient = null;
	public static MongoDatabase mongoDatabase = null;
	
	private void connectToDB() {
		
		mongoClient = new MongoClient();
		mongoDatabase = mongoClient.getDatabase("myWebServicedB");
		System.out.println("Connected to Database" +mongoDatabase);
		
		//mongoClient.close();
	}
	
	public String getRecords() {
		
		connectToDB();
		
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("myCollection");
		
		List<Document> foundDocument = mongoCollection.find().into(new ArrayList<Document>());
		System.out.println("foundDocument>>>"+foundDocument);
		
		Document doc = foundDocument.get(0);
		System.out.println("doc>>>"+doc);
		
		String strID = doc.get("_id").toString();
		System.out.println("strID>>>"+strID);	
		
		String x = doc.get("x").toString();
		System.out.println("x>>>"+x);
		
		mongoClient.close();
		return "Ret Value";
	}
	
	public String putRecords() {
		
		return "Ret Value";
	}
	
	public String updateRecords() {
		
		return "Ret Value";
	
	}
	
	public String deleteRecords() {
		
		return "Ret Value";
		
	}
	
	public String searchRecords() {
		
		return "Ret Value";
	}
}
