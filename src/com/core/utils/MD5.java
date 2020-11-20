package com.core.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	
	
	
	public static String getMD5_50(String context) {
		
		for (int i = 0; i < 50; i++) {
			context = getMD5(context);
		}
		return context;
		
	}

    public static String getMD5(String context){

        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(context.getBytes());
            return getHashString(messageDigest);
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return null;
    }

    private static String getHashString(MessageDigest messageDigest) {

        StringBuffer builder = new StringBuffer();
        for (byte b:messageDigest.digest()) {
            builder.append(Integer.toHexString(b>>4 & 0xf));
            builder.append(Integer.toHexString(b & 0xf));
        }
        return  builder.toString();
    }



}