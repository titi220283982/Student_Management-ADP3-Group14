package za.ac.cput.service;

import za.ac.cput.domain.resource;
import java.util.List;

public interface IResourceService extends IService<resource, String> {

    public List<resource> getAll();
}
