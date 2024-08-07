//NOT FOR RELEASE
package net.bastionsg.dev.fortressapi;

import java.util.Scanner;

public class Example {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ely.by username:");
		String uname = sc.nextLine();
		System.out.println("Password associated with the account:");
		String pwd = sc.nextLine();
		
		try {
			System.out.println(MCAuth.AuthedProfile(uname, pwd, "bsg", true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("AccToken");
		String accToken = sc.nextLine();
		System.out.println("ClientToken");
		String cToken = sc.nextLine();
		sc.close();
		
		try {
			System.out.println(MCAuth.RefreshToken(accToken, cToken, true));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
}
