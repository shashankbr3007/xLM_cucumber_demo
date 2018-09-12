package com.xlm.cucumberdemo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;

@Service
public class DemoQAModel {


    By btn_draggable = By.id("menu-item-140");
    By btn_droppable = By.id("menu-item-141");
    By btn_resizable = By.id("menu-item-143");
    By btn_selectable = By.id("menu-item-142");
    By btn_sortable = By.id("menu-item-151");
    By landingPageHeader = By.className("entry-title");
    By landingPageContent = By.className("entry-content");
    By homePageImage = By.className("site-anchor");

    public void click_btn(WebDriver driver, By Button) {
        driver.findElement(Button).click();
    }

    public By getButtonElement(String buttonName) {

        switch (buttonName) {
            case "Draggable":
                return btn_draggable;

            case "Droppable":
                return btn_droppable;

            case "Resizable":
                return btn_resizable;

            case "Selectable":
                return btn_selectable;

            case "Sortable":
                return btn_sortable;

            default:
                return null;
        }
    }

    public String get_landingPageHeader(WebDriver driver) {
        return driver.findElement(landingPageHeader).getText();
    }

    public String get_landingPageContent(WebDriver driver) {
        return driver.findElement(landingPageContent).getText();
    }

}
