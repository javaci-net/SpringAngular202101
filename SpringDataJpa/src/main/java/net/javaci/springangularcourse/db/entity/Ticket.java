package net.javaci.springangularcourse.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String title;
    
    private String status;
    
    @Column(name = "ticket_desc", length = 2000, nullable = true)
    private String desc;
    
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;
    
    @ManyToOne
    private Application application;
    
}
