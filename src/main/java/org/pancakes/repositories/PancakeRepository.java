package org.pancakes.repositories;

import javax.transaction.Transactional;
import org.pancakes.entities.Pancake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
@Repository
public interface PancakeRepository extends JpaRepository<Pancake, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Pancake SET name = :name , description = :description, price = :price where pancakeID = :id")
    void update(@Param("id") Integer id_, @Param("name") String name_,
                @Param("description") String description_, @Param("price") Double price_);
}
