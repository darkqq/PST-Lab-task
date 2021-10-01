package com.devtask.publishinghousestructure.repository;

import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.entity.WorkerDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WorkerDAO extends JpaRepository<Worker, Integer> {
    Page<Worker> getAllByIdIn(Iterable<Integer> ids, Pageable pageRequest);
    Worker getWorkerById(int id);

    Worker findWorkerByWorkerDetails(WorkerDetails workerDetails);

    Worker findWorkerByWorkerDetails_Name(String name);

    Worker getWorkerByLocalUsername(String localUsername);
}
