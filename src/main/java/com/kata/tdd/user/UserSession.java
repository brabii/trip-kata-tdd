package com.kata.tdd.user;

import com.kata.tdd.exception.DependendClassCallDuringUnitTestException;

/**
 * singleton
 * 
 * @author rabii
 *
 */
public class UserSession {

	private static final UserSession userSession = new UserSession();

	private UserSession() {
	}

	public static UserSession getInstance() {
		return userSession;
	}

	public boolean isUserLoggedIn(User user) {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.isUserLoggedIn() should not be called in unit tests");
	}

	public User getLoggedUser() {
		throw new DependendClassCallDuringUnitTestException(
				"UserSession.getLoggedUser() should not be called in unit tests");
	}
	
}
