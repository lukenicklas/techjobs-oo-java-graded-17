package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class JobTest {
    //TODO: Create your unit tests here

   @Before
   public void createTestData() {
       Job job1 = new Job();
       Job job2 = new Job();
   }
    @Test
    public void testSettingJobId() { //tests setting and getting job ids
        Job job1 = new Job();
        Job job2 = new Job();
        assertFalse(job1.getId() == job2.getId()); //tests that job ids are not equal
    }

    @Test
    public void testJobConstructorSetsAllFields() { //tests full job constructor
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertEquals("Product tester", testJob.getName());

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());

        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());

        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());

    }

    @Test
    public void testJobsForEquality() { //tests job equality
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
       Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(System.lineSeparator(), "" + job3.toString().charAt(0));
        assertEquals(System.lineSeparator(), "" + job3.toString().charAt(job3.toString().length() - 1));
   }

   @Test
    public void testToStringContainsCorrectLabelsAndData() {
       Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
       assertEquals(System.lineSeparator() + "ID: " + job4.getId() + System.lineSeparator() + "Name: Product tester" + System.lineSeparator() + "Employer: ACME" + System.lineSeparator() + "Location: Desert" + System.lineSeparator() + "Position Type: Quality control" + System.lineSeparator() + "Core Competency: Persistence" + System.lineSeparator(), job4.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));
        assertEquals(System.lineSeparator() + "ID: " + job5.getId() + System.lineSeparator() + "Name: Product tester" + System.lineSeparator() + "Employer: Data not available" + System.lineSeparator() + "Location: Desert" + System.lineSeparator() + "Position Type: Quality control" + System.lineSeparator() + "Core Competency: Data not available" + System.lineSeparator(), job5.toString());
    }
}