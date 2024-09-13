package dev.coms4156.project.individualproject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Unit tests for IndividualProjectApplication class.
 */
@SpringBootTest
@ContextConfiguration
public class IndividualProjectApplicationUnitTests {

  private IndividualProjectApplication app;
  private MyFileDatabase fileDatabase;


  /**
   * Setup MyFileDatabase instance for testing IndividualProjectApplication functionality.
   */
  @BeforeEach
  public void setUp() {
    fileDatabase = new MyFileDatabase(0, "./data.txt");
    app = new IndividualProjectApplication();
    app.resetDataFile();
  }

  /**
   * Test for IndividualProjectApplication run() method without setup argument. 
   */
  @Test
  public void testRunApplicationWithoutSetupArg() {
    String[] args = {};
    IndividualProjectApplication app = new IndividualProjectApplication();
    app.run(args);

    assertNotNull(IndividualProjectApplication.myFileDatabase);
  }

  /**
   * Test for IndividualProjectApplication run() method with setup argument. 
   */
  @Test
  public void testRunApplicationWithSetup() {
    String[] args = {"setup"};
    IndividualProjectApplication app = new IndividualProjectApplication();
    app.run(args);

    assertNotNull(IndividualProjectApplication.myFileDatabase);
  }

  /**
   * Test for IndividualProjectApplication resetDataFile() method. 
   */
  @Test
  public void testResetDataFile() {
    app.resetDataFile();

    HashMap<String, Department> mapping = fileDatabase.getDepartmentMapping();

    // verify each dept present in mapping and course selection contains correct # of courses

    // COMS
    assertTrue(mapping.containsKey("COMS"));
    Department coms = mapping.get("COMS");
    assertEquals("COMS", coms.getDepartmentCode());
    assertEquals("Luca Carloni", coms.getDepartmentChair());
    assertEquals(2700, coms.getNumberOfMajors());
    assertEquals(8, coms.getCourseSelection().size());

    // ECON
    assertTrue(mapping.containsKey("ECON"));
    Department econDept = mapping.get("ECON");
    assertEquals("ECON", econDept.getDepartmentCode());
    assertEquals("Michael Woodford", econDept.getDepartmentChair());
    assertEquals(2345, econDept.getNumberOfMajors());
    assertEquals(8, econDept.getCourseSelection().size());

    // IEOR
    assertTrue(mapping.containsKey("IEOR"));
    Department ieorDept = mapping.get("IEOR");
    assertEquals("IEOR", ieorDept.getDepartmentCode());
    assertEquals("Jay Sethuraman", ieorDept.getDepartmentChair());
    assertEquals(67, ieorDept.getNumberOfMajors());
    assertEquals(8, ieorDept.getCourseSelection().size());

    // CHEM
    assertTrue(mapping.containsKey("CHEM"));
    Department chemDept = mapping.get("CHEM");
    assertEquals("CHEM", chemDept.getDepartmentCode());
    assertEquals("Laura J. Kaufman", chemDept.getDepartmentChair());
    assertEquals(250, chemDept.getNumberOfMajors());
    assertEquals(8, chemDept.getCourseSelection().size());

    // PHYS
    assertTrue(mapping.containsKey("PHYS"));
    Department physDept = mapping.get("PHYS");
    assertEquals("PHYS", physDept.getDepartmentCode());
    assertEquals("Dmitri N. Basov", physDept.getDepartmentChair());
    assertEquals(43, physDept.getNumberOfMajors());
    assertEquals(8, physDept.getCourseSelection().size());

    // ELEN
    assertTrue(mapping.containsKey("ELEN"));
    Department elenDept = mapping.get("ELEN");
    assertEquals("ELEN", elenDept.getDepartmentCode());
    assertEquals("Ioannis Kymissis", elenDept.getDepartmentChair());
    assertEquals(250, elenDept.getNumberOfMajors());
    assertEquals(8, elenDept.getCourseSelection().size());

    // PSYC
    assertTrue(mapping.containsKey("PSYC"));
    Department psycDept = mapping.get("PSYC");
    assertEquals("PSYC", psycDept.getDepartmentCode());
    assertEquals("Nim Tottenham", psycDept.getDepartmentChair());
    assertEquals(437, psycDept.getNumberOfMajors());
    assertEquals(8, psycDept.getCourseSelection().size());
  }

}
