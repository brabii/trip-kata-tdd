package com.kata.tdd.user;

import static com.kata.tdd.trip.UserBuilder.aUser;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTest {

	private static final User BOB = new User();
	private static final User JEFFREY = new User();

	@Test
	public void shouldReturnFalseWhenTheyAreNotFriends() {
		// @formatter:off
		User user = aUser()
						.withFriends(BOB)
						.build();
		// @formatter:off
		assertFalse(user.isFriendsWith(JEFFREY));
	}

	@Test
	public void shouldReturnTrueWhenTheyAreFriends() {
		// @formatter:off
		User user = aUser()
					.withFriends(BOB,JEFFREY)
					.build();
		// @formatter:off
		assertTrue(user.isFriendsWith(JEFFREY));
	}
}
