package com.devtask.publishinghousestructure.controller;

import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.service.publishingOfficeService.PublishingOfficeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publishingOffice")
public class PublishingOfficeController {
    private PublishingOfficeServiceImpl publishingOfficeService;

    @Autowired
    public void setPublishingOfficeService(PublishingOfficeServiceImpl publishingOfficeService) {
        this.publishingOfficeService = publishingOfficeService;
    }


    @GetMapping(
            value = "/get/all"
    )
    public Page<PublishingOffice> getOffices(Pageable pageable) {
        return publishingOfficeService.getAllPublishingOffices(pageable);
    }

    @GetMapping(
            value = "/get/{id}",
            produces = "application/json"
    )
    public PublishingOffice getOfficeById(@PathVariable String id) {
        return publishingOfficeService.getPublishingOfficeById(Integer.parseInt(id));
    }

    @PostMapping(
            value = "/new", consumes = "application/json")
    public String newOffice(PublishingOffice publishingOffice) {
        if (publishingOfficeService.isExists(publishingOffice)) return "Already exists";
        publishingOfficeService.saveAndFlush(publishingOffice);
        return "Created";
    }

    @PutMapping(
            value = "/update", consumes = "application/json")
    public String updatePublishingOffice(PublishingOffice publishingOffice) {
        publishingOfficeService.saveAndFlush(publishingOffice);
        return "Done";
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public String deletePublishingOfficeById(@PathVariable String id) {
        publishingOfficeService.deleteById(Integer.parseInt(id));
        return "Successfully deleted";
    }

    @DeleteMapping(
            value = "/delete",
            consumes = "application/json"
    )
    public String deletePublishingOffice(PublishingOffice publishingOffice) {
        publishingOfficeService.delete(publishingOffice);
        return "Successfully deleted";
    }

}
