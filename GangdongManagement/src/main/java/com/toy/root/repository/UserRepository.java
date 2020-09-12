package com.toy.root.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;

@Repository
public interface UserRepository extends JpaRepository<DbUser, Long>{

	List<DbUser> findByNickname(String nickname);

	List<DbUser> findAllByNickname(String nickname);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET alive = 0 WHERE id = :user_id ;" , nativeQuery = true)
	void deleteById(@Param("user_id") Long i);	
	
	@Transactional
	@Query(value = "SELECT * FROM user WHERE alive=1;" , nativeQuery = true)
	List<DbUser> findAllbyAlive();
	
}


