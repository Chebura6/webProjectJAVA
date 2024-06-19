package org.pancakes.repositories;

import javax.transaction.Transactional;
import org.pancakes.entities.BakerySeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BakerySellerRepository extends JpaRepository<BakerySeller, Integer> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE BakerySeller SET name = :name where sellerID = :id")
    void update(@Param("id") Integer id_, @Param("name") String name_);
}
