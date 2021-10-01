package com.devtask.publishinghousestructure.service.publicationService;


import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.repository.PublicationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PublicationServiceImpl implements PublicationService{

    private PublicationDAO publicationDAO;

    @Autowired
    public void setPublicationDAO(PublicationDAO publicationDAO) {
        this.publicationDAO = publicationDAO;
    }

    @Override
    public void saveAll(Iterable<Publication> list) {
        publicationDAO.saveAll(list);
        publicationDAO.flush();
    }

    @Override
    public void saveAndFlush(Publication publication) {
        publicationDAO.saveAndFlush(publication);
    }

    @Override
    public void save(Publication publication) {
        publicationDAO.save(publication);
    }

    @Override
    public List<Publication> getNullPublications() {
        List<Publication> list = publicationDAO.findAll();
        return list.stream().filter(e->e.getWorkers().isEmpty()).collect(Collectors.toList());
    }
}
