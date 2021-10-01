package com.devtask.publishinghousestructure.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WORKER")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @OneToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "WORKER_DETAILS_ID")
    private WorkerDetails workerDetails;

    @JsonManagedReference
    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(name = "WORKER_PUBLICATION",
            joinColumns = {
                    @JoinColumn(name = "WORKER_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "PUBLICATION_ID")})
    private Set<Publication> publications;

    @Column(name = "LOCAL_USERNAME")
    private String localUsername;

    @ManyToOne
    @JoinColumn(name = "PUBLISHING_OFFICE_ID")
    private PublishingOffice publishingOffice;


    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    @PreRemove
    public void removeWorker() {
        for (Publication publication : publications) {
            publication.getWorkers().remove(this);
        }
    }
}
