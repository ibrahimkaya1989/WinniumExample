import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.openqa.selenium.winium.WiniumDriverService;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestNG {

    static String exePath = System.getProperty("user.dir") + "\\Exes\\Winium.Desktop.Driver.exe";
    static WiniumDriver driver;
    static DesktopOptions options;
    static WiniumDriverService service;

    @BeforeTest
    public static void setupEnvironment(){
        options = new DesktopOptions(); //Instantiate Winium Desktop Options
        options.setApplicationPath("C:\\Windows\\System32\\calc.exe");
        File driverPath = new File(exePath);
        service = new WiniumDriverService.Builder().usingDriverExecutable(driverPath).usingPort(9999)
                .withVerbose(true).withSilent(false).buildDesktopService();
        try {
            service.start();
        } catch (IOException e) {
            System.out.println("Exception while starting WINIUM service");
            e.printStackTrace();
        }
        driver = new WiniumDriver(service, options);
    }

    @Test
    public void calculatorTest() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("num8Button")).click(); // num8Button
        driver.findElement(By.name("Multiply by")).click(); // Multiply by
        driver.findElement(By.id("num9Button")).click(); // num9Button
        driver.findElement(By.id("equalButton")).click();
        String results = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
        driver.findElement(By.id("Close")).click();
        System.out.println("Result is: "+ results);
    }

    @AfterTest
    public void tearDown(){
        service.stop();
    }
}
