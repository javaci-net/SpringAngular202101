package net.javaci.springangularcourse.db.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @OneToMany(mappedBy = "application", orphanRemoval = true , cascade = CascadeType.REMOVE)
    private List<Ticket> tickets;
    
    @ManyToMany(mappedBy = "application",cascade = CascadeType.REMOVE)
    private Set<Release> release;

    protected Application() {
        super();
    }
    
    public Application(String name, String owner, String description) {
        super();
        this.name = name;
        this.owner = owner;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Release> getRelease() {
        return release;
    }

    public void setRelease(Set<Release> release) {
        this.release = release;
    }

}
