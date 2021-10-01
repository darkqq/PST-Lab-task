package com.devtask.publishinghousestructure.onStart;
import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.entity.WorkerDetails;
import com.devtask.publishinghousestructure.generator.Generator;
import com.devtask.publishinghousestructure.service.publicationService.PublicationServiceImpl;
import com.devtask.publishinghousestructure.service.publishingOfficeService.PublishingOfficeServiceImpl;
import com.devtask.publishinghousestructure.service.workerDetailsService.WorkerDetailsServiceImpl;
import com.devtask.publishinghousestructure.service.workerService.WorkerServiceImpl;
import org.eclipse.jgit.util.io.IsolatedOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class StartUp {


    private Generator generator;
    private PublishingOfficeServiceImpl publishingOfficeService;
    private WorkerDetailsServiceImpl workerDetailsService;
    private WorkerServiceImpl workerService;
    private PublicationServiceImpl publicationService;

    @Autowired
    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    @Autowired
    public void setPublishingOfficeService(PublishingOfficeServiceImpl publishingOfficeService) {
        this.publishingOfficeService = publishingOfficeService;
    }

    @Autowired
    public void setWorkerDetailsService(WorkerDetailsServiceImpl workerDetailsService) {
        this.workerDetailsService = workerDetailsService;
    }

    @Autowired
    public void setWorkerService(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }

    @Autowired
    public void setPublicationService(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @PostConstruct
    public void generateDB(){

        List<PublishingOffice> publishingOffices = new ArrayList<>();
        for(int i =1; i< 501; i++){
            PublishingOffice po = new PublishingOffice();
            po.setName("OFFICE" + i);
            publishingOffices.add(po);
        }
        publishingOfficeService.saveAll(publishingOffices);

        List<Publication> publications = new ArrayList<>();

        for(int i =1; i< 1001; i++){
            Publication p = new Publication();
            p.setName("PUBLICATION" + i);
            publications.add(p);
        }
        publicationService.saveAll(publications);


        List<WorkerDetails> workerDetailsList = new ArrayList<>();
        for(int i =1; i< 501; i++) {
            WorkerDetails workerDetails = new WorkerDetails();
            workerDetails.setSurname("SURNAME" + i);
            workerDetails.setName("NAME" + i);
            workerDetailsList.add(workerDetails);
        }
        workerDetailsService.saveAll(workerDetailsList);

        for(int i = 1; i < 501; i++){
            Worker worker = new Worker();
            worker.setLocalUsername("USERNAME" + i);
            worker.setWorkerDetails(workerDetailsList.get(i-1));
            workerService.saveAndFlush(worker);
        }

        List<Worker> list = workerService.getAll();
        for (Publication publication: publicationService.getNullPublications()) {
            int z = (int) (Math.random() * (499));
            list.get(z).addPublication(publication);
        }
        workerService.saveAll(list);



    }
}
