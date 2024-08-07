package net.bastionsg.dev.fortressapi;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

import net.bastionsg.dev.utils.Net;

public class OAuth {

	public static String ExchangeAuthCode(String client_id, String client_secret, String redirect_uri, String code) throws Exception {
		return Net.POSTReq("https://account.ely.by/api/oauth2/v1/token", "{\"client_id\":\""+client_id+"\",\"client_secret\":\""+client_secret+"\",\"redirect_uri\":\""+redirect_uri+"\",\"grant_type\":\"authorization_code\",\"code\":\""+code+"\"}");
	}
	
	public static String UserInfo(String access_token) throws Exception {
		URL url = new URI("https://account.ely.by/api/account/v1/info").toURL();
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");

        httpConn.setRequestProperty("Authorization", access_token);

        InputStream responseStream = httpConn.getResponseCode() / 100 == 2
                ? httpConn.getInputStream()
                : httpConn.getErrorStream();
        Scanner s = new Scanner(responseStream).useDelimiter("\\A");
        String response = s.hasNext() ? s.next() : "";
        s.close();
        return response;
	}
	
}
