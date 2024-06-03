package com.apiusuarios.crud.domain.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String name;
    private String lastname;
    private String password;
    private String academic_institution;
    private String study_area;
    private String rol;

    @ElementCollection
    @CollectionTable(name="user_papers")
    @Column(name = "papers")
    private List<String> papers;

}
