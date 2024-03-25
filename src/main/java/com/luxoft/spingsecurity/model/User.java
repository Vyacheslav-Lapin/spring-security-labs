package com.luxoft.spingsecurity.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.EqualsAndHashCode;

@SequenceGenerator(
    name = "user_seq_gen",
    sequenceName = "user_seq",
    initialValue = 3010
)
@Entity
@Data
public class User {

    @EqualsAndHashCode.Include
    @GeneratedValue(generator = "user_seq_gen")
    @Id
    private long id;

    private String login;

    private String password;

    @ElementCollection
    private List<String> roles;

    @JoinTable(name = "user_company")
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Company> companies;
}
