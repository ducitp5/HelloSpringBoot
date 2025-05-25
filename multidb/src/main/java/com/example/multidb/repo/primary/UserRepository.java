package com.example.multidb.repo.primary;

import com.example.multidb.model.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
