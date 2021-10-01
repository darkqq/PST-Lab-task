package com.devtask.publishinghousestructure.repository;

import com.devtask.publishinghousestructure.entity.WorkerDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerDetailsDAO extends JpaRepository<WorkerDetails, Integer> {
    Page<WorkerDetails> getAllByIdIn(Iterable<Integer> ids, Pageable pageRequest);

    WorkerDetails findById(int id);

    WorkerDetails findByName(String name);

    boolean existsByName(String name);
}
