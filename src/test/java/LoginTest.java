import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void testSuccessfulLogin() throws InterruptedException{
        // 1. Otvori stranicu za prijavu
        driver.get(baseUrl + "prijava");

        // 2. Unesi email i lozinku
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/input[@name='email']"))
                .sendKeys("marko@gmail.com");
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/input[@name='password']"))
                .sendKeys("asdfasdf");

        // 3. Klikni na gumb za prijavu
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/button[@type='submit']"))
                .click();

        // 4. Provjeri da je korisnik prijavljen
        WebElement logout = driver.findElement(By.xpath("/html//button[@id='odjava']"));
        logout.click();

        Thread.sleep(500);

        // 5. Provjeri vraca li nas na prijavu
        Assert.assertEquals(baseUrl + "prijava", driver.getCurrentUrl(), "Došli smo na URL: " + driver.getCurrentUrl());

    }
}