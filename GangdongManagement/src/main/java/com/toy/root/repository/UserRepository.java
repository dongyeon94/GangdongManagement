package com.toy.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.toy.root.db.DbUser;

public interface UserRepository extends JpaRepository<DbUser, Long>{

}
