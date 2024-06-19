package org.pancakes.repositories;

import javax.transaction.Transactional;
import org.pancakes.entities.CookieSeller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieSellerRepository extends JpaRepository<CookieSeller, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE CookieSeller SET name = :name where sellerID = :id")
    void update(@Param("id") Integer id_, @Param("name") String name_);
}
