import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    @Mock
    IngredientType ingredientTypeMock;
    float priceMock;
    String nameMock;

    IngredientType ingredientType;
    private final String expected;

    public IngredientTest(IngredientType ingredientType, String expected){
        this.ingredientType = ingredientType;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getIngredientType() {
        return new Object[][] {
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }

    @Test
    public void testGetTypeWithParameters() {
        Ingredient ingredient = new Ingredient(ingredientType, nameMock, priceMock);
        assertEquals(expected, ingredient.getType().toString());
    }

    @Test
    public void testGetPrice(){

        float price = 1337;
        Ingredient ingredient = new Ingredient(ingredientTypeMock, nameMock, price);

        float actualPrice = ingredient.getPrice();
        float expectedPrice = 1337;
        assertEquals("price of ingredient should be 1337 ",expectedPrice,actualPrice,0);
    }

    @Test
    public void testGetName(){
        String name = "Protostomia";
        Ingredient ingredient = new Ingredient(ingredientTypeMock, name, priceMock);

        String actualName = ingredient.getName();
        String expectedName = "Protostomia";
        assertEquals("Name of ingredient should be Protostomia",expectedName, actualName);
    }
}
