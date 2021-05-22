package com.kata.tdd.trip;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.kata.tdd.exception.UserNotLoggedInException;
import com.kata.tdd.user.User;

public class TripServiceTest {

	private static final User GUEST = null;
	private static final User UNUSED_USER = null;
	private static final User PAUL = new User();
	private static final User TERRY = new User();
	private static final User REGISTERED_USER = new User();
	private static final Trip TO_BRAZIL = new Trip();
	private User loggedInUser;
	TripService tripService;

	@Before
	public void initialise() {
		tripService = new TestableTripService();
	}

	@Test(expected = UserNotLoggedInException.class)
	public void shouldThrowExecptionWhenUserNotLoggedIn() {
		loggedInUser = GUEST;
		tripService.getTripsByUser(UNUSED_USER);
	}

	@Test
	public void shouldNotReturnAnyTripsWhenUsersAreNotFriends() {
		loggedInUser = REGISTERED_USER;
		PAUL.addFriend(TERRY);
		PAUL.addTrip(TO_BRAZIL);
		TripService tripService = new TestableTripService();
		List<Trip> trips = tripService.getTripsByUser(PAUL);
		assertTrue(trips.size() == 0);
	}

	private class TestableTripService extends TripService {

		@Override
		protected User getLoggedUser() {
			return loggedInUser;
		}
	}
}
