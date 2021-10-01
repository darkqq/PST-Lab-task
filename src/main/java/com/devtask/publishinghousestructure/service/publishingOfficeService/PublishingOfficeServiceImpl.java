package com.devtask.publishinghousestructure.service.publishingOfficeService;

import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.repository.PublishingOfficeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<PublishingOffice> getAllPublishingOffices(Pageable pageable) {
        return publishingOfficeDAO.findAll(pageable);
    }

    @Override
    public PublishingOffice getPublishingOfficeById(int id) {
        return publishingOfficeDAO.getOne(id);
    }

    @Override
    public boolean isExists(PublishingOffice publishingOffice) {
        return publishingOfficeDAO.existsByName(publishingOffice.getName());
    }

    @Override
    public void deleteById(int id) {
        publishingOfficeDAO.deleteById(id);
    }

    @Override
    public void delete(PublishingOffice publishingOffice) {
        publishingOfficeDAO.delete(publishingOffice);
    }
}
