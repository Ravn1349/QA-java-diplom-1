package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class BunParameterizedTest {
    static final int DELTA = 0;
    private float bunPrice;
    private String bunName;
    private static Bun bun;

    public BunParameterizedTest (float bunPrice, String bunName) {
        this.bunPrice = bunPrice;
        this.bunName = bunName;
    }
    @Parameterized.Parameters
    public static Object[][] getPrices() {
        return new Object[][] {
                {Float.MAX_VALUE, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"},
                {Math.nextDown(Float.MAX_VALUE), "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"},
                {Math.nextUp(0f), "abcdefghijklmnopqrstuvwxyz"},
                {0f, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"},
                {-0f, "0123456789"},
                {Math.nextDown(0f), "~`!@#$%^&*()-_+={}[]|\\/:;\"'<>,.? "},
                {Math.nextUp(Float.MIN_VALUE), ""},
                {Float.MIN_VALUE, "Навальный"},
        };
    }

    @Before
    public void init() {
        bun = new Bun(bunName, bunPrice);
    }
    @Test
    public void getPriceReturnsPrice() {
        float actual = bun.getPrice();
        float expected = bunPrice;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getNameReturnsName() {
        String actual = bun.getName();
        String expected = bunName;
        assertEquals(expected, actual);
    }
}
