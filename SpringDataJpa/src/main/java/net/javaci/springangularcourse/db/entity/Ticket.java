package net.javaci.springangularcourse.db.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    protected Ticket() {
        super();
    }
    
    public Ticket(String title, String status, String desc, Application application) {
        super();
        this.title = title;
        this.status = status;
        this.desc = desc;
        this.application = application;
        LocalDateTime currentDateTime = LocalDateTime.now();
        this.createDateTime = currentDateTime;
        this.updateDateTime = currentDateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
    
}
