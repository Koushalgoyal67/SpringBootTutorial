package com.koushal.sceureapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.koushal.sceureapp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
