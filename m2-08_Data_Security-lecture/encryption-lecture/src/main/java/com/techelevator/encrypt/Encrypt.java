package com.techelevator.encrypt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PasswordFinder;

public class Encrypt {

	public byte[] encrypt(Key pubkey, String text) {
		try {
			Cipher rsa;
			rsa = Cipher.getInstance("RSA");
			rsa.init(Cipher.ENCRYPT_MODE, pubkey);
			return rsa.doFinal(text.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String decrypt(Key decryptionKey, byte[] buffer) {
		try {
			Cipher rsa;
			rsa = Cipher.getInstance("RSA");
			rsa.init(Cipher.DECRYPT_MODE, decryptionKey);
			byte[] utf8 = rsa.doFinal(buffer);
			return new String(utf8, "UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public KeyPair readKeyPair(File privateKey, String keyPassword) throws IOException {
		FileReader fileReader = new FileReader(privateKey);
		PEMReader r = new PEMReader(fileReader, new DefaultPasswordFinder(keyPassword.toCharArray()));
		try {
			return (KeyPair) r.readObject();
		} catch (IOException ex) {
			throw ex;
		} finally {
			r.close();
			fileReader.close();
		}
	}

	public PublicKey readPublicKey(File privateKey, String keyPassword) throws IOException {
		FileReader fileReader = new FileReader(privateKey);
		PEMReader r = new PEMReader(fileReader, new DefaultPasswordFinder(keyPassword.toCharArray()));
		try {
			return (PublicKey) r.readObject();
		} catch (IOException ex) {
			throw ex;
		} finally {
			r.close();
			fileReader.close();
		}
	}

	private static class DefaultPasswordFinder implements PasswordFinder {

		private final char[] password;

		private DefaultPasswordFinder(char[] password) {
			this.password = password;
		}

		@Override
		public char[] getPassword() {
			return Arrays.copyOf(password, password.length);
		}
	}
	

}
