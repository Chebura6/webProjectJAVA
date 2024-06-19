package org.pancakes.services;


import org.pancakes.entities.Bakery;
import org.pancakes.entities.BakerySeller;
import org.pancakes.entities.Pancake;
import org.pancakes.entities.ProductDTO;
import org.pancakes.exceptions.ProductException;
import org.pancakes.repositories.BakeryRepository;
import org.pancakes.repositories.PancakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.pancakes.exceptions.ProductException.NotValidProductNameException;
import static org.pancakes.exceptions.ProductException.NotValidProductPriceException;

@Service
public class BakeryService {

    @Autowired
    BakeryRepository bakeryRepository;

    public Collection<Bakery> getAll() {
        return bakeryRepository.findAll();
    }

    public Bakery save(ProductDTO productDTO) throws ProductException {
        String nameRegex = "^[a-zA-Z\\s]*$";
        String priceRegex = "\\d+";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern pricePattern = Pattern.compile(priceRegex);
        String name = productDTO.getName();
        Matcher nameMatcher = namePattern.matcher(productDTO.getName());
        Matcher priceMatcher = pricePattern.matcher(productDTO.getPrice());

        if (!nameMatcher.matches()) {
            throw NotValidProductNameException();
        }
        if (!priceMatcher.matches()) {
            throw NotValidProductPriceException();
        }

        Bakery bakery = new Bakery();
        bakery.setName(productDTO.getName());
        bakery.setDescription(productDTO.getDescription());
        bakery.setPrice(Double.parseDouble(productDTO.getPrice()));
        return bakeryRepository.save(bakery);
    }

    public void delete(Integer id) { bakeryRepository.deleteById(id); }

    public void update(Integer id, Bakery bakery) {
        bakeryRepository.update(id, bakery.getName(), bakery.getDescription(), bakery.getPrice());
    }
}
