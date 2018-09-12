package com.xlm.cucumberdemo.utility;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Utility {

    public static Properties property = new Properties();
    public static Robot robot;

    public static void loadProperty() throws Exception {

        try {
            property.load(new FileInputStream(new File("./src/main/resources/application.properties")));
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    public static Phrase setFont(String text, int size, BaseColor color) {
        FontSelector selector1 = new FontSelector();
        Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, size);
        f1.setColor(color);
        selector1.addFont(f1);
        Phrase ph = selector1.process(text);
        return ph;
    }

    public static PdfPCell setCellFonts(Phrase phrase, int horizontalAlignment, int verticalAlignment) {
        PdfPCell AlignCell = new PdfPCell(phrase);
        AlignCell.setHorizontalAlignment(horizontalAlignment);
        AlignCell.setVerticalAlignment(verticalAlignment);

        return AlignCell;
    }

    public static WebDriver loadDriver(String URL, String browser) {


        System.setProperty("java.awt.headless", "false");
        WebDriver driver = null;
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "./webdriver/geckodriverv0.19.1/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get(URL);
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "./webdriver/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(URL);
        }

        return driver;
    }

    public static String captureScreenshot(WebDriver driver, String path) throws AWTException, IOException {
        robot = new Robot();
        File imagePath = new File("./screenshots/" + path + ".jpg");
        String currentWindow = driver.getWindowHandle();
        driver.switchTo().window(currentWindow);
        BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ImageIO.write(screenShot, "JPG", imagePath);


        return imagePath.getAbsolutePath();
    }
}
