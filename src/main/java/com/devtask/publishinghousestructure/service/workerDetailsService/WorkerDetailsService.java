package com.devtask.publishinghousestructure.service.workerDetailsService;

import com.devtask.publishinghousestructure.entity.WorkerDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkerDetailsService {
    void saveAll(Iterable<WorkerDetails> list);

    void saveAndFlush(WorkerDetails workerDetails);

    void save(WorkerDetails workerDetails);

    Page<WorkerDetails> getWorkerDetails(Pageable pageable);

    WorkerDetails getWorkerDetailsById(int id);

    boolean isExists(WorkerDetails workerDetails);

    void deleteById(int id);

    void delete(WorkerDetails workerDetails);

}
