import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    float ingredientPrice = 200;
    float bunPrice = 100;
    float burgerPrice = 400;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient;

    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        burger.setBuns(bun);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        float actual = burger.getPrice();
        float expected = burgerPrice;
        assertEquals("price of burger is uncorrected", expected, actual, 0);
    }

    @Test
    public void getReceiptTest(){

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        burger.moveIngredient(1, 0);
        burger.removeIngredient(1);

        Mockito.when(bun.getName()).thenReturn("Флюоресцентная булка");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Соус Spicy-X");
        Mockito.when(burger.getPrice()).thenReturn(burgerPrice);

        String expected =
                "(==== Флюоресцентная булка ====)\r\n" +
                "= sauce Соус Spicy-X =\r\n" +
                "(==== Флюоресцентная булка ====)\r\n" +
                "\r\n" +
                "Price: 400,000000\r\n";

        String actual = burger.getReceipt();
        assertEquals("Burger created incorrectly",expected, actual);
    }
}
