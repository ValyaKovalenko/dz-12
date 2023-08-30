package lesson22;

import org.example.Person;
import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class AgeManWomanTest {
    @DataProvider(name = "peopleRetiredData")
    public Object[][] peopleRetiredData() {
        return new Object[][]{
                {new Man("Retired Man", "Lastname", 65), true},
                {new Woman("Retired Woman", "Lastname", 60), true},
                {new Man("Young Man", "Lastname", 64), false},
                {new Woman("Young Woman", "Lastname", 59), false}
        };
    }

    @Test(dataProvider = "peopleRetiredData")
    public void testIsRetired(Person person, boolean expectedResult) {
        Assert.assertEquals(person.isRetired(), expectedResult);
    }

}