import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class WinniumExample {

    static String path = System.getProperty("user.dir");
    static String exePath = System.getProperty("user.dir") + "\\Exes\\Winium.Desktop.Driver.exe";

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println(path);

        System.out.println(exePath);

        Runtime.getRuntime().exec(exePath, null, new File(path));

        DesktopOptions option = new DesktopOptions();

        option.setApplicationPath("C:/Windows/System32/calc.exe");

        WiniumDriver winiumDriver = new WiniumDriver(new URL("http://localhost:9999"), option);

        Thread.sleep(5000);

        winiumDriver.findElement(By.name("One")).click();

        winiumDriver.findElement(By.name("Plus")).click();

        winiumDriver.findElement(By.name("Two")).click();

        winiumDriver.findElement(By.name("Equals")).click();

        String output = winiumDriver.findElement(By.id("CalculatorResults")).getAttribute("Name");

        System.out.println("Result after addition is: " + output);

        winiumDriver.quit();
    }
}
