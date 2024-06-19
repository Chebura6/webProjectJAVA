package org.pancakes.entities;


import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user", schema = "pancakes")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "sellerid")
    private Integer sellerid;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid")
    private Role role;
}
