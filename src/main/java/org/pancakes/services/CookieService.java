package org.pancakes.services;

import org.pancakes.entities.Bakery;
import org.pancakes.entities.Cookie;
import org.pancakes.entities.Pancake;
import org.pancakes.entities.ProductDTO;
import org.pancakes.exceptions.ProductException;
import org.pancakes.repositories.CookieRepository;
import org.pancakes.repositories.PancakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.pancakes.exceptions.ProductException.NotValidProductNameException;
import static org.pancakes.exceptions.ProductException.NotValidProductPriceException;

@Service
public class CookieService {
    @Autowired
    CookieRepository cookieRepository;

    public Collection<Cookie> getAll() {
        return cookieRepository.findAll();
    }

    public Cookie save(ProductDTO productDTO) throws ProductException {
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

        Cookie cookie = new Cookie();
        cookie.setName(productDTO.getName());
        cookie.setDescription(productDTO.getDescription());
        cookie.setPrice(Double.parseDouble(productDTO.getPrice()));
        return cookieRepository.save(cookie);
    }

    public void delete(Integer id) { cookieRepository.deleteById(id); }

    public void update(Integer id, Cookie cookie) {
        cookieRepository.update(id, cookie.getName(), cookie.getDescription(), cookie.getPrice());
    }

}
