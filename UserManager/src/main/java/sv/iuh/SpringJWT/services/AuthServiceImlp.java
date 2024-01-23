	package sv.iuh.SpringJWT.services;
	
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
	import org.springframework.stereotype.Service;
	
	import sv.iuh.SpringJWT.dtos.SingupRequest;
	import sv.iuh.SpringJWT.dtos.UserDTO;
	import sv.iuh.SpringJWT.entity.User;
	import sv.iuh.SpringJWT.repositories.UserRepository;
	
	@Service
	public class AuthServiceImlp implements AuthService{
	
		@Autowired
		private UserRepository userRepository;
	
		@Override
		public UserDTO createUser(SingupRequest singupRequest) {
			User user = new User();
			user.setEmail(singupRequest.getEmail());
			user.setName(singupRequest.getName());
			user.setPassword(new BCryptPasswordEncoder().encode(singupRequest.getPassword()));
			User createdUser = userRepository.save(user);
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail(createdUser.getEmail());
			userDTO.setId(createdUser.getId());
			userDTO.setName(createdUser.getName());
			userDTO.setPassword(createdUser.getPassword());
			return userDTO;
			
		}
	}
