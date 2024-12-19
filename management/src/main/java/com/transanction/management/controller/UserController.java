package com.transanction.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.transanction.management.entity.User;
import com.transanction.management.model.BalanceModel;
import com.transanction.management.model.TransactionModel;
import com.transanction.management.service.UserService;

@RestController 
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok(userService.getUsersList()) ;
	}

	@GetMapping("/getUser/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable("userid") Long userId){
		return ResponseEntity.ok(userService.getUserById(userId).get()) ;
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<User> getUserById(@RequestBody User user){
		User userObj = userService.creatUser(user);
		return ResponseEntity.ok(userService.creatUser(userObj)) ;
	}
	
	@PostMapping("/addbalance")
	public ResponseEntity<Boolean> addBalance(@RequestBody BalanceModel balance){
		return ResponseEntity.ok(userService.addBalanceInWallet(balance.getUserId(), balance.getAmount())) ;
	}
	
	@PostMapping("/transferamount")
	public ResponseEntity<Boolean> transferamount(@RequestBody TransactionModel transaction){
		return ResponseEntity.ok(userService.transferFunds(transaction.getSender(), transaction.getReceiver(), transaction.getAmount())) ;
	}
	
}
