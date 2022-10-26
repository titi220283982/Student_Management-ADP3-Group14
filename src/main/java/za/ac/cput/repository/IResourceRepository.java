package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.resource;

@Repository
public interface IResourceRepository extends JpaRepository<resource, String>{
    public resource findByResourceID(String resourceID);
}
