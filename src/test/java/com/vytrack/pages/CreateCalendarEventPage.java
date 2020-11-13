package com.vytrack.pages;

import com.vytrack.utils.BrowserUtils;
import com.vytrack.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCalendarEventPage extends BasePage {

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEventBtn;

    public WebElement getCreateElemCelBtn() {
        return createCalendarEventBtn;
    }

    @FindBy(name = "oro_calendar_event_form[title]")
    private WebElement titleInputBox;

    public WebElement getTitleInputBox() {
        return titleInputBox;
    }

    @FindBy(id = "tinymce")
    private WebElement descriptionInputBox;

    public WebElement getDescriptionInputBox() {
        return descriptionInputBox;
    }

    public void clickOnCreateEventButton() {
        BrowserUtils.clickOnElement(createCalendarEventBtn);
    }

    public void enterTitle(String title) {
        BrowserUtils.enterText(titleInputBox, title);

    }

    public void enterDescription(String description) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);

        // exit from all frames
        Driver.getDriver().switchTo().defaultContent();
        // wait for the frame and switch to it
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
        // enter text
        descriptionInputBox.sendKeys(description);
        // exit from the frame
        Driver.getDriver().switchTo().defaultContent();

    }

    public String getDataFromGeneralInfo(String parameterName) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        // find value of general info on the page: title, description
        String xpath = "//label[text()='" + parameterName+ "']/../div/div";

        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return element.getText().trim();


    }

}