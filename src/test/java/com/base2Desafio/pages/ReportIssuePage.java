package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class ReportIssuePage extends PageBase {
    // Mapeamento de Seletores

    By categoryField = By.tagName("Select");
    By categoryOptions = By.name("category_id");
    By reproducibilityField = By.name("reproducibility");
    By reproducibilityOptions = By.name("reproducibility");
    By selectSeverity = By.name("severity");
    By selectOptionsSeverity = By.name("severity");
    By assignField = By.name("handler_id");
    By selectAssign = By.name("handler_id");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By buttonReport = By.className("button");


    //Actions
    public void clickCategory (){
        click(categoryField);
    }
    public void selectCategoryOptions (String value){
        comboBoxSelectByVisibleText(categoryOptions, value);
    }
    public void clickReproducibility (){
        click(reproducibilityField);
    }
    public void selectReproducibilityOptions (String valueOptions){
        comboBoxSelectByVisibleText(reproducibilityOptions, valueOptions);
    }
    public void clickSeverity (){
        click(selectSeverity);
    }
    public void selectSeverityOptions (String valueSeverity){
        comboBoxSelectByVisibleText(selectOptionsSeverity, valueSeverity);
    }
    public void clickSelectAssign(){
        click(selectAssign);
    }
    public void chooseAssign (String assignTo){
        comboBoxSelectByVisibleText(assignField, assignTo);
    }
    public void fillSummary (String summaryFill){
        sendKeys(summaryField, summaryFill);
    }

    public void fillDescription (String descriptionFill) {
        sendKeys(descriptionField, descriptionFill);
    }

    public void clickReport(){
        click(buttonReport);
    }


}
