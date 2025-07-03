package com.rest.rest_api;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<Coffee, String> {

  // Find coffees with names containing the keyword (case-insensitive)
  @Query("SELECT c FROM Coffee c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :keyword, '%'))")
  List<Coffee> findByNameContainingIgnoreCase(String keyword);
}
// This interface extends JpaRepository, which provides CRUD operations for the Coffee entity.
