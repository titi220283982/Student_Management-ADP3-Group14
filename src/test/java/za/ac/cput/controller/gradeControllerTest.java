package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.grade;
import za.ac.cput.factory.gradeFactory;


import javax.lang.model.element.Name;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class gradeControllerTest {

    @LocalServerPort
    private int portNo;
    private String baseURL;
    private grade grade1;
    @Autowired
    private gradeController gradeController;
    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp()
    {
        assertNotNull(gradeController);
        grade1 = gradeFactory.createGrade("12", "220292920");
        this.baseURL = "http://localhost:" + this.portNo + "/Student_Management-ADP3-Group14/grade/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseURL + "save_grade";
        System.out.println(url);

        ResponseEntity<grade> responseEntity = this.restTemplate.postForEntity(url, this.grade1, grade.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
        System.out.println("Grade saved");
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseURL + "readGrade/" + grade1.getGradeID();
        System.out.println(url);
        ResponseEntity<grade> responseEntity = this.restTemplate.getForEntity(url, grade.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(3)
    void delete()
    {
        String url = baseURL + "deleteGrade/" + grade1.getGradeID();
        System.out.println(url);

        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("12", grade1.getGradeID()),
                () -> assertNotNull(grade1.getGradeID()));
    }

    @Test
    @Order(4)
    void getAll()
    {
        String url = baseURL + "readAllGrade";
        System.out.println(url);
        ResponseEntity<grade[]> responseEntity = this.restTemplate.getForEntity(url, grade[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0));
    }
}
