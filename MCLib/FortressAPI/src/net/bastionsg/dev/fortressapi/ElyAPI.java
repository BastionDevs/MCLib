package net.bastionsg.dev.fortressapi;

import java.io.StringReader;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

import net.bastionsg.dev.utils.Net;

public class ElyAPI {

	public static String GetUUID(String username) throws Exception {
		String JSONResp = Net.GetReq("https://authserver.ely.by/api/users/profiles/minecraft/" + username);
		JsonReader jsonReader = Json.createReader(new StringReader(JSONResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		return jsonObject.getString("id");
	}
	
	public static String UUIDNames(String uuid) throws Exception {
		return Net.GetReq("https://authserver.ely.by/api/users/profiles/" + uuid) + "/names";
	}
	
}
