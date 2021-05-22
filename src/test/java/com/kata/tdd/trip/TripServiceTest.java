package com.kata.tdd.trip;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;

import com.kata.tdd.exception.UserNotLoggedInException;
import com.kata.tdd.user.User;

public class TripServiceTest {

	private static final User GUEST = null;
	private static final User UNUSED_USER = null;
	private static final User TERRY = new User();
	private static final User REGISTERED_USER = new User();
	private static final Trip TO_BRAZIL = new Trip();
	private static final Trip TO_LONDON = new Trip();
	private User loggedInUser;
	TripService tripService;

	@Test(expected = UserNotLoggedInException.class)
	public void shouldThrowExecptionWhenUserNotLoggedIn() {
		tripService = new TestableTripService();
		loggedInUser = GUEST;
		tripService.getTripsByUser(UNUSED_USER);
	}

	@Test
	public void shouldNotReturnAnyTripsWhenUsersAreNotFriends() {
		User friend = new User();
		tripService = new TestableTripService();
		loggedInUser = REGISTERED_USER;
		friend.addFriend(TERRY);
		friend.addTrip(TO_BRAZIL);
		List<Trip> trips = tripService.getTripsByUser(friend);
		assertTrue(trips.size() == 0);
	}

	@Test
	public void shouldReturnListOfTripsWhenUsersAreFriends() {
		User friend = new User();
		tripService = new TestableTripService();
		loggedInUser = REGISTERED_USER;
		friend.addFriend(TERRY);
		friend.addTrip(TO_BRAZIL);
		friend.addFriend(loggedInUser);
		friend.addTrip(TO_LONDON);
		List<Trip> trips = tripService.getTripsByUser(friend);
		assertTrue(trips.size() == 2);
	}

	private class TestableTripService extends TripService {

		@Override
		protected User getLoggedUser() {
			return loggedInUser;
		}

		@Override
		protected List<Trip> tripBy(User user) {
			return user.trips();
		}
	}
}
