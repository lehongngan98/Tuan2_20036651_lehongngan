package sv.iuh.SpringJWT.services;

import sv.iuh.SpringJWT.dtos.SingupRequest;
import sv.iuh.SpringJWT.dtos.UserDTO;

public interface AuthService {

	UserDTO createUser(SingupRequest singupRequest);
}
