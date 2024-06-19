package org.pancakes.controller;


import io.swagger.annotations.Api;
import org.pancakes.entities.Bakery;
import org.pancakes.entities.Cookie;
import org.pancakes.entities.Pancake;
import org.pancakes.entities.ProductDTO;
import org.pancakes.exceptions.ProductException;
import org.pancakes.services.BakeryService;
import org.pancakes.services.CookieService;
import org.pancakes.services.PancakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/pancakes/")
@Api(value = "Pancakes",description = "CRUD operations")
public class RestController {

    @Autowired
    PancakeService pancakeService;
    @Autowired
    BakeryService bakeryService;
    @Autowired
    CookieService cookieService;

    @GetMapping("/pancake/getAll")
    Collection<Pancake> getAllPancakes() {
        return pancakeService.getAll();
    }

    @RequestMapping(value = "/pancake/save", method= RequestMethod.POST)
    @ResponseBody
    void savePancake(@RequestBody ProductDTO productDTO, HttpServletResponse response) throws IOException, ProductException {
        try {
//            System.out.println("in");
            pancakeService.save(productDTO);
//            response.sendRedirect("/bakery");
            response.setStatus(200);
        } catch(ProductException ex) {
            response.setStatus(400);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(ex.getMessage());
            response.getWriter().flush();
            response.flushBuffer();
        }
    }

    @DeleteMapping("/pancake/{id}")
    void deletePancake(@PathVariable Integer id) {
        pancakeService.delete(id);
    }

    @PostMapping("/pancake/update/{id}")
    void updatePancake(@PathVariable Integer id, @PathVariable Pancake pancake) {
        pancakeService.update(id, pancake);
    }


    @GetMapping("/bakery/getAll")
    Collection<Bakery> getAllBakeries() {
        System.out.println("getAll");
        return bakeryService.getAll();
    }

//    @PostMapping("/bakery/save")
    @RequestMapping(value = "/bakery/save", method= RequestMethod.POST)
    @ResponseBody
    void saveBakery(@RequestBody ProductDTO productDTO, HttpServletResponse response) throws ProductException, IOException {

        try {
//            System.out.println("in");
            bakeryService.save(productDTO);
//            response.sendRedirect("/bakery");
            response.setStatus(200);
        } catch(ProductException ex) {
            response.setStatus(400);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(ex.getMessage());
            response.getWriter().flush();
            response.flushBuffer();
        }
    }

    @DeleteMapping("/bakery/{id}")
    void deleteBakery(@PathVariable Integer id) {
        bakeryService.delete(id);
    }

    @PostMapping("/bakery/update/{id}")
    void updateBakery(@PathVariable Integer id, @PathVariable Bakery bakery) {
        bakeryService.update(id, bakery);
    }

    @GetMapping("/cookie/getAll")
    Collection<Cookie> getAllCookies() {
        return cookieService.getAll();
    }

    @RequestMapping(value = "/cookie/save", method= RequestMethod.POST)
    @ResponseBody
    void saveCookie(@RequestBody ProductDTO productDTO, HttpServletResponse response) throws IOException, ProductException {
        try {
//            System.out.println("in");
            cookieService.save(productDTO);
//            response.sendRedirect("/bakery");
            response.setStatus(200);
        } catch(ProductException ex) {
            response.setStatus(400);
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(ex.getMessage());
            response.getWriter().flush();
            response.flushBuffer();
        }
    }

    @DeleteMapping("/cookie/{id}")
    void deleteCookie(@PathVariable Integer id) {
        cookieService.delete(id);
    }

    @PostMapping("/cookie/update/{id}")
    void updateCookie(@PathVariable Integer id, @PathVariable Cookie cookie) {
        cookieService.update(id, cookie);
    }
}
