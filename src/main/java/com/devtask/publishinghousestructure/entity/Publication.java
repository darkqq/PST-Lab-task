package com.devtask.publishinghousestructure.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
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

    @JsonBackReference
    @ManyToMany(mappedBy = "publications", fetch = FetchType.EAGER)
    private Set<Worker> workers = new HashSet<>();

    @PreRemove
    public void removeTargetPublication() {
        for (Worker worker : workers) {
            worker.getPublications().remove(this);
        }
    }

    public void addWorker(Worker worker){
        workers.add(worker);
    }

}
