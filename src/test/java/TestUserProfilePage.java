import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class TestUserProfilePage extends TestBase{
    @Test
    public void testUserProfile() throws InterruptedException{
        // 1. Otvori stranicu za prijavu
        driver.get(baseUrl + "prijava");
        Thread.sleep(500);

        // 2. Unesi email i lozinku
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/input[@name='email']"))
                .sendKeys("matej@gmail.com");
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/input[@name='password']"))
                .sendKeys("asdfasdf");
        Thread.sleep(500);

        // 3. Klikni na gumb za prijavu
        driver.findElement(By.xpath("/html//form[@action='http://127.0.0.1:8000/prijava']/button[@type='submit']"))
                .click();
        Thread.sleep(500);

        //4. Klikni na gumb za pristup profilu korisnika
        driver.findElement(By.xpath("/html//div[@class='grid']//a[@href='/profil']/img[@alt='Profil']"))
                .click();
        Thread.sleep(1000);

        // 5. Provjeri otvara li stranica profila korisnika
        Assert.assertEquals(baseUrl + "profil", driver.getCurrentUrl(), "Došli smo na URL: " + driver.getCurrentUrl());
        Thread.sleep(500);
    }
}
