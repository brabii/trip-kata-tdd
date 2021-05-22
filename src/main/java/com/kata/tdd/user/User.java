package com.kata.tdd.user;

import java.util.ArrayList;
import java.util.List;

import com.kata.tdd.trip.Trip;

public class User {

	private List<Trip> trips = new ArrayList<>();
	private List<User> friends = new ArrayList<>();

	public List<User> getFriends() {
		return friends;
	}

	public void addFriend(User friend) {
		this.friends.add(friend);
	}

	public List<Trip> trips() {
		return trips;
	}

	public void addTrip(Trip trip) {
		this.trips.add(trip);
	}

}
