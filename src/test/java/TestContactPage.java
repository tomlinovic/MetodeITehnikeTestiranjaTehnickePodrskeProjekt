import org.example.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
public class TestContactPage extends TestBase{
    @Test
    public void testContactPage() throws InterruptedException{
        // 1. Otvori stranicu za prijavu
        driver.get(baseUrl);
        Thread.sleep(500);
        // 2. Klikni na kontakt gumb
        driver.findElement(By.xpath("/html//div[@class='grid']//a[@href='/kontakt']"))
                .click();
        Thread.sleep(500);

        // 3. Provjeri otvara li kontakt stranicu
        Assert.assertEquals(baseUrl + "kontakt", driver.getCurrentUrl(), "Došli smo na URL: " + driver.getCurrentUrl());
        Thread.sleep(500);

        //4. Provjerava postoji li email ispisan na stranici
        WebElement emailElement = driver.findElement(By.xpath("/html//div[@class='grid']//p[.='Email: senior.briga@senior.hr']"));
        String emailElementTest = emailElement.getText();
        String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
        Pattern pattern = Pattern.compile(emailRegex);
        // Provjeri postoji li email u tekstu
        boolean containsEmail = pattern.matcher(emailElementTest).find();
        Assert.assertTrue(containsEmail,
                "Element ne sadrži email adresu! Tekst: " + emailElementTest);
    }
}
