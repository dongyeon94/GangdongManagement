package com.toy.root.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.root.db.DbUser;

@Repository
public interface UserRepository extends JpaRepository<DbUser, Long>{

	List<DbUser> findByNickname(String nickname);

	List<DbUser> findAllByNickname(String nickname);

	void deleteById(Long i);
	
}


