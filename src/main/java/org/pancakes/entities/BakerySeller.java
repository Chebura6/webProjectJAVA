package org.pancakes.entities;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Entity
@Table(name = "bakery_seller", schema = "pancakes")
public class BakerySeller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sellerID", nullable = false)
    private Integer sellerID;

    @Column(name = "name")
    private String name;
}
