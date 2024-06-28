package main.java;

import main.java.domain.Gender;
import main.java.service.OnlineDatingService;

public class Main {
	private static OnlineDatingService onlineDatingService;
	public static void main(String[] args) {
		System.out.println("Online dating app started");
		
		onlineDatingService=new OnlineDatingService();
		
		createAccount("user1", 2, 3, Gender.MALE, 24);
		createAccount("user2", 2, 3, Gender.MALE, 24);
		createAccount("user3", 2, 3, Gender.FEMALE, 24);
		createAccount("user4", 2, 3, Gender.FEMALE, 24);
		
		potentialMatches("user1");
		potentialMatches("user2");
		potentialMatches("user3");
		potentialMatches("user4");
		
		likeUser("user1", "user3");
		likeUser("user2", "user4");
		likeUser("user3", "user1");
		
		showAllMatches();
		
		deleteUser("user2");
		System.out.println("Online dating app stopped");
	}

	private static void deleteUser(String userId) {
		System.out.println("Deleting user, "+userId);
		onlineDatingService.deleteUser(userId);
	}

	private static void showAllMatches() {
		System.out.println("Showing all matches");
		onlineDatingService.showAllMatches();
	}

	private static void likeUser(String user1, String user2) {
		System.out.println(user1+" liked user "+user2);
		onlineDatingService.likeUser(user1, user2);
	}

	private static void potentialMatches(String userId) {
		System.out.println("Searching for potential matches, "+userId);
		onlineDatingService.printAllPotentialMatches(userId);
	}

	private static void createAccount(String userId, int latitude, int longitude, Gender gender, int age) {
		onlineDatingService.signinUser(userId, latitude, longitude, gender, age);
		System.out.println("Signing User successfull");
	}

}
