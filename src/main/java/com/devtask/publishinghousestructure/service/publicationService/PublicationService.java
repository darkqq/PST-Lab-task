package com.devtask.publishinghousestructure.service.publicationService;

import com.devtask.publishinghousestructure.entity.Publication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PublicationService {
    void saveAll(Iterable<Publication> list);

    void saveAndFlush(Publication publication);

    void save(Publication publication);

    Page<Publication> getAllPublications(Pageable pageable);

    Publication getPublicationById(int id);

    boolean isExists(Publication publication);

    void deleteById(int id);

    void delete(Publication publication);
}

