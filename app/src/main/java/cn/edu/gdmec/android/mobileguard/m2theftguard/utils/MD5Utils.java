package cn.edu.gdmec.android.mobileguard.m2theftguard.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by 10255 on 2017/10/9.
 */

public class MD5Utils {
    public static String encode(String text){
        try{
            MessageDigest digest=MessageDigest.getInstance("md5");
            byte[] result=digest.digest();
            StringBuffer sb=new StringBuffer();
            for(byte b:result){
                int number=b&0xff;
                String hex=Integer.toHexString(number);
                if(hex.length()==1){
                    sb.append("0"+hex);
                }else {
                    sb.append(hex);
                }
            }
            return sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
            return "";

        }
    }
}
