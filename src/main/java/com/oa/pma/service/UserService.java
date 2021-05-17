package com.oa.pma.service;

import com.oa.pma.dao.UserRepository;
import com.oa.pma.entity.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public void save(UserAccount user){
		userRepository.save(user);
	}
	
}
