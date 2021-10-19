import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        ChromeDriver 2.44
//        ---------------------
//        Supports Chrome v69-71
//        URL : https://chromedriver.storage.googleapis.com/index.html?path=2.44/
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Programs\\chromedriver_win32-2.44\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        ChromeOptions options = new ChromeOptions();

//        Electron API demos
//        ---------------------
//        URL : https://github.com/electron/electron-api-demos
//        Version : 2.0.2
//
//        process.versions
//        ----------------------
//        ares: "1.14.0"
//        chrome: "69.0.3497.106"
//        cldr: "33.1"
//        electron: "4.0.1"
//        http_parser: "2.8.0"
//        icu: "62.1"
//        modules: "64"
//        napi: "3"
//        nghttp2: "1.33.0"
//        node: "10.11.0"
//        openssl: "1.1.0"
//        tz: "2018e"
//        unicode: "11.0"
//        uv: "1.23.0"
//        v8: "6.9.427.24-electron.0"
//        zlib: "1.2.11"
        options.setBinary("C:\\Users\\muhsi\\AppData\\Local\\electron-api-demos\\app-2.0.2\\Electron API Demos.exe");
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new ChromeDriver(service, options);

        if (driver.findElements(By.id("button-about")).size() > 0)
            driver.findElement(By.id("button-about")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.id("get-started")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector("[class=\"nav-button\"]"));
        for (WebElement element : elements) {
            element.click();
        }
        driver.quit();
    }
}
