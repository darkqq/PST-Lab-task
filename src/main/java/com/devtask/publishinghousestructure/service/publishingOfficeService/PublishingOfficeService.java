package com.devtask.publishinghousestructure.service.publishingOfficeService;


import com.devtask.publishinghousestructure.entity.PublishingOffice;

import java.util.List;

public interface PublishingOfficeService {
    void saveAll(Iterable<PublishingOffice> list);
    void saveAndFlush(PublishingOffice publishingOffice);
    void save(PublishingOffice publishingOffice);
}
