package lesson22;

import org.example.Man;
import org.example.Woman;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
@Test
public class ManWomanTest {
    @DataProvider(name = "peopleData")
    public Object[][] peopleData() {
        return new Object[][]{
                {new Man("Brad", "Pitt", 55), new Woman("Andjelina", "Joli", 50)},
        };
    }

    @Test(dataProvider = "peopleData")
    public void testGetFirstName(Man man, Woman woman) {
        Assert.assertEquals(man.getFirstName(), "Brad", "Name is not valid");
        Assert.assertEquals(woman.getFirstName(), "Andjelina", "Name is not valid");
    }

    @Test(dataProvider = "peopleData")
    public void testHasPartner(Man man, Woman woman) {
        man.registerPartnership(woman);

        Assert.assertEquals(man.hasPartner(), true, "Man's state is not valid");
        Assert.assertEquals(woman.hasPartner(), true, "Woman's state is not valid");

        man.deregisterPartnership(true);

        Assert.assertEquals(man.hasPartner(), false, "Man's state is not valid");
        Assert.assertEquals(woman.hasPartner(), false, "Woman's state is not valid");
    }

    @Test(dataProvider = "peopleData")
    public void testRegisterPartnership(Man man, Woman woman) {
        man.registerPartnership(woman);
        Assert.assertEquals(woman.getLastName(), man.getLastName());
    }
    @Test(dataProvider = "peopleData")
    public void testDeregisterPartnership(Man man, Woman woman) {
        man.registerPartnership(woman);
        man.deregisterPartnership(true);

        Assert.assertEquals(woman.getLastName(), "Joli");
        Assert.assertEquals(man.getLastName(), "Pitt");
    }

}