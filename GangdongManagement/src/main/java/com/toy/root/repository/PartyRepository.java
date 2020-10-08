package com.toy.root.repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.toy.root.db.DbBestJoinCounter;
import com.toy.root.db.DbParty;
import com.toy.root.db.DbUser;

@Repository
public interface PartyRepository extends JpaRepository<DbParty, Long>{
	
	
	@Transactional
	@Query(value = "SELECT date FROM party order by date limit 1;" ,nativeQuery = true)
	public Timestamp startPartyMonth();
	
	@Transactional
	@Query(value = "SELECT date FROM party order by date desc limit 1;" ,nativeQuery = true)
	public Timestamp lastPartyMonth();
	
	@Transactional
	@Query(value = "SELECT * FROM GangdongGu.party where "
			+ "date between :st and :en ;" ,nativeQuery = true)
	List<DbParty> findAllBetween(@Param("st") String start, @Param("en") String end);
	
	@Transactional
	@Query(value = "SELECT * FROM GangdongGu.party where "
			+ "date between :st and :en and userpkid = :user  ;" ,nativeQuery = true)
	List<DbParty> findUserCurrentTime(@Param("user") int user  ,@Param("st") String start, @Param("en") String end);
	
	@Transactional
	@Query(value = "SELECT user.nickname ,ifnull(count(party.userpkid), 0)  as count "			
			+ "FROM user left outer join party  on user.id = party.userpkid and date between :st and :en "
			+ "WHERE alive=1 "
			+ "group by user.id  order by count desc;" ,nativeQuery = true)
	List userPartyCount(@Param("st") String start, @Param("en") String end);

}
