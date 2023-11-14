package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static praktikum.BurgerTest.generateRandomIngredient;

@RunWith(Parameterized.class)
public class BurgerParameterizedTest {
    private int numberOfIngredients;
    private int index;
    private int newIndex;
    private static Burger burger;

    public BurgerParameterizedTest(int numberOfIngredients, int index, int newIndex) {
        this.numberOfIngredients = numberOfIngredients;
        this.index = index;
        this.newIndex = newIndex;
    }

    @Parameterized.Parameters
    public static Object[][] getIndices() {
        return new Object[][] {
                {3, 1, 0},
                {3, 1, 1},
                {3, 1, 2},
        };
    }

    @Before
    public void init() {
        burger = new Burger();
    }
    @Test
    public void moveIngredientMovesIngredientInIngredients() {

        for (int i = 0; i < numberOfIngredients; i++) {
            burger.ingredients.add(generateRandomIngredient());
        }

        Ingredient testIngredient = burger.ingredients.get(index);

        burger.moveIngredient(index, newIndex);

        assertEquals(burger.ingredients.indexOf(testIngredient), newIndex);
    }
}
