package net.bastionsg.dev.fortressapi;

import java.io.IOException;

import net.bastionsg.dev.utils.Net;

public class OAuth {

	public static String ExchangeAuthCode(String client_id, String client_secret, String redirect_uri, String code) throws IOException {
		return Net.POSTReq("https://account.ely.by/api/oauth2/v1/token", "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"redirect_uri\":\""+redirect_uri+"\",\"grant_type\":\"authorization_code\",\"code\":\""+code+"\"}");
	}
	
}
