package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Class containing unit tests for the Course class. 
 */
@SpringBootTest
@ContextConfiguration
public class CourseUnitTests {

  /**
   * Setup Course instance for testing.
   */
  @BeforeAll
  public static void setupCourseForTesting() {
    testCourse = new Course("Griffin Newbold", "417 IAB",
                           "11:40-12:55", 250);
  }


  /**
   * Test Course class toString() method.
   */
  @Test
  public void toStringTest() {
    // reassign all values so we know what expected values for course are
    testCourse.reassignInstructor("Griffin Newbold");
    testCourse.reassignLocation("417 IAB");
    testCourse.reassignTime("11:40-12:55");
    String expectedResult = "\nInstructor: Griffin Newbold; Location: 417 IAB; Time: 11:40-12:55";
    assertEquals(expectedResult, testCourse.toString());
  }

  /**
   * Test Course class enrollStudent() method.
   */
  @Test
  public void testEnrollStudent() {
    boolean expectedResult = !testCourse.isCourseFull();
    assertEquals(expectedResult, testCourse.enrollStudent());
  }

  /**
   * Test Course class getCourseLocation() method.
   */
  @Test
  public void testGetCourseLocation() {
    String expectedResult = "417 IAB";
    // reassign value so we know what expected value for course is
    testCourse.reassignLocation("417 IAB");
    assertEquals(expectedResult, testCourse.getCourseLocation());
  }

  /**
   * Test Course class getInstructorName() method.
   */
  @Test
  public void testGetInstructorName() {
    String expectedResult = "Griffin Newbold";
    // reassign value so we know what expected value for course is
    testCourse.reassignInstructor("Griffin Newbold");
    assertEquals(expectedResult, testCourse.getInstructorName());
  }

  /**
   * Test Course class getCourseTimeSlot() method.
   */
  @Test
  public void testGetCourseTimeSlot() {
    String expectedResult = "11:40-12:55";
    // reassign value so we know what expected value for course is
    testCourse.reassignTime("11:40-12:55");
    assertEquals(expectedResult, testCourse.getCourseTimeSlot());
  }

  /**
   * Test Course class reassignInstructor() method.
   */
  @Test
  public void testReassignInstructor() {
    String expectedResult = "Adam Cannon";
    testCourse.reassignInstructor("Adam Cannon");
    assertEquals(expectedResult, testCourse.getInstructorName());
  }

  /**
   * Test Course class reassignLocation() method.
   */
  @Test
  public void testReassignLocation() {
    String expectedResult = "309 HAV";
    testCourse.reassignLocation("309 HAV");
    assertEquals(expectedResult, testCourse.getCourseLocation());
  }

  /**
   * Test Course class reassignTime() method.
   */
  @Test
  public void testReassignTime() {
    String expectedResult = "4:10-5:25";
    testCourse.reassignTime("4:10-5:25");
    assertEquals(expectedResult, testCourse.getCourseTimeSlot());
  }

  /**
   * Test Course class isCourseFull() method, when course enrollment is set to full.
   */
  @Test
  public void testIsCourseFullTrue() {
    testCourse.getEnrollmentCapacity();
    testCourse.setEnrolledStudentCount(250);
    assertTrue(testCourse.isCourseFull());
  }

  /**
   * Test Course class isCourseFull() method, when course enrollment is set to the max.
   */
  @Test
  public void testIsCourseFullFalse() {
    testCourse.setEnrolledStudentCount(200);
    assertFalse(testCourse.isCourseFull());
  }

  /** The test course instance used for testing. */
  public static Course testCourse;
}

