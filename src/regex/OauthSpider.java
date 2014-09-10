package regex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OauthSpider {

	public static void main(String[] args) {
//			BufferedReader br = new BufferedReader(new FileReader(
//					"C:\\Users\\Administrator\\Desktop\\get_request_token.htm"));
//			String line = "";
//			while ((line = br.readLine()) != null) {
			String line = "oauth_token=nurhcke&oauth_token_secret=e8be581****88888kkkkk76f6448f6eba6db642469776c86014bb5&oauth_expires_in=3600&xoauth_request_auth_url=https%3A%2F%2Fapi.login.yahoo.com%2Foauth%2Fv2%2Frequest_auth%3Foauth_token%3Dnurhcke&oauth_callback_confirmed=true";
				parse(line);
		
	}

	private static void parse(String line) {
		Pattern p1 = Pattern.compile(".*oauth_token=(.[[^&]&&[^<]]+).*");
		Pattern p2 = Pattern.compile(".*oauth_token_secret=(.[[^&]&&[^<]]+).*");
		Matcher m1 = p1.matcher(line);
		Matcher m2 = p2.matcher(line);
		while (m1.find()) {
			System.out.println(m1.group(1));
		}
		while (m2.find()) {
			System.out.println(m2.group(1));
		}
	}

}
