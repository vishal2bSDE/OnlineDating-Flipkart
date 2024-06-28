package main.java.domain;

public class Account {

	private String userId;
	private int latitude;
	private int longitude;
	private int age;
	private Gender gender;
	public Account(String userId, int latitude, int longitude, Gender gender, int age) {
		super();
		this.userId = userId;
		this.latitude = latitude;
		this.longitude = longitude;
		this.gender = gender;
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Account [userId=" + userId + ", latitude=" + latitude + ", longitude=" + longitude + ", age=" + age
				+ ", gender=" + gender + "]";
	}
	
	
}
