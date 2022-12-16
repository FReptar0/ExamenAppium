package com.example;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class AppTest {
    @Test
    public void puntosLocal() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "MI 11T Pro");
        cap.setCapability("udid", "b9be0aa8");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("appPackage", "gms.utez.basketballscore");
        cap.setCapability("appActivity", "gms.utez.basketballscore.MainActivity");

        URL url = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);

        System.out.println("Application started");

        MobileElement btnDosPuntosLocal = (MobileElement) driver
                .findElementById("gms.utez.basketballscore:id/btnMas2Local");

        for (int i = 0; i < 14; i++) {
            btnDosPuntosLocal.click();
        }

        // tomar screenshot de la pantalla del celular
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: " + srcFile.getAbsolutePath());
    }

    @Test
    public void puntosSimultaneos() throws MalformedURLException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "MI 11T Pro");
        cap.setCapability("udid", "b9be0aa8");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("appPackage", "gms.utez.basketballscore");
        cap.setCapability("appActivity", "gms.utez.basketballscore.MainActivity");

        URL url = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);

        System.out.println("Application started");

        MobileElement btnUnPuntoVisitante = (MobileElement) driver
                .findElementById("gms.utez.basketballscore:id/btnMas1Visitor");

        MobileElement btnUnPuntosLocal = (MobileElement) driver
                .findElementById("gms.utez.basketballscore:id/btnMas1Local");

        MobileElement btnFinish = (MobileElement) driver
                .findElementById("gms.utez.basketballscore:id/btnFinish");

        for (int i = 0; i < 26; i++) {
            btnUnPuntoVisitante.click();
        }

        for (int i = 0; i < 25; i++) {
            btnUnPuntosLocal.click();
        }

        btnFinish.click();
        Thread.sleep(5000);

        // tomar screenshot de la pantalla del celular
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: " + srcFile.getAbsolutePath());

    }

    @Test
    public void puntosNegativos() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "MI 11T Pro");
        cap.setCapability("udid", "b9be0aa8");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "12");
        cap.setCapability("appPackage", "gms.utez.basketballscore");
        cap.setCapability("appActivity", "gms.utez.basketballscore.MainActivity");

        URL url = new URL("http://localhost:4723/wd/hub");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, cap);

        System.out.println("Application started");

        MobileElement btnMenosVisitante = (MobileElement) driver
                .findElementById("gms.utez.basketballscore:id/btnMenos1Visitor");

        btnMenosVisitante.click();

        // tomar screenshot de la pantalla del celular
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: " + srcFile.getAbsolutePath());
    }

}
