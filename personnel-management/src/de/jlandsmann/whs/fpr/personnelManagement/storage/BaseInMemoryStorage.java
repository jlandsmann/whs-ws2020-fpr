package de.jlandsmann.whs.fpr.personnelManagement.storage;

import de.jlandsmann.whs.fpr.personnelManagement.domain.models.BaseResource;
import de.jlandsmann.whs.fpr.personnelManagement.domain.stores.BaseRepository;

import java.util.ArrayList;
import java.util.List;

public class BaseInMemoryStorage<T extends BaseResource> implements BaseRepository<T> {
    protected ArrayList<T> collection = new ArrayList<T>();

    public BaseInMemoryStorage() {

    }

    public List<T> getAll() {
        return this.collection;
    }

    public List<T> getResultSet(int skip, int take) {
        return this.collection.subList(skip, skip + take);
    }

    public T get(String id) {
        return this.collection.stream()
                .filter((T resource) -> resource.getId().equals(id))
                .findFirst()
                .orElseThrow()
                ;
    }

    public T create(T resource) {
        this.collection.add(resource);
        return resource;
    }

    public T update(String id, T resource) {
        T target = this.get(id);
        int index = this.collection.indexOf(target);
        this.collection.set(index, resource);
        return resource;
    }

    public void delete(String id) {
        T target = this.get(id);
        this.collection.remove(target);
    }

    public int getSize() {
        return this.collection.size();
    }
}
