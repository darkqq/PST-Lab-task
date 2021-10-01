package com.devtask.publishinghousestructure.service.publishingOfficeService;

import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.repository.PublishingOfficeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PublishingOfficeServiceImpl implements PublishingOfficeService {

    private PublishingOfficeDAO publishingOfficeDAO;

    @Autowired
    public void setPublishingOfficeDAO(PublishingOfficeDAO publishingOfficeDAO) {
        this.publishingOfficeDAO = publishingOfficeDAO;
    }

    @Override
    public void saveAll(Iterable<PublishingOffice> list) {
        publishingOfficeDAO.saveAll(list);
        publishingOfficeDAO.flush();
    }

    @Override
    public void saveAndFlush(PublishingOffice publishingOffice) {
        publishingOfficeDAO.saveAndFlush(publishingOffice);
    }

    @Override
    public void save(PublishingOffice publishingOffice) {
        publishingOfficeDAO.save(publishingOffice);
    }
}
