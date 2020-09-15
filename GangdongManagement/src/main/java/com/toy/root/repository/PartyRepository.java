package com.toy.root.repository;

import java.sql.Date;
import java.time.LocalDate;
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
	@Query(value = "SELECT date FROM party order by date limit 1;" ,nativeQuery = true)
	public LocalDate startPartyMonth();
	
	@Transactional
	@Query(value = "SELECT date FROM party order by date desc limit 1;" ,nativeQuery = true)
	public LocalDate lastPartyMonth();
	
	@Transactional
	@Query(value = "SELECT user.nickname , count(party.userpkid) " +
			"FROM user left outer join party " +
			"on user.id = party.userpkid and date between :st and :en " +
			"WHERE alive=1 group by user.id " +
			"having count(party.userpkid)  >= ( " +
			"	SELECT count(*) FROM GangdongGu.party " +
			"	where date between :st and :en " +
			"	group by userpkid " +
			"	order by userpkid " +
			"	limit 1 );" ,nativeQuery = true)
	public List bestPartyJoinUser(@Param("st") String st, @Param("en") String en);
	
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
			+ "group by user.id  order by user.id;" ,nativeQuery = true)
	List userPartyCount(@Param("st") String start, @Param("en") String end);

}
