package net.javaci.springangularcourse.db.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    
    private String owner;
    
    @Column( length = 1000 )
    private String description;
    
    @OneToMany
    @JoinColumn
    private List<Ticket> tickets;
    
    @ManyToMany
    private Set<Release> release;
    
}
