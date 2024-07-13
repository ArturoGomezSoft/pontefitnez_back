package com.example.pontefitnez.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pontefitnez.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
