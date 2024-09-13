package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


/**
 * Unit tests for MyFileDatabase class.
 */
@SpringBootTest
@ContextConfiguration
public class MyFileDatabaseUnitTests {

  /**
   * Setup MyFileDatabase instance for testing.
   */
  @BeforeAll
  public static void setupMyFileDatabaseForTesting() {
    testMFD = new MyFileDatabase(1, "./data.txt");

    HashMap<String, Course> csCourses = new HashMap<>();
    csCourses.put("1004", new Course("Adam Cannon", "417 IAB", "11:40-12:55", 400));
    Department compSci = new Department("COMS", csCourses, "Luca Carloni", 2700);

    HashMap<String, Course> econCourses = new HashMap<>();
    econCourses.put("1004", new Course("Waseem Noor", "305 URIS", "4:10-5:25", 210));
    Department econ = new Department("COMS", econCourses, "Luca Carloni", 2700);

    mapping = new HashMap<>();
    mapping.put("COMS", compSci);
    mapping.put("ECON", econ);
  }

  /**
   * Test MyFileDatabase getMapping() method.
   */
  @Test
  public void testGetMapping() {
    HashMap<String, Course> csCourses = new HashMap<>();
    csCourses.put("1004", new Course("Adam Cannon", "417 IAB", "11:40-12:55", 400));
    Department compSci = new Department("COMS", csCourses, "Luca Carloni", 2700);

    HashMap<String, Course> econCourses = new HashMap<>();
    econCourses.put("1105", new Course("Waseem Noor", "305 URIS", "4:10-5:25", 210));
    Department econ = new Department("ECON", econCourses, "Luca Carloni", 2700);

    HashMap<String, Department> mapping = new HashMap<>();
    mapping.put("COMS", compSci);
    mapping.put("ECON", econ);

    testMFD.setMapping(mapping);

    System.out.println(testMFD.toString());

    assertEquals(mapping, testMFD.getDepartmentMapping());
  }

  /**
   * Test MyFileDatabase toString() method.
   */
  @Test
  public void testToString() {

    testMFD.setMapping(mapping);

    StringBuilder result = new StringBuilder();
    for (HashMap.Entry<String, Department> entry : mapping.entrySet()) {
      String key = entry.getKey();
      Department value = entry.getValue();
      result.append("For the ").append(key).append(" department: \n").append(value.toString());
    }

    assertEquals(result.toString(), testMFD.toString());
  }

  public static MyFileDatabase testMFD;
  public static HashMap<String, Department> mapping;

}
