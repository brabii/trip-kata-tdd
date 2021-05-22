package com.kata.tdd.trip;

import java.util.ArrayList;
import java.util.List;

import com.kata.tdd.exception.UserNotLoggedInException;
import com.kata.tdd.user.User;
import com.kata.tdd.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
		User loggedUser = getLoggedUser();

		if (loggedUser == null) {
			throw new UserNotLoggedInException();
		}
		return user.isFriendsWith(loggedUser) ? tripBy(user) : noFriends();
	}

	public ArrayList<Trip> noFriends() {
		return new ArrayList<>();
	}

	protected List<Trip> tripBy(User user) {
		return TripDao.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
}
