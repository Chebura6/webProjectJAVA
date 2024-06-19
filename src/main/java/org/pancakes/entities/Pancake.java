package org.pancakes.entities;


import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pancake", schema = "pancakes")
public class Pancake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pancakeID", nullable = false)
    private Integer pancakeID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;
}
