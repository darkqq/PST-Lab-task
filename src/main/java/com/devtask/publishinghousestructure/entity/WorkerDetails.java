package com.devtask.publishinghousestructure.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WORKER_DETAILS")
public class WorkerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "WORKER_NAME")
    private String name;

    @Column(name = "WORKER_SURNAME")
    private String surname;

}
