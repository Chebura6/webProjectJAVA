package org.pancakes.services;


import org.pancakes.entities.CookieSeller;
import org.pancakes.entities.Pancake;
import org.pancakes.entities.PancakeSeller;
import org.pancakes.repositories.CookieSellerRepository;
import org.pancakes.repositories.PancakeSellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PancakeSellerService {
    @Autowired
    PancakeSellerRepository pancakeSellerRepository;

    public Collection<PancakeSeller> getAll() {
        return pancakeSellerRepository.findAll();
    }

    public void save(PancakeSeller pancakeSeller) { pancakeSellerRepository.save(pancakeSeller); }

    public void delete(Integer id) { pancakeSellerRepository.deleteById(id); }

    public void update(Integer id, PancakeSeller pancakeSeller ) {
        pancakeSellerRepository.update(id, pancakeSeller.getName());
    }
}
