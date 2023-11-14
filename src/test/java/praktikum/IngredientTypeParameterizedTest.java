package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {

    private IngredientType expectedValue;
    private IngredientType actualValue;

    public IngredientTypeParameterizedTest(IngredientType expectedValue, IngredientType actualValue) {
        this.expectedValue = expectedValue;
        this.actualValue = actualValue;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientTypes() {
        return new Object[][] {
                {IngredientType.valueOf("SAUCE"), IngredientType.SAUCE},
                {IngredientType.valueOf("FILLING"), IngredientType.FILLING},
        };
    }

    @Test
    public void ingredientTypesValuesArePresentAndCorrect() {
        assertEquals(expectedValue, actualValue);
    }
}
