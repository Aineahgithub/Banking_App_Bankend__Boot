package com.itf.schulung.springboot.fullstack.controller;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itf.schulung.springboot.fullstack.model.Account;
import com.itf.schulung.springboot.fullstack.model.AccountFactory;
import com.itf.schulung.springboot.fullstack.model.Address;
import com.itf.schulung.springboot.fullstack.model.Customer;
import com.itf.schulung.springboot.fullstack.model.CustomerFactory;
import com.itf.schulung.springboot.fullstack.model.Login;
import com.itf.schulung.springboot.fullstack.repositorys.AccountRepository;
import com.itf.schulung.springboot.fullstack.repositorys.AddressRepository;
import com.itf.schulung.springboot.fullstack.repositorys.CustomerRepository;
import com.itf.schulung.springboot.fullstack.repositorys.LoginRepository;

@RestController
public class MyRestController {

	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private AccountRepository AccountRepo;
	@Autowired
	private AddressRepository addressrepo;
<<<<<<< HEAD:OnlineBanking_Backend/Banking_App_Bankend_Boot/src/main/java/com/itf/schulung/springboot/fullstack/controller/MyRestController.java
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	LoginRepository loginRepo;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/postCustomer", consumes = "application/json")
	public ResponseEntity<?> postCustomer(@RequestBody Customer receivedCustomer, Long id ) {
	
=======

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/postCustomer", consumes = "application/json")
	public ResponseEntity<?> postCustomer(@RequestBody Customer receivedCustomer) {
>>>>>>> 8286a10a6dc0a4e14419fe95494156b5ed5b5a97:Banking_App_Bankend_Boot/src/main/java/com/itf/schulung/springboot/fullstack/controller/MyRestController.java
		customerRepo.save(receivedCustomer);
		return new ResponseEntity<>(receivedCustomer, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/postCustomers", consumes = "application/json")
	public ResponseEntity<?> postCustomers(@RequestBody List<Customer> receivedCustomers) {
		customerRepo.saveAll(receivedCustomers);
		return new ResponseEntity<>(receivedCustomers, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value ="/getCustomers")
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> allCustomers = customerRepo.findAllByOrderByIdDesc();
		return new ResponseEntity<>(allCustomers, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getCustomers/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
		Optional<Customer> possiblyFoundCustomer = customerRepo.findById(id);
				if (!possiblyFoundCustomer.isPresent()) {

			return new ResponseEntity<>("No Customer found with ID: " + id, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(possiblyFoundCustomer.get(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/postAccount", consumes = "application/json")
	public ResponseEntity<?> postAccount(@RequestBody Account receivedAccount, Long id) {	
		AccountRepo.save(receivedAccount);
		return new ResponseEntity<>(receivedAccount, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(value = "/postAddress", consumes = "application/json")
	public ResponseEntity<?> postAddress(@RequestBody Address receivedAddress) {
		addressrepo.save(receivedAddress);
		return new ResponseEntity<>(receivedAddress, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getAccounts")
	public ResponseEntity<?> getAllAccounts() {
		List<Account> allAccounts = AccountRepo.findAllByOrderByIdDesc();
		return new ResponseEntity<>(allAccounts, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getAddresses")
	public ResponseEntity<?> getAllAddresses() {
		List<Address> allAddresses = addressrepo.findAll();
		return new ResponseEntity<>(allAddresses, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(value = "/getAccounts/{id}")
	public ResponseEntity<?> getAccountsById(@PathVariable Integer id) {
		Optional<Account> possiblyFoundAccount = AccountRepo.findById(id);
				if (!possiblyFoundAccount.isPresent()) {
			return new ResponseEntity<>("No Account found with ID: " + id, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(possiblyFoundAccount.get(), HttpStatus.OK);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteAccount/{id}")
	public void deleteAccount(@PathVariable Integer id) throws AccountNotFoundException {
		AccountRepo.findById(id).orElseThrow(AccountNotFoundException::new);
		AccountRepo.deleteById(id);
	}

	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomer(@PathVariable Long id) throws AccountNotFoundException {
		customerRepo.findById(id).orElseThrow(AccountNotFoundException::new);
		customerRepo.deleteById(id);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(value = "/updateAccount/{id}")
	public Account updateAccount(@RequestBody Account account, @PathVariable Integer id)
			throws AccountIdMismatchException, AccountNotFoundException {
		AccountRepo.findById(id).orElseThrow(AccountNotFoundException::new);
		account.setAccountNr(account.getAccountNr());
		account.setBalance(account.getBalance());

		return AccountRepo.save(account);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(value = "/updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
			throws AccountIdMismatchException, AccountNotFoundException {

		customerRepo.findById(id).orElseThrow(AccountNotFoundException::new).setFirstName(customer.getFirstName());
		;
		customer.setLastName(customer.getLastName());
		customer.setTelephone(customer.getTelephone());
		customer.setEmail(customer.getEmail());
		customer.setLogin(customer.getLogin());
		return customerRepo.save(customer);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PutMapping(value = "/updateAddress/{id}")
	public Address updateAddress(@RequestBody Address address, @PathVariable Integer id)
			throws AccountIdMismatchException, AccountNotFoundException {
		addressrepo.findById(id).orElseThrow(AccountNotFoundException::new).setStreet(address.getStreet());
		address.setCity(address.getCity());

		address.setZipCode(address.getZipCode());
		address.setCountry(address.getCountry());

		return addressrepo.save(address);
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/deleteAdress/{id}")
	public void deleteAddress(@PathVariable Integer id) throws AccountNotFoundException {
		addressrepo.findById(id).orElseThrow(AccountNotFoundException::new);

		addressrepo.deleteById(id);
	}

}
