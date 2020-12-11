package de.jlandsmann.whs.fpr.personnelManagement.domain.stores;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.BaseResource;

import java.util.Collection;

public interface BaseRepository<T extends BaseResource> {

    Collection<T> getAll();

    Collection<T> getResultSet(int skip, int take);

    T get(String id);

    T create(T resource);

    T update(String id, T resource);

    void delete(String id);

    int getSize();
}
