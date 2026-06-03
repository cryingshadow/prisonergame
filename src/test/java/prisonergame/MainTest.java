package prisonergame;

import java.io.*;

import org.testng.*;
import org.testng.annotations.*;

public class MainTest {

    @DataProvider
    public Object[][] mainData() {
        return new Object[][] {
            {0, 0}
        };
    }

    @Test(dataProvider="mainData")
    public void mainTest(final int test, final int expected) throws IOException {
        Assert.assertEquals(test, expected);
    }

}
