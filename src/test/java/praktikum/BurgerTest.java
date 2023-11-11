package praktikum;

import net.datafaker.Faker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Random;

import static org.junit.Assert.*;
import static praktikum.BunParameterizedTest.DELTA;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private static Faker faker = new Faker();
    private static Burger burger;
    private static IngredientType generateRandomIngredientType() {
        IngredientType[] values = IngredientType.values();
        int length = values.length;
        int randomIndex = new Random().nextInt(length);
        return values[randomIndex];
    }

    static Ingredient generateRandomIngredient() {
        IngredientType randomIngredientType = generateRandomIngredientType();
        String randomIngredientName = faker.name().firstName();
        float randomIngredientPrice = new Random().nextFloat();
        return new Ingredient(randomIngredientType, randomIngredientName, randomIngredientPrice);
    }

    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock;

    @Before
    public void init() {
        burger = new Burger();
    }
    @Test
    public void setBunsSetsBun() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }
    @Test
    public void addIngredientAddsIngredientToIngredients() {
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));
    }
    @Test
    public void removeIngredientRemovesIngredientFromIngredients() {
        burger.addIngredient(ingredientMock);
        int ingredientMockIndex = burger.ingredients.indexOf(ingredientMock);
        burger.removeIngredient(ingredientMockIndex);
        assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Mockito.when(bunMock.getPrice()).thenReturn(10F);
        Mockito.when(ingredientMock.getPrice()).thenReturn(100.0f);

        burger.setBuns(bunMock);
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredientMock);
        }

        float actual = burger.getPrice();
        float expected = 520.0f;
        assertEquals(expected, actual, DELTA);
    }

    @Test
    public void getReceiptReturnsCorrectReceipt() {
        Mockito.when(bunMock.getName()).thenReturn("название булки");
        Mockito.when(bunMock.getPrice()).thenReturn(10F);

        Mockito.when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMock.getName()).thenReturn("название ингредиента");


        burger.setBuns(bunMock);
        for (int i = 0; i < 5; i++) {
            burger.addIngredient(ingredientMock);
        }

        String actual = burger.getReceipt();
        String expected = "(==== название булки ====)\r\n" +
                "= filling название ингредиента =\r\n" +
                "= filling название ингредиента =\r\n" +
                "= filling название ингредиента =\r\n" +
                "= filling название ингредиента =\r\n" +
                "= filling название ингредиента =\r\n" +
                "(==== название булки ====)\r\n" +
                "\r\n" +
                "Price: 20,000000\r\n";
        assertEquals(expected, actual);
    }
}
