package com.devtask.publishinghousestructure.repository;

import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationDAO extends JpaRepository<Publication, Integer> {
    Page<Publication> getAllByIdIn(Iterable<Integer> ids, Pageable pageRequest);
    Publication findById(int id);
    Publication findByName(String name);
    Page<Publication> getAllByWorkersIn(Iterable<Worker> workers, Pageable pageable);
}
