package com.dzionsla.aoc2016.day14;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeMD5 {
	private static String input = "zpqevtbw";
	private static String input1 = "abc";
	private static String input2 = "abc18";
	
	public CodeMD5() {
		loopHash();
		
		//System.out.println(loopHashing("abc0", 2016));
	}
	
	private void loopHash() {
		Integer counter = 0;
		for (int i = 0; counter <= 64; i++) {
			String hash = loopHashing(joinString(i), 2016);
			String compareTo = checkThreeOfKind(hash);
			System.out.println(compareTo + " - " + i);
			if (compareTo != null) {
				//System.out.println(compareTo + " i = " + i + " - " + hash);
				
				for (int j = i + 1; j <= i + 1000; j++) {
					String hashInner = loopHashing(joinString(j), 2016);
					//System.out.println(hashInner + " - " + j);
					if (checkFiveOfKind(hashInner, compareTo) != null) {
						counter++;
						System.out.println(" i = " + i + " j = " + j + " counter = " + counter + " hash: " + hashInner);
						break;
					}
				}
				
			}
		}
	}
	
//	private Boolean loopFiveOfKind(Integer i) {
//		for (int j = i; j < i + 1000; j++) {
//			String hashInner = createMD5(joinString(j));
//			System.out.println(checkFiveOfKind(hashInner) + " " + j);
//			if (checkFiveOfKind(hash) != null) {
//				break;
//			}
//		}
//	}
	private String loopHashing(String str, Integer howMany) {
		String localStr = str;
		for (int i = 0; i <= howMany; i++) {
			localStr = createMD5(localStr);
		}
		
		return localStr;
	}
	
	private String checkThreeOfKind(String hash) {
		Pattern p = Pattern.compile("([a-z\\d])\\1\\1");
		Matcher m = p.matcher(hash);

		if (!m.find()) {
			return null;  
        } else {
        	//System.out.println(m.group(0));
        	return m.group(0);
        }
	}
	
	private String checkFiveOfKind(String hash, String compareTo) {
		Pattern p = Pattern.compile("([a-z\\d])\\1\\1\\1\\1");
		Matcher m = p.matcher(hash);

		if (!m.find()) {
			return null;  
        } else {
        	//System.out.println(compareTo + " - " + m.group(0));
        	if (m.group(0).contains(compareTo)) {
        		//System.out.println(m.group(0));
        		return m.group(0);
			} else {
				//System.out.println(compareTo + " - " + m.group(0));
				return null;
			}
        }
	}
	
	private String joinString(Integer i) {
		return input + i;
	}

	private String createMD5(String str) {
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
