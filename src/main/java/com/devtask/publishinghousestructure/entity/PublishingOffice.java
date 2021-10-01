package com.devtask.publishinghousestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PUBLISHING_OFFICE")
public class PublishingOffice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "OFFICE_NAME")
    private String name;

    @OneToMany(mappedBy = "publishingOffice", cascade = CascadeType.REMOVE)
    private List<Worker> workers;

}
