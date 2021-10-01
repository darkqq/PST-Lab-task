package com.devtask.publishinghousestructure.controller;

import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.service.workerService.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {


    private WorkerServiceImpl workerService;

    @Autowired
    public void setWorkerService(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }

    @GetMapping(
            value = "/get/all"
    )
    public Page<Worker> getWorkers(Pageable pageable) {
        return workerService.getAllWorkers(pageable);
    }

    @GetMapping(
            value = "/get/{id}",
            produces = "application/json"
    )
    public Worker getWorkersById(@PathVariable String id) {
        return workerService.getWorkerById(Integer.parseInt(id));
    }

    @PostMapping(
            value = "/new", consumes = "application/json")
    public String newWorker(Worker worker) {
        if (workerService.isExists(worker)) return "Already exists";
        workerService.saveAndFlush(worker);
        return "Created";
    }

    @PutMapping(
            value = "/update", consumes = "application/json")
    public String updateWorker(Worker worker) {
        workerService.saveAndFlush(worker);
        return "Done";
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public String deleteWorkerById(@PathVariable String id) {
        workerService.deleteById(Integer.parseInt(id));
        return "Successfully deleted";
    }

    @DeleteMapping(
            value = "/delete",
            consumes = "application/json"
    )
    public String deleteWorker(Worker worker) {
        workerService.delete(worker);
        return "Successfully deleted";
    }

}
