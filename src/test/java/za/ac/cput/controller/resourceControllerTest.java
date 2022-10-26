package za.ac.cput.controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.resource;
import za.ac.cput.factory.resourceFactory;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class resourceControllerTest {
    @LocalServerPort
    private int portNo;
    private String baseURL;
    private resource resource1;
    @Autowired
    private resourceController resourceController;
    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    void setUp()
    {
        assertNotNull(resourceController);
        resource1 = resourceFactory.createResource("b21", "Group exercise 1", "The law of ADT", "Chapter 2 Slides");
        this.baseURL = "http://localhost:" + this.portNo + "/Student_Management-ADP3-Group14/resource/";
    }

    @Test
    @Order(1)
    void save()
    {
        String url = baseURL + "save_resource";
        System.out.println(url);

        ResponseEntity<resource> responseEntity = this.restTemplate.postForEntity(url, this.resource1, resource.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
        System.out.println("Resource saved");
    }

    @Test
    @Order(2)
    void read()
    {
        String url = baseURL + "readResource/" + resource1.getResourceID();
        System.out.println(url);
        ResponseEntity<resource> responseEntity = this.restTemplate.getForEntity(url, resource.class);
        System.out.println(responseEntity);
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertNotNull(responseEntity.getBody()));
    }

    @Test
    @Order(3)
    void delete()
    {
        String url = baseURL + "deleteResource/" + resource1.getResourceID();
        System.out.println(url);

        this.restTemplate.delete(url);
        assertAll(
                () -> assertSame("b21", resource1.getResourceID()),
                () -> assertNotNull(resource1.getResourceID()));
    }

    @Test
    @Order(4)
    void getAll()
    {
        String url = baseURL + "readAllResource";
        System.out.println(url);
        ResponseEntity<resource[]> responseEntity = this.restTemplate.getForEntity(url, resource[].class);
        System.out.println(Arrays.asList(responseEntity.getBody()));
        assertAll(
                () -> assertEquals(HttpStatus.OK, responseEntity.getStatusCode()),
                () -> assertTrue(responseEntity.getBody().length == 0));
    }
}
