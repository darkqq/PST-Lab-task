package com.devtask.publishinghousestructure.service.workerDetailsService;

import com.devtask.publishinghousestructure.entity.WorkerDetails;
import com.devtask.publishinghousestructure.repository.WorkerDetailsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WorkerDetailsServiceImpl implements WorkerDetailsService {

    private WorkerDetailsDAO workerDetailsDAO;

    @Autowired
    public void setWorkerDetailsDAO(WorkerDetailsDAO workerDetailsDAO) {
        this.workerDetailsDAO = workerDetailsDAO;
    }

    @Override
    public void saveAll(Iterable<WorkerDetails> list) {
        workerDetailsDAO.saveAll(list);
        workerDetailsDAO.flush();
    }

    @Override
    public void saveAndFlush(WorkerDetails workerDetails) {
        workerDetailsDAO.saveAndFlush(workerDetails);
    }

    @Override
    public void save(WorkerDetails workerDetails) {
        workerDetailsDAO.save(workerDetails);
    }

    @Override
    public Page<WorkerDetails> getWorkerDetails(Pageable pageable) {
        return workerDetailsDAO.findAll(pageable);
    }

    @Override
    public WorkerDetails getWorkerDetailsById(int id) {
        return workerDetailsDAO.getOne(id);
    }

    @Override
    public boolean isExists(WorkerDetails workerDetails) {
        return workerDetailsDAO.existsByName(workerDetails.getName());
    }

    @Override
    public void deleteById(int id) {
        workerDetailsDAO.deleteById(id);
    }

    @Override
    public void delete(WorkerDetails workerDetails) {
        workerDetailsDAO.delete(workerDetails);
    }
}
