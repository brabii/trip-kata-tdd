package com.kata.tdd.trip;

import java.util.List;

import com.kata.tdd.exception.CollaboratorCallException;
import com.kata.tdd.user.User;

public class TripDao {

	public static List<Trip> findTripsByUser(User user) {
		throw new CollaboratorCallException("TripDAO should not be invoked on an unit test.");
	}
}
