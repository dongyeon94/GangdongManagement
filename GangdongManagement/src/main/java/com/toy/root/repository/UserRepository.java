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
	
	
	@Transactional
	@Query(value = "SELECT *  " +
			"FROM user left outer join party " +
			"on user.id = party.userpkid and date between :st and :en " +
			"WHERE alive=1 group by user.id " +
			"having count(party.userpkid)  >= ( " +
			"	SELECT count(*) FROM GangdongGu.party " +
			"	where date between :st and :en " +
			"	group by userpkid " +
			"	order by count(*) desc " +
			"	limit 1 );" ,nativeQuery = true)
	public List<DbUser> bestPartyJoinUser(@Param("st") String st, @Param("en") String en);
	
}


