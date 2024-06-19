package org.pancakes.repositories;

import javax.transaction.Transactional;
import org.pancakes.entities.PancakeSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PancakeSellerRepository extends JpaRepository<PancakeSeller, Integer> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE PancakeSeller SET name = :name where sellerID = :id")
    void update(@Param("id") Integer id_, @Param("name") String name_);
}
