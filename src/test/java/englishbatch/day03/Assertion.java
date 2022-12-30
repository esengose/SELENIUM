package englishbatch.day03;

import org.junit.Assert;
import org.junit.Test;

public class Assertion {
    @Test
    public void assertions(){
        /*
        What is assertion in testing?
        Assertion is done to check if expected result is equal to actual result.
        -expected == actual -> pass
        -expected != actual -> fail
        -------------------------------------------------------------------
        assertEquals("expected","actual");
        assertTrue(true); -> pass
        assertTrue(false); -> fail
        assertFalse(false); -> pass
        assertFalse(true); -> fail
        -------------------------------------------------------------------
         */
        Assert.assertEquals(5,5);//pass
        Assert.assertEquals("java","java");//pass
        Assert.assertEquals("java".contains("j"),true);//pass
        //----------------------------------------------------------------
        Assert.assertTrue("java".contains("j"));//pass
        //----------------------------------------------------------------
        Assert.assertFalse("Java".contains("j"));//pass
        //TEST EXECUTION STOPS IF ONE THE ASSERTION FAILS. THIS IS CALLED HARD ASSERTION

        //TEST EXECUTION CONTINUES EVEN IF TEST VERIFICATION FAILS. VERIFICATION MEANS LIKE IF STATEMENT.

        /*
                  INTERVIEW
           What is difference between Assertion and Verification?
           Assertion stops after assertion fails. Verification continues even after verification fails
           JUnit assertion are hard assertion. If statement is verification.
           NOTE: TestNG has soft assertion as well. We will learn it in TestNG.
         */
    }
}
