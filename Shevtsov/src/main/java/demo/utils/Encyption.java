package demo.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encyption {

    public static byte[] ecrypt(String plainTest) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = null;
        md = MessageDigest.getInstance("SHA-256");
        md.update(plainTest.getBytes("UTF-8"));
        return md.digest();
    }
}
