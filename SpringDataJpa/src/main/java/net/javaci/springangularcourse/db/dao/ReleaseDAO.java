package net.javaci.springangularcourse.db.dao;

import net.javaci.springangularcourse.db.entity.Release;

public interface ReleaseDAO {

    void addRelease(Release entity);
    
    Release getReleaseById(Integer id);
}
