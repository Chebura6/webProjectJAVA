package org.pancakes.services;


import org.pancakes.entities.BakerySeller;
import org.pancakes.entities.CookieSeller;
import org.pancakes.repositories.BakerySellerRepository;
import org.pancakes.repositories.CookieSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CookieSellerService {

    @Autowired
    CookieSellerRepository cookieSellerRepository;

    public Collection<CookieSeller> getAll() {
        return cookieSellerRepository.findAll();
    }

    public void save(CookieSeller cookieSeller) { cookieSellerRepository.save(cookieSeller); }

    public void delete(Integer id) { cookieSellerRepository.deleteById(id); }

    public void update(Integer id, CookieSeller cookieSeller) {
        cookieSellerRepository.update(id, cookieSeller.getName());
    }
}
