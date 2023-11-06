import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

class DemoBlazeTest {

    WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        // Set an implicit wait for the driver
        //driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test() {
        // Exercise
        driver.get("https://www.demoblaze.com/");
        String title = driver.getTitle();

        // Verify
        assertThat(title).contains("STORE");

        driver.findElement(By.id("login2")).click();

        driver.findElement(By.id("loginusername")).sendKeys("test");
        driver.findElement(By.id("loginpassword")).sendKeys("test");

        System.out.println("finish");

    }

}