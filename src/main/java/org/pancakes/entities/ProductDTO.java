package org.pancakes.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;


@Getter
@Setter
public class ProductDTO {
    private String name;

    private String description;

    private String price;
}
