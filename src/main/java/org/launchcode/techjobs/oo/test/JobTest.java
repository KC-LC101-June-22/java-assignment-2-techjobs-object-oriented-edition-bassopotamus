package org.launchcode.techjobs.oo.test;

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

        assertEquals(test_job_3.getName(), "Product tester");
        assertEquals(test_job_3.getEmployer().toString(), "ACME");
        assertEquals(test_job_3.getLocation().toString(), "Desert");
        assertEquals(test_job_3.getPositionType().toString(), "Quality control");
        assertEquals(test_job_3.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job test_job_4 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));
        Job test_job_5 = new Job("Typing monkey", new Employer("Microsoft"), new Location("Redmond"), new PositionType("Button hitter"), new CoreCompetency("Hit buttons"));

        assertFalse(test_job_4.equals(test_job_5));
    }

}