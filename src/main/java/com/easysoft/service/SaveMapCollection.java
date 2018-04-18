package com.easysoft.service;

import java.util.Map;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.util.JSON;

public class SaveMapCollection {
	private static Mongo mongo = new Mongo("localhost", 27017);
	private static DB db = mongo.getDB("cnipr");
	private static DBCollection collection = db.getCollection("shencha");
	static {

	}

	public static void main(String[] args) {
//		 saveJsonStr();
	}

	public static void saveJsonStr(Map map) {
			// convert JSON to DBObject directly
//			DBObject dbObject = (DBObject) JSON.parse(str);
//			DBCursor cursorDoc = collection.find();
//			while (cursorDoc.hasNext()) {
//				System.out.println(cursorDoc.next());
//			}
		
	}

}
