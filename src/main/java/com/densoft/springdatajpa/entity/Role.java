package com.densoft.springdatajpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.MERGE
    }, fetch = FetchType.LAZY, mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }
}
