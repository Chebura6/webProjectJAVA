package org.pancakes.repositories;

import javax.transaction.Transactional;
import org.pancakes.entities.Cookie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<Cookie, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE Cookie SET name = :name , description = :description, price = :price where cookieID = :id")
    void update(@Param("id") Integer id_, @Param("name") String name_,
                @Param("description") String description_, @Param("price") Double price_);
}
