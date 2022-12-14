package com.interview.repo;

import com.interview.model.Genderize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenderizeRepository extends JpaRepository<Genderize, Integer> {

    Optional<Genderize> findByName(String name);
}