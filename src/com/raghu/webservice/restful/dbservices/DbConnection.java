package com.raghu.webservice.restful.dbservices;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
//import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbConnection {
	
	public void dbConnect() {
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase mongoDatabase = mongoClient.getDatabase("myWebServicedB");
		System.out.println("Connected to Database" +mongoDatabase);
		
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
	}

}
