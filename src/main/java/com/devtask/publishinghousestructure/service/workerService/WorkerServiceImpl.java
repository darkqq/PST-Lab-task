package com.devtask.publishinghousestructure.service.workerService;


import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.repository.WorkerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

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
    public Page<Worker> getAllWorkers(Pageable pageable) {
        return workerDAO.findAll(pageable);
    }

    @Override
    public Worker getWorkerById(int id) {
        return workerDAO.getWorkerById(id);
    }

    @Override
    public boolean isExists(Worker worker) {
        return workerDAO.existsByLocalUsername(worker.getLocalUsername());
    }

    @Override
    public void deleteById(int id) {
        workerDAO.deleteById(id);
    }

    @Override
    public void delete(Worker worker) {
        workerDAO.delete(worker);
    }
}
