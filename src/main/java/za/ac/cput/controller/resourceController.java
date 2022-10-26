package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.resource;
import za.ac.cput.service.IResourceService;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Student_Management-ADP3-Group14/resource")
@Slf4j
public class resourceController {

    private final IResourceService repository;

    @Autowired
    resourceController(IResourceService repository) {this.repository = repository;}

    @PostMapping("save_resource")
    public ResponseEntity<resource> save(@Valid @RequestBody resource saveResource){
        log.info("Save request: {}",saveResource);

        try{
            resource newResource = repository.save(saveResource);
            return ResponseEntity.ok(newResource);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @PutMapping("update_resource")
    public ResponseEntity<resource> update(@Valid @RequestBody resource updateResource){
        try{
            resource updatedResource = this.repository.update(updateResource);
            return ResponseEntity.ok(updateResource);

        }catch (IllegalArgumentException exception){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exception.getMessage());
        }
    }

    @GetMapping("readResource/{resourceID}")
    public ResponseEntity<Optional<resource>> read(@PathVariable String resourceID){
        log.info("Read request: {}",resourceID);

        try {
            Optional<resource> readResource = repository.read(resourceID);
            return ResponseEntity.ok(readResource);

        }catch(IllegalArgumentException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @DeleteMapping("deleteResource/{resource}")
    public ResponseEntity<resource> delete(@PathVariable resource resource){
        log.info("Delete request: {}",resource);

        this.repository.delete(resource);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("readAllResource")
    public ResponseEntity<List<resource>> getAll(){
        List<resource> list = this.repository.getAll();
        return ResponseEntity.ok(list);
    }


}