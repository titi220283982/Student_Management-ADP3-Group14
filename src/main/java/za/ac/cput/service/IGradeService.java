package za.ac.cput.service;


import za.ac.cput.domain.grade;
import java.util.List;


public interface IGradeService extends IService<grade, String> {

    public List<grade> getAll();
}
