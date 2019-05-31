package com.itf.schulung.springboot.fullstack.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itf.schulung.springboot.fullstack.model.Login;
import com.itf.schulung.springboot.fullstack.repositorys.LoginRepository;
@Service
public class myLoginService implements UserDetailsService {
  
	@Autowired
	private LoginRepository logoRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> user = logoRepo.findByUsername(username);
		if(user==null)
		throw new UsernameNotFoundException(" such user does not exist");
		return new LoginPrinciple(user);
	}

}
