package com.raghu.webservice.restful.dbservices;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

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
		
		Document doc = new Document();
		StringBuilder sbReturn = new StringBuilder();
		String strFname = "";
		String strLname = "";
		int iAge ;
		
		connectToDB();
		
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("myCollection");
		
		List<Document> foundDocument = mongoCollection.find().into(new ArrayList<Document>());
		System.out.println("foundDocument>>>"+foundDocument);
		

		
		
		Iterator<Document> itr = foundDocument.iterator();
		
		while (itr.hasNext()) {
			
			doc = itr.next();
			System.out.println("doc >>>>"+doc);
			sbReturn.append(doc.toJson());
			sbReturn.append(",");
			System.out.println(" Document to JSON >>> "+ doc.toJson());
			System.out.println(" Document >>> "+ doc.get("FName"));
			System.out.println(" Document >>> "+ doc.get("LName"));
			System.out.println(" Document >>> "+ doc.get("Age"));
			
		}
		
		System.out.println("sbReturn >>>"+sbReturn);
//		Document doc = foundDocument.get(6);
//		System.out.println("doc>>>"+doc);
//		
//		String strID = doc.get("_id").toString();
//		System.out.println("strID>>>"+strID);	
//		
//		String FNAME = doc.get("FName").toString();
//		System.out.println("FNAME>>>"+FNAME);
//		
//		String LNAME = doc.get("LName").toString();
//		System.out.println("LNAME>>>"+LNAME);
//		
//		String AGE = doc.get("Age").toString();
//		System.out.println("AGE>>>"+AGE);
		
		mongoClient.close();
		return doc.toString();
	}
	
	public String putRecords(String strRecord) {
		
		System.out.println("strRecord >>> "+strRecord);
		String[] strValues = strRecord.split("\\|");
		
		//System.out.println("Length of strValues >>>"+strValues.length);
		
		
		connectToDB();
		
		MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("myCollection");
		
		Document insertDoc = new Document();
		for(int i=0; i<= strValues.length -1; i++)
		{	
			
			insertDoc.put("FName", strValues[0]);
			insertDoc.put("LName", strValues[1]);
			insertDoc.put("Age", strValues[2]);
			
		}
		
		mongoCollection.insertOne(insertDoc);
		
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
