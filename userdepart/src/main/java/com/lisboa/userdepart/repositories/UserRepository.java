package com.lisboa.userdepart.repositories;

import com.lisboa.userdepart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    default User findByUserEmail(String email){
        return null;
    }

}
