package main.java.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class OnlineDating {

	private Map<String, Set<String>> matchesMap;
	private Map<String, Account> accounts;
	private Map<String, Set<String>> usersLikedMap;
	private Set<String> deletedAccounts;
	public OnlineDating() {
		super();
		matchesMap=new HashMap();
		accounts=new HashMap();
		usersLikedMap=new HashMap();
		deletedAccounts=new HashSet();
	}
	public Map<String, Set<String>> getMatchesMap() {
		return matchesMap;
	}
	public void setMatchesMap(Map<String, Set<String>> matchesMap) {
		this.matchesMap = matchesMap;
	}
	public Map<String, Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(Map<String, Account> accounts) {
		this.accounts = accounts;
	}
	public Map<String, Set<String>> getUsersLikedMap() {
		return usersLikedMap;
	}
	public void setUsersLikedMap(Map<String, Set<String>> usersLikedMap) {
		this.usersLikedMap = usersLikedMap;
	}
	public Set<String> getDeletedAccounts() {
		return deletedAccounts;
	}
	public void setDeletedAccounts(Set<String> deletedAccounts) {
		this.deletedAccounts = deletedAccounts;
	}
}
