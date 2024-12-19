package com.transanction.management.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.transanction.management.entity.User;
import com.transanction.management.entity.Wallet;
import com.transanction.management.repository.UserRepository;
import com.transanction.management.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsersList() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}

	@Override
	public User creatUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public boolean addBalanceInWallet(Long userId, double amount) {
		
		User user = userRepository.findById(userId).get();
		
        if (user != null && user.getWallet() != null) {
            double newBalance = user.getWallet().getBalance() + amount;
            user.getWallet().setBalance(newBalance); 
            userRepository.save(user); 
            return true; 
        }
        return false; 
    
	}
	
	@Override
	 public boolean transferFunds(Long senderId, Long receiverId, double amount) {
	        User sender = userRepository.findById(senderId).get();
	        User receiver = userRepository.findById(receiverId).get();

	        if (sender != null && receiver != null && sender.getWallet() != null && receiver.getWallet() != null) {
	            double senderBalance = sender.getWallet().getBalance();
	            if (senderBalance >= amount) {
	              
	                sender.getWallet().setBalance(senderBalance - amount);
	                
	                double receiverBalance = receiver.getWallet().getBalance();
	                receiver.getWallet().setBalance(receiverBalance + amount);
	                
	                userRepository.save(sender);
	                userRepository.save(receiver);
	                return true; 
	            } else {
	                return false; 
	            }
	        }
	        return false; 
	    }

}
