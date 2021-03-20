package net.javaci.springangularcourse.db.dao;

import java.util.Optional;

import net.javaci.springangularcourse.db.entity.Application;

public interface ApplicationDAO {

    void save(Application entity);
    
    Optional<Application> findById(Integer id);
    
    Application getApplicationWithTicketsById(Integer id);
    
    boolean applicationExists(String name, String owner);
    
    boolean applicationExists2(String name, String owner);
    
    void updateNameAndOwnerById(Integer id, String name, String owner);
    
    void deleteById(Integer id);
}
