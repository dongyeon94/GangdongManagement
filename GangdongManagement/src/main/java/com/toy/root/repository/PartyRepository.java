package com.toy.root.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toy.root.db.DbParty;

@Repository
public interface PartyRepository extends JpaRepository<DbParty, Long>{

	@Transactional
	@Query(value = "SELECT * FROM GangdongGu.party where "
			+ "date between :st and :en ;" ,nativeQuery = true)
	List<DbParty> findAllBetween(@Param("st") String start, @Param("en") String end);
	
	@Transactional
	@Query(value = "SELECT * FROM GangdongGu.party where "
			+ "date between :st and :en and userpkid = :user  ;" ,nativeQuery = true)
	List<DbParty> findUserCurrentTime(@Param("user") int user  ,@Param("st") String start, @Param("en") String end);
	
	@Transactional
	@Query(value = "SELECT user.nickname ,count(*) as count FROM GangdongGu.party, user "
			+ "where party.userpkid = user.id and date between :st and :en  group by userpkid;" ,nativeQuery = true)
	List userPartyCount(@Param("st") String start, @Param("en") String end);
				
}
