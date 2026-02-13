import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TestNegativeQuantity extends TestBase{
    @Test
    public void testNegativeCartQuantityI() throws InterruptedException{
        // 1. Otvori stranicu za prijavu
        driver.get(baseUrl + "prijava");

        // 2. Unesi email i lozinku
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/input[@name='email']"))
                .sendKeys("matej@gmail.com");
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/input[@name='password']"))
                .sendKeys("asdfasdf");

        // 3. Klikni na gumb za prijavu
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/button[@type='submit']"))
                .click();

        // 4. Klikni na gumb za usluge
        driver.findElement(By.xpath("/html//a[@id='usluge']"))
                .click();
        Thread.sleep(500);

        // 5. Klikni na prvu vrstu usluge koja se pruza
        driver.findElement(By.xpath("/html//div[@class='grid']//ul[@class='lista-usluga']//a[@href='/usluga/1']"))
                .click();
        Thread.sleep(500);

        // 6. Dodaj proizvod u kosaricu
        driver.findElement(By.xpath("/html//div[@class='grid']/main[@class='container']//a[@href='http://127.0.0.1:8000/dodaj-u-kosaricu/19']"))
                .click();
        Thread.sleep(500);

        // 6. Otvori kosaricu
        driver.findElement(By.xpath("/html//div[@class='grid']//a[@href='http://127.0.0.1:8000/kosarica']"))
                .click();
        Thread.sleep(500);

        //7. Potrebno je postaviti kolicinu na -1
        WebElement quantityInput = driver.findElement(By.xpath("/html//div[@id='kosarica-proizvodi']//div[@class='kolicina-wrapper']/input[@name='kolicina']"));
        quantityInput.clear();
        quantityInput.sendKeys("-1");
        Thread.sleep(500);

        //8. Potrebno je provjeriti je li ukupna cijena sada negativna
        WebElement totalElement = driver.findElement(By.xpath("//div[@id='kosarica-proizvodi']//h2[@class='ukupno']"));
        String totalText = totalElement.getText();
        Assert.assertFalse(totalText.contains("-"),
                "Ukupna cijena sadrži negativan predznak! Dobiveno: " + totalText);

    }
}
