package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.ac.cput.domain.resource;
import za.ac.cput.repository.IResourceRepository;
import za.ac.cput.service.IResourceService;
import java.util.List;
import java.util.Optional;

@Service

public class resourceService implements IResourceService{
    private final IResourceRepository repository;

    @Autowired
    public resourceService(IResourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public resource save(resource resource) {
        return this.repository.save(resource);
    }

    @Override
    public Optional<resource> read(String resourceID) {
        return this.repository.findById(resourceID);
    }

    @Override
    public resource update(resource resource) {
        return this.repository.save(resource);
    }

    @Override
    public void delete(resource resource) {
        this.repository.delete(resource);
    }

    @Override
    public List<resource> getAll() {
        return this.repository.findAll();

    }

    public resource findByResourceID(String resourceID){
        return this.repository.findByResourceID(resourceID);
    }


}
