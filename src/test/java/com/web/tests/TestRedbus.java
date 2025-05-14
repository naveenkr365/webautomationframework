package com.web.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestRedbus {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.in/");


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        /*
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='From']/parent::div/input"))).sendKeys("Chennai");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/div/text[@class='placeHolderMainText'])[2]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='dest']"))).sendKeys("bangalore");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/div/text[@class='placeHolderMainText'])[2]"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='From']/parent::div/input"))).sendKeys("Chennai");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li/div/text[@class='placeHolderMainText'])[2]"))).click();
         */

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='From']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("srcDest"))).sendKeys("Chennai");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='CMBT, Chennai, Chennai'])[1]"))).click();

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='To']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("srcDest"))).sendKeys("Bangalore");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[text()='Marathahalli, Bangalore'])[1]"))).click();



        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Date of Journey']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='30']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search buses']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='View seats'])[2]"))).click();






    }

}

