package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.grade;
import java.util.List;

@Repository
public interface IGradeRepository extends JpaRepository<grade, String>
{
    public grade findByGradeID(String gradeID);
}
