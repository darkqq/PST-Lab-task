package com.devtask.publishinghousestructure.service.workerService;


import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.repository.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    private WorkerDAO workerDAO;

    @Autowired
    public void setWorkerDAO(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @Override
    public void saveAll(Iterable<Worker> list) {
        workerDAO.saveAll(list);
        workerDAO.flush();
    }

    @Override
    public void saveAndFlush(Worker worker) {
        workerDAO.saveAndFlush(worker);
    }

    @Override
    public void save(Worker worker) {
        workerDAO.save(worker);
    }

    @Override
    public List<Worker> getAll() {
        return workerDAO.findAll();
    }
}
