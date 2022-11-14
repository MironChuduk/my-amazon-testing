package amazon.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FormalTest extends BaseTest{
    @Test
    public void formalTest() {
        Assert.assertEquals(1, 1);
    }
}
