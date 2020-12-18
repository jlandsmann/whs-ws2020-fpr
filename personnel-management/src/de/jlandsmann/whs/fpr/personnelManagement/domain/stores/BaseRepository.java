package de.jlandsmann.whs.fpr.personnelManagement.domain.stores;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.BaseResource;

import java.util.List;

public interface BaseRepository<T extends BaseResource> {

    List<T> getAll();

    List<T> getResultSet(int skip, int take);

    T get(String id);

    T create(T resource);

    T update(String id, T resource);

    void delete(String id);

    int getSize();
}
