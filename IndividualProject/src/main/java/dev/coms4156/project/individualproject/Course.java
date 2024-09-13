package dev.coms4156.project.individualproject;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a class within a department. This class stores information about
 * the course, including the instructor name, location, time slot, capacity, and 
 * number of enrolled students. 
 */
public class Course implements Serializable {

  /**
   * Constructs a new Course object with the given parameters. Initial count starts at 0.
   *
   * @param instructorName The name of the instructor teaching the course.
   * @param courseLocation The location where the course is held.
   * @param timeSlot The time slot of the course.
   * @param capacity The maximum number of students that can enroll in the course.
   */
  public Course(String instructorName, String courseLocation, String timeSlot, int capacity) {
    this.courseLocation = courseLocation;
    this.instructorName = instructorName;
    this.courseTimeSlot = timeSlot;
    this.enrollmentCapacity = capacity;
    this.enrolledStudentCount = 0;
  }

  /**
   * Enrolls a student in the course if there is space available.
   *
   * @return true if the student is successfully enrolled, false otherwise.
   */
  public boolean enrollStudent() {
    if (!isCourseFull()) {
      enrolledStudentCount++;
      return true;
    }

    return false;
  }

  /**
   * Drops a student from the course if a student is enrolled.
   *
   * @return true if the student is successfully dropped, false otherwise.
   */
  public boolean dropStudent() {
    enrolledStudentCount--;
    return false;
  }

  /**
   * Gets course location. 
   *
   * @return the location of the course. 
   */
  public String getCourseLocation() {
    return this.courseLocation;
  }

  /**
   * Gets instructor name for a course. 
   *
   * @return the instructor name.
   */
  public String getInstructorName() {
    return this.instructorName;
  }

  /**
   * Gets time slot for a course.
   *
   * @return the time slot.  
   */
  public String getCourseTimeSlot() {
    return this.courseTimeSlot;
  }

  /**
   * Gets enrollment capacity for course.
   *
   * @return the enrollment capacity.  
   */
  public int getEnrollmentCapacity() {
    return this.enrollmentCapacity;
  }

  public String toString() {
    return "\nInstructor: " + instructorName + "; Location: " + courseLocation + "; Time: "
        + courseTimeSlot;
  }

  /**
  * Reassigns course's instructor. 
  */
  public void reassignInstructor(String newInstructorName) {
    this.instructorName = newInstructorName;
  }

  /**
  * Reassign courses's location. 
  */
  public void reassignLocation(String newLocation) {
    this.courseLocation = newLocation;
  }

  /**
  * Reassigns course's time slot.
  */
  public void reassignTime(String newTime) {
    this.courseTimeSlot = newTime;
  }

  /**
  * Sets course's enrollment count. 
  */
  public void setEnrolledStudentCount(int count) {
    this.enrolledStudentCount = count;
  }

  /**
   * Checks if a course is full. 
   *
   * @return true if the course is full, false otherwise.
   */
  public boolean isCourseFull() {
    return enrollmentCapacity <= enrolledStudentCount;
  }

  @Serial
  private static final long serialVersionUID = 123456L;
  private final int enrollmentCapacity;
  private int enrolledStudentCount;
  private String courseLocation;
  private String instructorName;
  private String courseTimeSlot;
}
