package com.techelevator;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.Security;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;

import javax.crypto.Cipher;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.openssl.PasswordFinder;

import com.techelevator.encrypt.Encrypt;
import com.techelevator.file.FileAccess;

public class EncryptionTool {

	public static void main(String[] args) throws IOException {

	
		String publicKeyFilename = null;
		String inputFile = null;
		String outputFile = null;

		FileAccess fileAccess = new FileAccess();
		Encrypt encrypt = new Encrypt();

		if (args.length < 3) {
			System.err
					.println("Usage: java " + encrypt.getClass().getName() + " Public_Key_Filename Input_file_name Encrypted_file_name ");
			System.exit(1);
		}

		publicKeyFilename = args[0].trim();
		inputFile = args[1].trim();
		outputFile = args[2].trim();
		
		Security.addProvider(new BouncyCastleProvider());
		
		// Get the Text from the file as a String
		String text = fileAccess.readFileAsString(inputFile, StandardCharsets.UTF_8);
		
		// if the private key is not encrypted, pass can be anything.
		PublicKey publickey = encrypt.readPublicKey(new File(publicKeyFilename), "pass");

		byte[] encrypted = encrypt.encrypt(publickey, text);
		String encryptedText = new String(Base64.encode(encrypted));
		fileAccess.writeFileFromString(encryptedText, outputFile);
		System.out.println("Contents encrypted to " + outputFile);
		

	}



}
