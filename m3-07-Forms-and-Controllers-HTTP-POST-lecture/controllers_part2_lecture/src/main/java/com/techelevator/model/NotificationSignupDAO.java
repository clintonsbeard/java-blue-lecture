package com.techelevator.model;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class NotificationSignupDAO {
	
	private PrintWriter writer;

	public NotificationSignupDAO(OutputStream outputDestination) {
		this.writer = new PrintWriter(outputDestination, true);
	}
	
	public void saveNotificationSignup(String firstName, String lastName, int age, String emailAddress) {
		LocalDateTime now = LocalDateTime.now();
		writer.println(now+"|"+lastName+", "+firstName+"|"+age+"|"+emailAddress);
	}
}
