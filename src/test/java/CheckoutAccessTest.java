import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutAccessTest extends TestBase {
    @Test
    public void testUnauthenticatedUserCannotAccessCheckout() throws InterruptedException{
        // 1. Otvori stranicu za prijavu
        driver.get(baseUrl);

        // 2. Klikni na gumb za usluge
        driver.findElement(By.xpath("/html//a[@id='usluge']"))
                .click();
        Thread.sleep(500);

        // 3. Klikni na prvu vrstu usluge koja se pruza
        driver.findElement(By.xpath("/html//ul[@class='lista-usluga']//a[@href='/usluga/1']/span[@class='opis-usluge']"))
            .click();
        Thread.sleep(500);

        // 4. Dodaj proizvod u kosaricu
        driver.findElement(By.xpath("/html//div[@class='grid']/main[@class='container']//a[@href='http://127.0.0.1:8000/dodaj-u-kosaricu/19']"))
                .click();
        Thread.sleep(500);

        // 5. Provjeri vraca li nas na prijavu
        Assert.assertEquals(baseUrl + "prijava", driver.getCurrentUrl(), "Došli smo na URL: " + driver.getCurrentUrl());


    }
}
