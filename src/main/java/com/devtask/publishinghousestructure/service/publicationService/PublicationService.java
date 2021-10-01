package com.devtask.publishinghousestructure.service.publicationService;

import com.devtask.publishinghousestructure.entity.Publication;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PublicationService {
    void saveAll(Iterable<Publication> list);
    void saveAndFlush(Publication publication);
    void save(Publication publication);
    List<Publication> getNullPublications();
}

