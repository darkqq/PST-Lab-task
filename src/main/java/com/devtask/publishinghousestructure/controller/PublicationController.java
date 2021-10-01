package com.devtask.publishinghousestructure.controller;

import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.service.publicationService.PublicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/publication")
public class PublicationController {
    private PublicationServiceImpl publicationService;

    @Autowired
    public void setPublicationService(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping(value = "/get/all", produces = "application/json")
    public Page<Publication> getAllPublications(Pageable pageable) {
        return publicationService.getAllPublications(pageable);
    }


    @GetMapping(
            value = "/get/{id}", produces = "application/json"
    )
    public Publication getPublication(@PathVariable String id) {
        return publicationService.getPublicationById(Integer.parseInt(id));
    }

    @PostMapping(
            value = "/new", consumes = "application/json")
    public String newPublication(Publication publication) {
        if (publicationService.isExists(publication)) return "Already exists";
        publicationService.saveAndFlush(publication);
        return "Created";
    }

    @PutMapping(
            value = "/update", consumes = "application/json")
    public String updatePublication(Publication publication) {
        publicationService.saveAndFlush(publication);
        return "Added/updated";
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public String deletePublicationById(@PathVariable String id) {
        publicationService.deleteById(Integer.parseInt(id));
        return "Deleted";
    }

    @DeleteMapping(
            value = "/delete",
            consumes = "application/json"
    )
    public String deletePublication(Publication publication) {
        publicationService.delete(publication);
        return "Deleted";
    }
}

