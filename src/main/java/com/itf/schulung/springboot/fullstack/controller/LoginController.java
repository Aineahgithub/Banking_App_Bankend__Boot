package com.itf.schulung.springboot.fullstack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itf.schulung.springboot.fullstack.model.Login;
import com.itf.schulung.springboot.fullstack.repositorys.LoginRepository;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginRepository loginRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("")
	public ResponseEntity<Void> checkLogin(@RequestBody Login login) {
		return loginRepository.findByUsername(login.getUsername()).map(dbLogin -> {
			if (isPasswordMatch(login.getPasswort(), dbLogin.getPasswort())) {
				return new ResponseEntity<Void>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			}
		}).orElse(new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED));
	}

	private boolean isPasswordMatch(String unencrypted, String encrypted) {
		return passwordEncoder.encode(unencrypted).equals(encrypted);
	}
}
