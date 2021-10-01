package com.devtask.publishinghousestructure.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
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
    @JoinColumn(name = "WORKER_DETAILS_ID")
    private WorkerDetails workerDetails;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name = "WORKER_PUBLICATION",
            joinColumns = {
                    @JoinColumn(name = "WORKER_ID")},
            inverseJoinColumns = {
                    @JoinColumn(name = "PUBLICATION_ID")})
    private List<Publication> publications;

    @Column(name = "LOCAL_USERNAME")
    private String localUsername;

    @ManyToOne
    @JoinColumn(name = "PUBLISHING_OFFICE_ID")
    private PublishingOffice publishingOffice;

    @Override
    public boolean equals(Object o) {
        Worker worker = (Worker) o;
        return worker.getWorkerDetails().getName().equals(this.workerDetails.getName()) && worker.getWorkerDetails().getSurname().equals(this.workerDetails.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, workerDetails, publications, localUsername, publishingOffice);
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }
}
