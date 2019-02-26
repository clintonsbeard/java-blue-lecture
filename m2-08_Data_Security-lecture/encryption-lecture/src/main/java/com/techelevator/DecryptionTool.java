package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import com.techelevator.encrypt.Encrypt;
import com.techelevator.file.FileAccess;

public class DecryptionTool {

	public static void main(String[] args) throws IOException {
		
		String privateKeyFilename = null;
		String inputFile = null;
	

		FileAccess fileAccess = new FileAccess();
		Encrypt encrypt = new Encrypt();

		if (args.length < 2) {
			System.err
					.println("Usage: java " + encrypt.getClass().getName() + " Private_Key_Filename Encrypted_file_name ");
			System.exit(1);
		}

		privateKeyFilename = args[0].trim();
		inputFile = args[1].trim();

		Security.addProvider(new BouncyCastleProvider());
		
		KeyPair keyPair = encrypt.readKeyPair(new File(privateKeyFilename), "pass");
		
		String encryptedFileContents = fileAccess.readFileAsString(inputFile, StandardCharsets.UTF_8);
		byte[] toDecrypt = Base64.decode(encryptedFileContents);
		System.out.println("decrypt:\n" + encrypt.decrypt(keyPair.getPrivate(), toDecrypt));
		
	}

}
