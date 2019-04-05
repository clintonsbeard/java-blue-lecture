package com.techelevator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.techelevator.model.Actor;

public class JavaRestApiClient {

	private static final String API_URL = "http://localhost:8080/API-vanilla-JS-Example/api/actors";
	
	public static void main(String[] args) {
		JavaRestApiClient client = new JavaRestApiClient();
		client.start();
	}
	
	public void start() {
		
		Scanner in = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("Search term >>");
			String searchTerm = in.nextLine();
			
			List<Actor> actors = consumeRestService(searchTerm);
			
			System.out.println("Actors Returned from API:");
			for (Actor actor : actors) {
				System.out.println(actor.getFirstName() + " " + actor.getLastName());
			}
			
			System.out.println();
		}
	}
	
	
	private List<Actor> consumeRestService(String searchTerm) {
		
		String url = API_URL;
		if (searchTerm != null && searchTerm.trim().length() > 0) {
			url += "?searchTerm=" + searchTerm;
		}
	     Client client = ClientBuilder.newClient();

	      Response response = client.target(url).request().get();
	      Actor[] actors = response.readEntity(Actor[].class);
	      //String responseAsString = response.readEntity(String.class);

	      response.close();
	      client.close();

	      return Arrays.asList(actors);
		
	}
}
