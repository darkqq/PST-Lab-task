package com.devtask.publishinghousestructure.repository;

import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.entity.Worker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PublishingOfficeDAO  extends JpaRepository<PublishingOffice, Integer> {
    Page<PublishingOffice> getAllByIdIn(Iterable<Integer> ids, Pageable pageRequest);
    PublishingOffice findById(int id);
    PublishingOffice findByName(String name);
    Page<PublishingOffice> getAllByWorkersIn(Iterable<Worker> workers, Pageable pageRequest);
}
