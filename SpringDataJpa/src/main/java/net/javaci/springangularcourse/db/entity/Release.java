package net.javaci.springangularcourse.db.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "apprelease")
public class Release {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    
    private LocalDateTime releaseDateTime;
    
    @ManyToMany
    /*--
    @JoinTable(name = "application_release",
            joinColumns = @JoinColumn(referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "id")
    )
     */
    private Set<Application> application;

    protected Release() {
        super();
    }
    
    public Release(String name, LocalDateTime releaseDateTime, Set<Application> application) {
        super();
        this.name = name;
        this.releaseDateTime = releaseDateTime;
        this.application = application;
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

    public LocalDateTime getReleaseDateTime() {
        return releaseDateTime;
    }

    public void setReleaseDateTime(LocalDateTime releaseDateTime) {
        this.releaseDateTime = releaseDateTime;
    }

    public Set<Application> getApplication() {
        return application;
    }

    public void setApplication(Set<Application> application) {
        this.application = application;
    }
}
