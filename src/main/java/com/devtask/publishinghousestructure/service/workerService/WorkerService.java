package com.devtask.publishinghousestructure.service.workerService;

import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.entity.Worker;

import java.util.List;

public interface WorkerService {
    void saveAll(Iterable<Worker> list);
    void saveAndFlush(Worker worker);
    void save(Worker worker);
    List<Worker> getAll();

}
