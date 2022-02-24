import com.github.javafaker.Faker;
import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    @Mock
    float priceMock;
    String nameMock;

    private String randomName;
    private float randomPrice;

    @Test
    public void testGetName(){
        randomName = "R2-D3";
        Bun bun = new Bun(randomName, priceMock);
        String actualName = bun.getName();
        assertEquals("Incorrect name of bun",randomName,actualName);
    }

    @Test
    public void testGetPrice(){
        randomPrice = 988;
        Bun bun = new Bun(nameMock, randomPrice);
        float actualPrice = bun.getPrice();
        assertEquals("Incorrect price of bun",randomPrice,actualPrice,0);
    }
}
