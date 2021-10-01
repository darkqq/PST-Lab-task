package com.devtask.publishinghousestructure.service.workerDetailsService;

import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.entity.WorkerDetails;

import java.util.List;

public interface WorkerDetailsService {
    void saveAll(Iterable<WorkerDetails> list);
    void saveAndFlush(WorkerDetails workerDetails);
    void save(WorkerDetails workerDetails);
}
