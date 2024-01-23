package sv.iuh.SpringJWT.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sv.iuh.SpringJWT.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	 User findFirstByEmail(String email);
}
