package com.dailycodework.sbrdemo.repository;

import com.dailycodework.sbrdemo.model.Peoples;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Simpson Alfred
 */

@Repository
public interface PeopleRepository extends JpaRepository<Peoples, Long> {
    Optional<Peoples> findByEmail(String email);
}
