package com.kata.tdd.trip;

import org.junit.Test;

import com.kata.tdd.exception.UserNotLoggedInException;
import com.kata.tdd.user.User;

public class TripServiceTest {

	@Test(expected = UserNotLoggedInException.class)
	public void shouldThrowExecptionWhenUserNotLoggedIn() {
		TripService tripService = new TestableTripService();
		tripService.getTripsByUser(null);
	}

	private class TestableTripService extends TripService {

		@Override
		protected User getLoggedUser() {
			return null;
		}
	}
}
