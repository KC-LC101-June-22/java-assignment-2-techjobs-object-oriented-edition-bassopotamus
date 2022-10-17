package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job test_job_1 = new Job();
        Job test_job_2 = new Job();

        assertNotEquals(test_job_1.getId(), test_job_2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job test_job_3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(test_job_3.getName() instanceof String);
        assertTrue(test_job_3.getEmployer() instanceof Employer);
        assertTrue(test_job_3.getLocation() instanceof Location);
        assertTrue(test_job_3.getPositionType() instanceof PositionType);
        assertTrue(test_job_3.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", test_job_3.getName());
        assertEquals("ACME", test_job_3.getEmployer().toString());
        assertEquals("Desert", test_job_3.getLocation().toString());
        assertEquals("Quality control", test_job_3.getPositionType().toString());
        assertEquals("Persistence", test_job_3.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality(){
        Job test_job_4 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        Job test_job_5 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));

        assertFalse(test_job_4.equals(test_job_5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test_job_6 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        String stringToTest = test_job_6.toString();
        String test = "\n";


        assertEquals("\n", String.valueOf(stringToTest.charAt(0)));
        assertEquals("\n", String.valueOf(stringToTest.charAt(stringToTest.length()-1)));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test_job_7 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        String stringToTest2 = test_job_7.toString();

        assertTrue(stringToTest2.contains("ID: 4"));
        assertTrue(stringToTest2.contains("Name: Typing monkey"));
        assertTrue(stringToTest2.contains("Employer: Microsoft"));
        assertTrue(stringToTest2.contains("Location: Redmond"));
        assertTrue(stringToTest2.contains("Position Type: Button hitter"));
        assertTrue(stringToTest2.contains("Core Competency: Hit buttons"));

    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job test_job_7 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String stringToTest2 = test_job_7.toString();

        assertTrue(stringToTest2.contains("Name: Data not available"));
        assertTrue(stringToTest2.contains("Employer: Data not available"));
        assertTrue(stringToTest2.contains("Location: Data not available"));
        assertTrue(stringToTest2.contains("Position Type: Data not available"));
        assertTrue(stringToTest2.contains("Core Competency: Data not available"));

    }
}