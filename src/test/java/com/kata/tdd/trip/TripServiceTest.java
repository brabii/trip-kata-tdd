package com.kata.tdd.trip;

import org.junit.Test;

import com.kata.tdd.exception.UserNotLoggedInException;
import com.kata.tdd.user.User;

public class TripServiceTest {

	private static final User GUEST = null;
	private static final User UNUSED_USER = null;
	private User loggedInUser;

	@Test(expected = UserNotLoggedInException.class)
	public void shouldThrowExecptionWhenUserNotLoggedIn() {
		TripService tripService = new TestableTripService();
		loggedInUser = GUEST;
		tripService.getTripsByUser(UNUSED_USER);
	}

	private class TestableTripService extends TripService {

		@Override
		protected User getLoggedUser() {
			return loggedInUser;
		}
	}
}
