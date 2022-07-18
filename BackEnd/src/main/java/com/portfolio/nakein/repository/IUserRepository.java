package com.portfolio.nakein.repository;

import com.portfolio.nakein.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User,Integer>{
    User findByEmail(String email);
}
