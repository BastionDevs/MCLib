package net.bastionsg.dev.fortressapi;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import net.bastionsg.dev.fortressapi.errors.JSONMissingKeyException;

public class ParseInfo {

	public String GetInfo(String json, String key) {
		JsonReader jsonReader = Json.createReader(new StringReader(json));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		
		if(jsonObject.containsKey(key)) {
			return jsonObject.getString(key);
		} else {
			throw new JSONMissingKeyException("Key not present in JSON.");
		}
	}
	
	public JsonObject MCAuthUser(String MCAuthResp) {
		JsonReader jsonReader = Json.createReader(new StringReader(MCAuthResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		
		return jsonObject.getJsonObject("user");
	}
	
	public String MCAuthUUID(JsonObject MCAuthUser) {
		return MCAuthUser.getString("id");
	}
	
	public String MCAuthName(JsonObject MCAuthUser) {
		return MCAuthUser.getString("username");
	}
	
	public String MCAuthLanguage(JsonObject MCAuthUser) {
	    JsonArray propertiesArray = MCAuthUser.getJsonArray("properties");
	    for (JsonObject property : propertiesArray.getValuesAs(JsonObject.class)) {
	        if (property.getString("name").equals("preferredLanguage")) {
	            return property.getString("value");
	        }
	    }
	    //throw new JSONMissingKeyException("Key not present in JSON.");
	    
	    //default value
	    return "en";
	}
	
}
