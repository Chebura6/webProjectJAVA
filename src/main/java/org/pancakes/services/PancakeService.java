package org.pancakes.services;


import org.pancakes.entities.Cookie;
import org.pancakes.entities.Pancake;
import org.pancakes.entities.ProductDTO;
import org.pancakes.exceptions.ProductException;
import org.pancakes.repositories.PancakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.pancakes.exceptions.ProductException.NotValidProductNameException;
import static org.pancakes.exceptions.ProductException.NotValidProductPriceException;

@Service
public class PancakeService {

    @Autowired
    PancakeRepository pancakeRepository;

    public Collection<Pancake> getAll() {
        return pancakeRepository.findAll();
    }

    public void save(ProductDTO productDTO) throws ProductException {

        String nameRegex = "^[a-zA-Z\\s]*$";
        String priceRegex = "\\d+";
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern pricePattern = Pattern.compile(priceRegex);
        Matcher nameMatcher = namePattern.matcher(productDTO.getName());
        Matcher priceMatcher = pricePattern.matcher(productDTO.getPrice());


        if (!nameMatcher.matches()) {
            throw NotValidProductNameException();
        }
        if (!priceMatcher.matches()) {
            throw NotValidProductPriceException();
        }

        Pancake pancake = new Pancake();
        pancake.setName(productDTO.getName());
        pancake.setDescription(productDTO.getDescription());
        pancake.setPrice(Double.parseDouble(productDTO.getPrice()));
        pancakeRepository.save(pancake);
    }

    public void delete(Integer id) { pancakeRepository.deleteById(id); }

    public void update(Integer id, Pancake pancake) {
        pancakeRepository.update(id, pancake.getName(), pancake.getDescription(), pancake.getPrice());
    }
}
