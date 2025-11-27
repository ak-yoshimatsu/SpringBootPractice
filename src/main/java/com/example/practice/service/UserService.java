package com.example.practice.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public String getUserName(final int userId) {
		if (userId <= 0) {
			throw new IllegalArgumentException("ユーザーIDは1以上!!");
		}

		if (userId == 1) {
			return "Alice";
		} else if (userId == 2) {
			return "Bob";
		} else {
			return "Guest";
		}
	}
}
