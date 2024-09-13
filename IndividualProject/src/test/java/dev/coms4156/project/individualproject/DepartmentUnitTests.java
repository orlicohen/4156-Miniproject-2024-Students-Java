package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit tests for Department class.
 */
@SpringBootTest
@ContextConfiguration
public class DepartmentUnitTests {

  /**
   * Setup Department instance for testing.
   */
  @BeforeAll
  public static void setupDepartmentForTesting() {
    String[] times = {"11:40-12:55", "4:10-5:25", "10:10-11:25", "2:40-3:55"};
    String[] locations = {"417 IAB", "309 HAV", "301 URIS"};

    Course coms1004 = new Course("Adam Cannon", locations[0], times[0], 400);
    coms1004.setEnrolledStudentCount(249);

    HashMap<String, Course> courses = new HashMap<>();
    courses.put("1004", coms1004);

    testDept = new Department("COMS", courses, "Luca Carloni", 2700);
  }

  @Test
  public void testGetNumberOfMajors() {
    int expectedResult = 2700;
    assertEquals(testDept.getNumberOfMajors(), expectedResult);
  }

  @Test
  public void testGetDepartmentChair() {
    String expectedResult = "Luca Carloni";
    assertEquals(testDept.getDepartmentChair(), expectedResult);
  }

  @Test
  public void testAddPersonToMajor() {
    int expectedResult = testDept.getNumberOfMajors() + 1;
    testDept.addPersonToMajor();
    assertEquals(testDept.getNumberOfMajors(), expectedResult);
  }

  @Test
  public void testDropPersonFromMajor() {
    int expectedResult = testDept.getNumberOfMajors() - 1;
    testDept.dropPersonFromMajor();
    assertEquals(testDept.getNumberOfMajors(), expectedResult);
  }

  @Test
  public void testGetCourseSelection() {
    Course coms1004 = new Course("Adam Cannon", "417 IAB", "11:40-12:55", 400);
    HashMap<String, Course> expectedResult = new HashMap<>();
    expectedResult.put("1004", coms1004);

    assertTrue(testDept.getCourseSelection().containsKey("1004"));
  }

  @Test
  public void toStringTest() {
    Course coms1004 = new Course("Adam Cannon", "417 IAB", "11:40-12:55", 400);
    String expectedResult = "COMS 1004: " + coms1004 + "\n";
    assertEquals(expectedResult, testDept.toString());
  }

  /** The test department instance used for testing. */
  public static Department testDept;

}
