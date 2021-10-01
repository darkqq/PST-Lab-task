package com.devtask.publishinghousestructure.config;

import com.devtask.publishinghousestructure.entity.Publication;
import com.devtask.publishinghousestructure.entity.PublishingOffice;
import com.devtask.publishinghousestructure.entity.Worker;
import com.devtask.publishinghousestructure.entity.WorkerDetails;
import com.devtask.publishinghousestructure.service.publicationService.PublicationServiceImpl;
import com.devtask.publishinghousestructure.service.publishingOfficeService.PublishingOfficeServiceImpl;
import com.devtask.publishinghousestructure.service.workerDetailsService.WorkerDetailsServiceImpl;
import com.devtask.publishinghousestructure.service.workerService.WorkerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class StartupDatabaseDataInsertion {

    private PublicationServiceImpl publicationService;
    private PublishingOfficeServiceImpl publishingOfficeService;
    private WorkerServiceImpl workerService;
    private WorkerDetailsServiceImpl workerDetailsService;

    @Autowired
    public void setPublicationService(PublicationServiceImpl publicationService) {
        this.publicationService = publicationService;
    }

    @Autowired
    public void setPublishingOfficeService(PublishingOfficeServiceImpl publishingOfficeService) {
        this.publishingOfficeService = publishingOfficeService;
    }

    @Autowired
    public void setWorkerService(WorkerServiceImpl workerService) {
        this.workerService = workerService;
    }

    @Autowired
    public void setWorkerDetailsService(WorkerDetailsServiceImpl workerDetailsService) {
        this.workerDetailsService = workerDetailsService;
    }

    @PostConstruct
    public void insertDataOnStart() {
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
            worker.setId(i);
            worker.setLocalUsername("USERNAME" + i);
            worker.setWorkerDetails(workerDetailsList.get(i-1));
            workerService.saveAndFlush(worker);
        }

        for(Publication publication : publications.stream().filter(e->e.getWorkers()==null).collect(Collectors.toList())){
            int z = (int) (Math.random() * (499));
            if(z==0) z=1;
            publication.addWorker(workerService.getWorkerById(z));
            publicationService.saveAndFlush(publication);
        }


    }
}
