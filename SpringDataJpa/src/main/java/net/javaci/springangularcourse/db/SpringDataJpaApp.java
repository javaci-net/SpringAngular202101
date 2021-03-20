package net.javaci.springangularcourse.db;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaci.springangularcourse.db.dao.ApplicationDAO;
import net.javaci.springangularcourse.db.dao.ReleaseDAO;
import net.javaci.springangularcourse.db.dao.TicketDAO;
import net.javaci.springangularcourse.db.entity.Application;
import net.javaci.springangularcourse.db.entity.Release;
import net.javaci.springangularcourse.db.entity.Ticket;
import net.javaci.springangularcourse.db.entity.dto.TicketStats;

// @Slf4j
@SpringBootApplication
public class SpringDataJpaApp implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired private ApplicationDAO applicationDAO;
    @Autowired private TicketDAO ticketDAO;
    @Autowired private ReleaseDAO releaseDAO;
    
    private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApp.class);
    
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.debug("Starting ....");
        
        log.info("Using application instance: {}", applicationDAO.getClass());
        
        testDaoAddMethods();
        testDaoGetByIdMethods();
        testDAOReadWithJpql();
        testDAOReadWithCriteria();
        testDAOfindWithDTO();
        testDAOUpdate();
        
        // ticketDAO.removeTicketById(6);
        applicationDAO.deleteById(1);
        // printDBInfo();
    }

    private void testDAOUpdate() {
        Application before = applicationDAO.findById(1).get();
        applicationDAO.updateNameAndOwnerById(1, "Javaci Bank Admin Ekrani", "Koray");
        Application after = applicationDAO.findById(1).get();
        
        log.info("Name: {} -> {} , Owner: {} -> {}", before.getName(), after.getName(), before.getOwner(),
                after.getOwner());
    }

    private void testDAOfindWithDTO() {
        List<TicketStats> ticketStats = ticketDAO.findTicketStats();
        for (TicketStats ts : ticketStats) {
            log.info("{}", ts);
        }
    }

    private void testDAOReadWithCriteria() {
        String name = "Javaci Bank Api";
        String owner = "Ozkan";
        boolean appExists1 = applicationDAO.applicationExists2(name, owner);
        log.info("Application with name {} and owner {} exists? {}", name, owner, appExists1);
    }

    private void testDAOReadWithJpql() {
        String name = "Javaci Bank Api";
        String owner = "Ozkan";
        boolean appExists1 = applicationDAO.applicationExists(name, owner);
        log.info("Application with name {} and owner {} exists? {}", name, owner, appExists1);
    }

    private void testDaoGetByIdMethods() {
        // Application app1 = applicationDAO.getApplicationById(1);
        Application app1 = applicationDAO.getApplicationWithTicketsById(1);
        log.info("Application 1 found: {}", app1.getName());
        
        log.info("TICKETS *****************************************");
        // app1.getTickets().forEach(t -> log.info("Related ticket: {}",t));
        
        // Yukarida "getApplicationWithTicketsById" ile yalnizca tickets'ı joinliyoruz, release laz init exception alacak
        // log.info("RELEASES *****************************************");
        // app1.getRelease().forEach(r -> log.info("Related release: {}", r));
        
        Ticket ticket4 = ticketDAO.getTicketById(4);
        log.info("Ticket 4 found: {}", ticket4.getDesc());
        
        Release release7 = releaseDAO.getReleaseById(7);
        log.info("Release 7 found: {}", release7.getName());
    }

    private void testDaoAddMethods() {
        // Create applications
        Application backofficeApp = new Application("Javaci Bank Backoffice", "Volkan", "Javaci Bank Backoffice - Thymeleaf application");
        applicationDAO.save(backofficeApp);
        Application restApp = new Application("Javaci Bank Api", "Ozkan", "Javaci Bank REST API");
        applicationDAO.save(restApp);
        Application internetSubeApp = new Application("Javaci Bank Internet Sube", "Huseyin", "Javaci Bank Internet SUbe - Angular application");
        applicationDAO.save(internetSubeApp);
        
        // Create tickets
        Ticket ticket1 = new Ticket("Login Hatasi", "OPEN", "Tr karakterli kullanici adiyla login olamiyorum", backofficeApp);
        ticketDAO.addTicket(ticket1);
        
        Ticket ticket2 = new Ticket("Transfer Hatasi", "OPEN", "EFT yapamiyorum", restApp);
        ticketDAO.addTicket(ticket2);
        
        Ticket ticket3 = new Ticket("Hesap Ekleme Hatasi", "IN-PROGRESS", "Backofficeden yeni hesap olusturamiyorum", backofficeApp);
        ticketDAO.addTicket(ticket3);
        
        // Create release
        Set<Application> application = new HashSet<>();
        application.add(backofficeApp);
        application.add(restApp);
        Release releaseV1 = new Release("v1", LocalDateTime.now().plusDays(7), application);
        releaseDAO.addRelease(releaseV1);
    }

    private void printDBInfo() {
        EntityManagerFactory emf = entityManager.getEntityManagerFactory();
        Map<String, Object> emfPropertiesMap = emf.getProperties();
        log.debug(">> EMF PROPERTIES >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for(Map.Entry<String, Object> entry : emfPropertiesMap.entrySet()) {
            log.debug("{} = {}", entry.getKey(), entry.getValue());
        }
        log.debug("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
