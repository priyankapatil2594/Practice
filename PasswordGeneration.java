package homework;

import java.util.Random;


public class PasswordGeneration {
	int length;
	int strenth;
	
	public static String createPassword(int length, int strength) {
	
	 String smalllatters = "abcdefghijklmnopqrstuvwxyz";
	 String capitalletters ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	 String numbers = "0123456789";
	 String specialcharactors = "!@#%*$[](){}";
	 String combination1 = smalllatters + capitalletters;
	 String combination2 = smalllatters + capitalletters + numbers;
	 String combination3 = smalllatters + capitalletters + numbers + specialcharactors;
	 
	
	char [] Password =new char [length];
	Random random = new Random();
	String password=null;
	
	if((length>=4) &&(length<=10) && (strength>=1) && (strength<=3)) {
		if(strength ==1) {
			for(int i=0; i<length; i++) {
			Password[i]	=combination1.charAt(random.nextInt(combination1.length()));
			}
		}
		
		else if(strength ==2) {
			for(int i=0; i<length; i++) {
				Password[i]	=combination2.charAt(random.nextInt(combination2.length()));
		   }
		}
		else if(strength ==3) {
			for(int i=0; i<length; i++) {
				Password[i]	=combination3.charAt(random.nextInt(combination3.length()));
		  }
		}
		else {
			System.out.println("length of password should be 4 to 10 characters and Strength should be 1 , 2 or 3\n\n"); 
	   }
	}
	
	
	String PASSWORD= new String(Password);
	return PASSWORD;
	}
	
	public static void main(String[] args) {
		System.out.println(createPassword(8,2));
	}	

}