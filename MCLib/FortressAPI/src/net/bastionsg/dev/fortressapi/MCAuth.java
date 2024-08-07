package net.bastionsg.dev.fortressapi;

import java.io.StringReader;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import net.bastionsg.dev.fortressapi.errors.*;
import net.bastionsg.dev.utils.Net;

public class MCAuth {

	public static String AuthedProfile(String username, String password, String clientToken, boolean requestUser) throws Exception, IncorrectKeyException {
		String JSONResp = Net.POSTReq("https://authserver.ely.by/auth/authenticate", "{\"username\": \""+username+"\",\"password\":\""+password+"\", \"clientToken\": \""+clientToken+"\", \"requestUser\": \""+requestUser+"\"}");
		JsonReader jsonReader = Json.createReader(new StringReader(JSONResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		if (jsonObject.containsKey("error")) {
			if (jsonObject.getString("error").equals("ForbiddenOperationException") && jsonObject.getString("errorMessage").equals("Account protected with two factor auth.")) {
				throw new IncorrectKeyException("Account protected with two factor auth.");
			} else {
				throw new IncorrectKeyException("Invalid username or password.");
			}
		} else {
			return JSONResp;
		}
	}
	
	public static String RefreshToken(String accessToken, String clientToken, boolean requestUser) throws Exception, IncorrectKeyException {
		String JSONResp = Net.POSTReq("https://authserver.ely.by/auth/refresh", "{\"accessToken\": \""+accessToken+"\", \"clientToken\": \""+clientToken+"\", \"requestUser\": \""+requestUser+"\"}");
		JsonReader jsonReader = Json.createReader(new StringReader(JSONResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		if (jsonObject.containsKey("error")) {
			if (jsonObject.getString("error").equals("ForbiddenOperationException") && jsonObject.getString("errorMessage").equals("Invalid token.")) {
				throw new IncorrectKeyException("Incorrect access/client token.");
			} else {
				return "Error-Other: "+JSONResp;
			}
		} else {
			return JSONResp;
		}
	}
	
	public static boolean ValidateToken(String accessToken) throws Exception, ExpiredTokenException {
		String JSONResp = Net.POSTReq("https://authserver.ely.by/auth/validate", "{\"accessToken\": \""+accessToken+"\"}");
		JsonReader jsonReader = Json.createReader(new StringReader(JSONResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		if (jsonObject.containsKey("error")) {
			throw new ExpiredTokenException("Access token expired.");
		} else {
			return true;
		}
	}
	
	public static void Signout(String username, String password) throws Exception, IncorrectKeyException {
		String JSONResp = Net.POSTReq("https://authserver.ely.by/auth/signout", "{\"username\": \""+username+"\", \"password\": \""+password+"\"");
		JsonReader jsonReader = Json.createReader(new StringReader(JSONResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		if (jsonObject.containsKey("error")) {
			throw new IncorrectKeyException("Invalid username or password.");
		}
	}
	
	public static void InvalidateToken(String accessToken, String clientToken) throws Exception, IncorrectKeyException {
		String JSONResp = Net.POSTReq("https://authserver.ely.by/auth/invalidate", "{\"accessToken\": \""+accessToken+"\", \"clientToken\": \""+clientToken+"\"");
		JsonReader jsonReader = Json.createReader(new StringReader(JSONResp));
		JsonObject jsonObject = jsonReader.readObject();
		jsonReader.close();
		if (jsonObject.containsKey("error")) {
			throw new IncorrectKeyException("Incorrect access/client token.");
		}
	}
	
}
