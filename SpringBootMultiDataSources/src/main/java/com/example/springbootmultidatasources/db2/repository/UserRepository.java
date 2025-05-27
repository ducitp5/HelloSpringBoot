package com.example.springbootmultidatasources.db2.repository;

import com.example.springbootmultidatasources.db2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}