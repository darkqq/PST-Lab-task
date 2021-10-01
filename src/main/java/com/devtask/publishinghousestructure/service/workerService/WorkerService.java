package com.devtask.publishinghousestructure.service.workerService;

import com.devtask.publishinghousestructure.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WorkerService {
    void saveAll(Iterable<Worker> list);

    void saveAndFlush(Worker worker);

    void save(Worker worker);

    Page<Worker> getAllWorkers(Pageable pageable);

    Worker getWorkerById(int id);

    boolean isExists(Worker worker);

    void deleteById(int id);

    void delete(Worker worker);


}
