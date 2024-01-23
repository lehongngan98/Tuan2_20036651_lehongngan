package sv.iuh.SpringJWT.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import sv.iuh.SpringJWT.dtos.SingupRequest;
import sv.iuh.SpringJWT.dtos.UserDTO;
import sv.iuh.SpringJWT.services.AuthService;

@RestController
public class UserSignUpController {

	@Autowired
	private AuthService authService;
	
	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody SingupRequest signupRequest){
		UserDTO createUser = authService.createUser(signupRequest);
		if(createUser == null) {
			return new ResponseEntity<>("User is not create",HttpStatus.BAD_REQUEST);
			
		}
		return new ResponseEntity<>(createUser,HttpStatus.CREATED);
	}
}
