package com.devtask.publishinghousestructure.controller;

import com.devtask.publishinghousestructure.entity.WorkerDetails;
import com.devtask.publishinghousestructure.service.workerDetailsService.WorkerDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workerDetails")
public class WorkerDetailsController {

    private WorkerDetailsServiceImpl workerDetailsService;

    @Autowired
    public void setWorkerDetailsService(WorkerDetailsServiceImpl workerDetailsService) {
        this.workerDetailsService = workerDetailsService;
    }

    @GetMapping(
            value = "/get/all"
    )
    public Page<WorkerDetails> getWorkerDetails(Pageable pageable) {
        return workerDetailsService.getWorkerDetails(pageable);
    }

    @GetMapping(
            value = "/get/{id}",
            produces = "application/json"
    )
    public WorkerDetails getWorkerDetailsById(@PathVariable String id) {
        return workerDetailsService.getWorkerDetailsById(Integer.parseInt(id));
    }

    @PostMapping(
            value = "/new", consumes = "application/json")
    public String newWorkerDetails(WorkerDetails workerDetails) {
        if (workerDetailsService.isExists(workerDetails)) return "Such Worker Details Already Exists";
        workerDetailsService.saveAndFlush(workerDetails);
        return "Created";
    }

    @PutMapping(
            value = "/update", consumes = "application/json")
    public String updateWorkerDetails(WorkerDetails workerDetails) {
        workerDetailsService.saveAndFlush(workerDetails);
        return "Done";
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public String deleteWorkerDetails(@PathVariable String id) {
        workerDetailsService.deleteById(Integer.parseInt(id));
        return "Successfully deleted";
    }

    @DeleteMapping(
            value = "/delete",
            consumes = "application/json"
    )
    public String deleteWorkerDetails(WorkerDetails workerDetails) {
        workerDetailsService.delete(workerDetails);
        return "Successfully deleted";
    }

}
