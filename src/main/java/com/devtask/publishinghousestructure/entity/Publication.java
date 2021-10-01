package com.devtask.publishinghousestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PUBLICATION")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "PUBLICATION_NAME")
    private String name;

    @ManyToMany(mappedBy = "publications", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Worker> workers;
}
