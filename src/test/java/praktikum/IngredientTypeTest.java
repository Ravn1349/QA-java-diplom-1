package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IngredientTypeTest {
    private static final int INGREDIENT_TYPE_LENGTH = 2;

    @Test
    public void ingredientTypeLengthIsCorrect() {
        int actual = IngredientType.values().length;
        assertEquals(INGREDIENT_TYPE_LENGTH, actual);
    }
}
