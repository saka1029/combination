package stackoverflow;

import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Encrypt {

    static Cipher cipher;
    static {
    	try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
    }

	public static String encrypt(String plainText, SecretKey secretKey)
	        throws Exception {
	    byte[] plainTextByte = plainText.getBytes();
	    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	    byte[] encryptedByte = cipher.doFinal(plainTextByte);
	    Encoder encoder = Base64.getEncoder(); //ERROR "cannot resolve method"
	    String encryptedText = encoder.encodeToString(encryptedByte);
	    return encryptedText;
	}

	public static String decrypt(String encryptedText, SecretKey secretKey)
	        throws Exception {
	    Decoder decoder = Base64.getDecoder(); //ERROR "cannot resolve method"
	    byte[] encryptedTextByte = (byte[]) decoder.decode(encryptedText);
        byte iv[] = cipher.getIV();
        IvParameterSpec dps = new IvParameterSpec(iv);
	    cipher.init(Cipher.DECRYPT_MODE, secretKey, dps);
	    byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
	    String decryptedText = new String(decryptedByte);
	    return decryptedText;
	}
	
	public static void main(String[] args) throws Exception {
        KeyGenerator kg = KeyGenerator.getInstance("DES");
        SecretKey key = kg.generateKey();
        String org = "abcdefg";
        String encrypt = encrypt(org, key);
        String decrypt = decrypt(encrypt, key);
        System.out.printf("org=%s encrypt=%s decrypt=%s%n", org, encrypt, decrypt);
	}
}
