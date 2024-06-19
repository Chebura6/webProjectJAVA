package org.pancakes.repositories;

import javax.transaction.Transactional;
import org.pancakes.entities.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BakeryRepository extends JpaRepository<Bakery, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Bakery SET name = :name , description = :description, price = :price where bakeryID = :id")
    void update(@Param("id") Integer id_, @Param("name") String name_,
                @Param("description") String description_, @Param("price") Double price_);
}
