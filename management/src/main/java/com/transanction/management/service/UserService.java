package com.transanction.management.service;

import java.util.List;
import java.util.Optional;

import com.transanction.management.entity.User;
public interface UserService {

	User creatUser(User user);
	List<User> getUsersList();
	Optional<User> getUserById(Long userId);
	boolean addBalanceInWallet(Long userId, double amount);
	public boolean transferFunds(Long senderId, Long receiverId, double amount);
}
