//package za.ac.cput.service.Impl;
//
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import za.ac.cput.domain.grade;
//import za.ac.cput.factory.gradeFactory;
//import za.ac.cput.repository.IGradeRepository;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@SpringBootTest
//class gradeServiceTest {
//
//    @Autowired
//    gradeService gradeService;
//    private static grade grade1, grade2;
//    private IGradeRepository IGradeRepository;
//
//    @Test
//    @Order(1)
//    void save()
//    {
//        grade1 = gradeFactory.createGrade("1", "87654321");
//        grade createGrade1 = gradeService.save(grade1);
//        assertNotNull(createGrade1);
//        System.out.println(createGrade1);
//
//        grade2 = gradeFactory.createGrade("2", "11111111");
//        grade createGrade2 = grade.save(grade2);
//        assertNotNull(createGrade2);
//        System.out.println(createGrade2);
//
//        System.out.println("Grade have been added");
//    }
//
//    @Test
//    @Order(2)
//    void read()
//    {
//        System.out.println(gradeService.read("2"));
//    }
//
//    @Test
//    @Order(3)
//    void delete()
//    {
//        gradeService.delete(gradeService.findByGradeID("2"));
//        assertNotNull(grade2);
//        System.out.println("Grade deleted successfully");
//    }
//
//    @Test
//    @Order(4)
//    void getAll()
//    {
//        System.out.println(gradeService.getAll());
//    }
//}
