package com.main.northwind.core.dataAccess;

import com.main.northwind.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDaoInter extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
