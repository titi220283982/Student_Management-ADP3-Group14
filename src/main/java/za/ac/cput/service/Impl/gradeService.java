package za.ac.cput.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.grade;
import za.ac.cput.repository.IGradeRepository;
import za.ac.cput.service.IGradeService;

import java.util.List;
import java.util.Optional;


@Service
public class gradeService implements IGradeService {
    private final IGradeRepository repository;

    @Autowired
    public gradeService(IGradeRepository repository) {
        this.repository = repository;
    }

    @Override
    public grade save(grade grade) {
        return this.repository.save(grade);
    }

    @Override
    public Optional<grade> read(String gradeID) {
        return this.repository.findById(gradeID);
    }

    @Override
    public grade update(grade grade) {
        return this.repository.save(grade);
    }

    @Override
    public void delete(grade grade) {
        this.repository.delete(grade);
    }

    @Override
    public List<grade> getAll() {
        return this.repository.findAll();

    }

    public grade findByGradeID(String gradeID){
        return this.repository.findByGradeID(gradeID);
    }

}

