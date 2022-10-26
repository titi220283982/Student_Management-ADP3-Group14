//package za.ac.cput.factory;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.domain.grade;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class gradeFactoryTest {
//    @Test
//    @Order(1)
//    void createGrade()
//    {
//        grade grade = gradeFactory.createGrade("10","12345678");
//        System.out.println(grade.toString());
//        assertNotNull(grade);
//    }
//
//    @Test
//    @Order(2)
//    void createGradeNoPass()
//    {
//        grade grade = gradeFactory.createGrade("10","12345678");
//        System.out.println(grade.toString());
//        assertNotNull(grade);
//    }
//    @Test
//    @Order(3)
//    void createGradeNoPassConf()
//    {
//        grade grade = gradeFactory.createGrade("10","12345678");
//        System.out.println(grade.toString());
//        assertNotNull(grade);
//    }
//    @Test
//    @Order(4)
//    void createGradeNoStud()
//    {
//        grade grade = gradeFactory.createGrade("10","12345678");
//        System.out.println(grade.toString());
//        assertNotNull(grade);
//    }
//
//}
