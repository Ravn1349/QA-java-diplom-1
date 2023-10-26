package praktikum;

import net.datafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private static Faker faker = new Faker();
    private static String bunName;
    private static float bunPrice;
    private static Bun bun;
    @Before
    public void init() {
        bunName = faker.name().firstName();
        bunPrice = new Random().nextFloat();
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void getNameReturnsName() {
        String actual = bun.getName();
        String expected = bunName;
        assertEquals(expected, actual);
    }
    @Test
    public void getPriceReturnsPrice() {
        float actual = bun.getPrice();
        float expected = bunPrice;
        assertEquals(expected, actual, 0);
    }
}
