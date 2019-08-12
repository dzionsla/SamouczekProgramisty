package com.dzionsla.aoc2016.day05;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
	
	public Password() {
		//System.out.println(createMD5("abc3231929"));;
		//looper("reyedfim"); // 1st part
		looper2("reyedfim"); // 2nd part
	}
	
	public void looper2(String str) {
		StringBuffer sb = new StringBuffer();
		StringBuffer code = new StringBuffer();
		code.append("........");
		
		sb.append(str);
		
		for (int i = 0; i < 89000000; i++) {
			sb.append(i);
			String hash = createMD5(sb.toString());
			//System.out.println(Character.getNumericValue(getPositionMD5(hash)));
			if (checkMD5(hash) && Character.getNumericValue(getPositionMD5(hash)) < 8 && code.toString().charAt(Character.getNumericValue(getPositionMD5(hash))) == '.'   ) {
				System.out.println(code.toString());
				System.out.println(sb.toString());
				System.out.println(hash);
				System.out.println(getPositionMD5(hash));
				System.out.println(getLetter2MD5(hash));
				code.replace(Character.getNumericValue(getPositionMD5(hash)), Character.getNumericValue(getPositionMD5(hash))+1, String.valueOf(getLetter2MD5(hash)));
				System.out.println(code.toString());
				//code.append(getLetterMD5(hash));
			}
			
			sb.delete(str.length(), sb.length());
			
			if (!code.toString().contains(".")) {
				break;
			}
		}
		
		System.out.println(code);
	}
	
	public void looper(String str) {
		StringBuffer sb = new StringBuffer();
		StringBuffer code = new StringBuffer();
		
		sb.append(str);
		
		for (int i = 0; i < 15000000; i++) {
			sb.append(i);
			String hash = createMD5(sb.toString());
			if (checkMD5(hash)) {
				code.append(getLetterMD5(hash));
			}
			
			sb.delete(str.length(), sb.length());
			
			if (code.length() == 8) {
				break;
			}
		}
		
		System.out.println(code);
	}
	
	public char getPositionMD5(String code) {
		return code.charAt(5);
	}
	
	public char getLetter2MD5(String code) {
		return code.charAt(6);
	}
	
	public char getLetterMD5(String code) {
		return code.charAt(5);
	}
	
	public boolean checkMD5(String code) {
		return code.startsWith("00000");
	}
	
	public String createMD5(String str) {
		try { 
			  
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
  
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(str.getBytes()); 
  
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
  
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
	}
	
	
	
	
}
