package com.mycompany.app;
import java.util.*;

public class App {

	public static String cryptoMethod(int[] a1,int[] a2, String original,int crypt) {
		
		String cryptolized = "";
		if(a1.length!=a2.length ) {
			return null;
		}
		else if (crypt <=0) {
			return null;
		}
		else if(a1.length!=original.length() || a2.length!=original.length()) {
			return null;
			
		}
		else {
			for(int i=0;i<a1.length;i++) {
				cryptolized += (char)(((original.charAt(i) - 'a' + (a1[i]*a2[i]*crypt))%26)+'a');
			}
			
			return cryptolized;
			
		}
		
	}
	// aaaaaa 5 fkpuze
	// aaaaaa 6 gmsyek

	
	public static void main(String args[]) {
		int[] x1 = {1,1,1,1,1,1};
		int[] x2 = {1,2,3,4,5,6};

		System.out.println(cryptoMethod(x1,x2,"aaaaaa",6));
		System.out.println(cryptoMethod(x1,x2,"aaaaaaa",5));
		System.out.println(cryptoMethod(x1,x2,"aaaaaa",-5));


	}
}
