package org.pancakes.services;


import org.pancakes.entities.Bakery;
import org.pancakes.entities.BakerySeller;
import org.pancakes.repositories.BakeryRepository;
import org.pancakes.repositories.BakerySellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BakerySellerService {
    @Autowired
    BakerySellerRepository bakerySellerRepository;

    public Collection<BakerySeller> getAll() {
        return bakerySellerRepository.findAll();
    }

    public void save(BakerySeller bakerySeller) { bakerySellerRepository.save(bakerySeller); }

    public void delete(Integer id) { bakerySellerRepository.deleteById(id); }

    public void update(Integer id, BakerySeller bakerySeller) {
        bakerySellerRepository.update(id, bakerySeller.getName());
    }
}
