package main.java.service;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import main.java.domain.Account;
import main.java.domain.Gender;
import main.java.domain.OnlineDating;

public class OnlineDatingService {

	private OnlineDating onlineDating;
	
	public OnlineDatingService() {
		super();
		onlineDating=new OnlineDating();
	}

	private int calculateDistance(Account a1, Account a2) {
		return (int)Math.sqrt(Math.pow(a1.getLatitude()-a2.getLatitude(), 2)+Math.pow(a1.getLongitude()-a2.getLongitude(), 2));
	}

	public void signinUser(String userId, int latitude, int longitude, Gender gender, int age) {
		System.out.println("Signing User started");
		Account account = new Account(userId, latitude, longitude, gender, age);
		onlineDating.getAccounts().put(userId, account);
	}

	public void printAllPotentialMatches(String userId) {
		Account user=onlineDating.getAccounts().get(userId);
		List<Account> potentialMatches=onlineDating.getAccounts().values().stream().filter(a1->a1.getUserId()!=userId)
				.sorted(Comparator.comparingInt((Account a1)->{
					int distance=calculateDistance(user, a1);
					int oppositeGender = user.getGender().equals(a1.getGender()) ? 0 : 1;
					int ageDiff = user.getAge()-a1.getAge();
					
					return distance+oppositeGender+ageDiff;
				})).collect(Collectors.toList());
		
		for(Account account : potentialMatches) {
			System.out.println(account.toString());
		}
	}

	public void likeUser(String user1, String user2) {
		Map<String, Set<String>> usersLikedMap = onlineDating.getUsersLikedMap();
		if(!usersLikedMap.containsKey(user1))usersLikedMap.put(user1, new HashSet());
		if(!usersLikedMap.containsKey(user2))usersLikedMap.put(user2, new HashSet());
		usersLikedMap.get(user1).add(user2);
		if(usersLikedMap.get(user1).contains(user2) && usersLikedMap.get(user2).contains(user1)) {
			Map<String, Set<String>> matchesMap = onlineDating.getMatchesMap();
			if(!matchesMap.containsKey(user1))matchesMap.put(user1, new HashSet());
			if(!matchesMap.containsKey(user2))matchesMap.put(user2, new HashSet());
			
			matchesMap.get(user1).add(user2);
			matchesMap.get(user2).add(user1);
			
			System.out.println(user1+" matched with "+user2);
		}
		
	}

	public void showAllMatches() {
		Map<String, Set<String>> matchesMap = onlineDating.getMatchesMap();
		
		matchesMap.forEach((k, v)->{
			for(String match:v) {
				System.out.println(k+" is a match with "+match);
			}
		});
	}

	public void deleteUser(String userId) {
		onlineDating.getDeletedAccounts().add(userId);
		Map<String, Set<String>> matchesMap = onlineDating.getMatchesMap();
		Map<String, Set<String>> usersLikedMap = onlineDating.getUsersLikedMap();
		if(matchesMap.containsKey(userId)) {
			for(String match:matchesMap.get(userId)) {
				if(matchesMap.containsKey(match))matchesMap.get(match).remove(userId);
			}
			matchesMap.remove(userId);
		}
		if(usersLikedMap.containsKey(userId))usersLikedMap.remove(userId);
		System.out.println("Deleted user, "+userId);
	}
}
