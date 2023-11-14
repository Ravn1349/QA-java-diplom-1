package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static praktikum.BunParameterizedTest.DELTA;
@RunWith(Parameterized.class)
public class IngredientParameterizedTest {

    private String ingredientName;
    private float ingredientPrice;
    private IngredientType ingredientType;
    private static Ingredient ingredient;

    public IngredientParameterizedTest(float ingredientPrice, String ingredientName, IngredientType ingredientType) {
        this.ingredientPrice = ingredientPrice;
        this.ingredientName = ingredientName;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypes() {
        return new Object[][] {
                {Float.MAX_VALUE, "абвгдеёжзийклмнопрстуфхцчшщъыьэюя", IngredientType.SAUCE},
                {Math.nextDown(Float.MAX_VALUE), "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ", IngredientType.FILLING},
                {Math.nextUp(0f), "abcdefghijklmnopqrstuvwxyz", IngredientType.SAUCE},
                {0f, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", IngredientType.FILLING},
                {-0f, "0123456789", IngredientType.SAUCE},
                {Math.nextDown(0f), "~`!@#$%^&*()-_+={}[]|\\/:;\"'<>,.? ", IngredientType.FILLING},
                {Math.nextUp(Float.MIN_VALUE), "", IngredientType.SAUCE},
                {Float.MIN_VALUE, "Grzegorz Brzęczyszczykiewicz", IngredientType.FILLING},
        };
    }

    @Before
    public void init() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getPriceReturnsPrice() {
        float actual = ingredient.getPrice();
        float expected = ingredientPrice;
        assertEquals(expected, actual, DELTA);
    }
    @Test
    public void getNameReturnsName() {
        String actual = ingredient.getName();
        String expected = ingredientName;
        assertEquals(expected, actual);
    }

    @Test
    public void getTypeReturnsType() {
        IngredientType actual = ingredient.getType();
        IngredientType expected = ingredientType;
        assertEquals(expected, actual);
    }
}
