package net.javaci.springangularcourse.db.dao;

import net.javaci.springangularcourse.db.entity.Application;

public interface ApplicationDAO {

    void addApplication(Application entity);
    
    Application getApplicationById(Integer id);
    
    boolean applicationExists(String name, String owner);
    
    boolean applicationExists2(String name, String owner);
    
    void updateNameAndOwnerById(Integer id, String name, String owner);
    
    void removeApplicationById(Integer id);
}
