package praktikum;

import net.datafaker.Faker;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class IngredientTest {

    private static Faker faker = new Faker();
    private static String ingredientName;
    private static float ingredientPrice;
    private static IngredientType ingredientType;
    private static Ingredient ingredient;

    private static IngredientType generateRandomIngredientType() {
        IngredientType[] values = IngredientType.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
    @Before
    public void init() {
        ingredientName = faker.name().firstName();
        ingredientPrice = new Random().nextFloat();
        ingredientType = generateRandomIngredientType();
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
    }

    @Test
    public void getPriceReturnsPrice() {
        float actual = ingredient.getPrice();
        float expected = ingredientPrice;
        assertEquals(expected, actual, 0);
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
