package com.fun.springForum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fun.springForum.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
