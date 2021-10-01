package com.devtask.publishinghousestructure.service.publishingOfficeService;


import com.devtask.publishinghousestructure.entity.PublishingOffice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PublishingOfficeService {
    void saveAll(Iterable<PublishingOffice> list);

    void saveAndFlush(PublishingOffice publishingOffice);

    void save(PublishingOffice publishingOffice);

    Page<PublishingOffice> getAllPublishingOffices(Pageable pageable);

    PublishingOffice getPublishingOfficeById(int id);

    boolean isExists(PublishingOffice publishingOffice);

    void deleteById(int id);

    void delete(PublishingOffice publishingOffice);
}
