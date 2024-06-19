package org.pancakes.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "pancake_seller", schema = "pancakes")
public class PancakeSeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sellerID", nullable = false)
    private Integer sellerID;

    @Column(name = "name")
    private String name;
}
