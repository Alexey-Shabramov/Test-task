package com.test.task.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;

public class PasswordUtil {
    private static byte[] dataRegisterSet = {0x22, 0x54, 0x13, 0xA, 0x4E, 0x0C, 0x0F, 0x39};

    public static String encryptPassword(String password) {
        byte[] keyArray = new byte[24];
        byte[] temporarySetKey;
        byte[] encryptionArray;
        String encodeKey = "SDKLFGdfsdfsdfKSNGSsdfsdfSLFsdfsdfSKLsdfsdfsdfK";
        String encryptedPasswordValue = "";
        try {
            encryptionArray = password.getBytes("UTF-8");
            MessageDigest message = MessageDigest.getInstance("MD5");
            temporarySetKey = message.digest(encodeKey.getBytes("UTF-8"));
            if (temporarySetKey.length < 24) {
                int index = 0;
                for (int i = temporarySetKey.length; i < 24; i++) {
                    keyArray[i] = temporarySetKey[index];
                }
            }
            Cipher c = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            c.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keyArray, "DESede"), new IvParameterSpec(dataRegisterSet));
            byte[] encryptionOutput = c.doFinal(encryptionArray);
            encryptedPasswordValue = Base64.encodeBase64String(encryptionOutput);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encryptedPasswordValue;
    }
}
