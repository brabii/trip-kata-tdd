package com.kata.tdd.trip;

import java.util.ArrayList;
import java.util.List;

import com.kata.tdd.exception.UserNotLoggedInException;
import com.kata.tdd.user.User;
import com.kata.tdd.user.UserSession;

public class TripService {

	public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {

		List<Trip> tripList = new ArrayList<>();
		User loggedUser = getLoggedUser(); // ceci va lancer une exception
		boolean isFriend = false;

		if (loggedUser != null) {
			for (User friend : user.getFriends()) {
				if (friend.equals(loggedUser)) {
					isFriend = true;
					break;
				}
			}
			if (isFriend) {
				tripList = tripBy(user);
			}
			return tripList;
		} else {
			throw new UserNotLoggedInException();
		}
	}

	protected List<Trip> tripBy(User user) {
		return TripDao.findTripsByUser(user);
	}

	protected User getLoggedUser() {
		return UserSession.getInstance().getLoggedUser();
	}
}
