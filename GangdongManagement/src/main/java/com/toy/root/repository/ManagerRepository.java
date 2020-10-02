package com.toy.root.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toy.root.db.DbManager;

@Repository
public interface ManagerRepository extends JpaRepository<DbManager, Long>{

	Optional<DbManager> findByName(String username);

}
