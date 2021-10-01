package com.devtask.publishinghousestructure.service.publicationService;


import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.repository.PublicationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PublicationServiceImpl implements PublicationService {

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
    public Page<Publication> getAllPublications(Pageable pageable) {
        return publicationDAO.findAll(pageable);
    }

    @Override
    public Publication getPublicationById(int id) {
        return publicationDAO.getOne(id);
    }

    @Override
    public boolean isExists(Publication publication) {
        return publicationDAO.existsByName(publication.getName());
    }

    @Override
    public void deleteById(int id) {
        publicationDAO.deleteById(id);
    }

    @Override
    public void delete(Publication publication) {
        publicationDAO.delete(publication);
    }
}
