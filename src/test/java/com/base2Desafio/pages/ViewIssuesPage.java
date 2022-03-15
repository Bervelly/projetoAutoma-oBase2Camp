package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class ViewIssuesPage extends PageBase {
    // Mapeamento de Seletores

    By searchReport = By.id("reporter_id_filter");
    By selectReporter = By.name("reporter_id[]");
    By fillSearch = By.name("search");
    By filter = By.name("filter");
    By editPencil = By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[2]/a/img");
    By editSummary = By.name("summary");
    By clickEditSummary = By.className("button");
    By chooseCheckBox = By.cssSelector("#buglist > tbody > tr:nth-child(4) > td:nth-child(1) > input[type=checkbox]");
    By resolveReport = By.name("action");
    By chooseResolve = By.name("resolution");
    By buttonResolve = By.className("button");
    By selectDelete = By.name("action");
    By clickOk = By.className("button");
    By deleteIssues = By.className("button");


    // Actions
    public void fillReporter(){
        click(searchReport);
    }
    public void selectClickReporter(String reporterI){
        comboBoxSelectByVisibleText(selectReporter, reporterI);
    }
    public void selectFilter(){
        click(filter);
    }
    public void fieldFillSearch(String searchFill){
        sendKeys(fillSearch, searchFill);
    }
    public void  editReport(){
        click(editPencil);
    }

    public void editNewSummary(String newName){
        sendKeys(editSummary, newName);
    }
    public void clickEdit(){
        click(clickEditSummary);
    }
    public void clickCheckBox(){
        click(chooseCheckBox);
    }
    public void clickSelectDelete(String valueDelete){
        comboBoxSelectByVisibleText(selectDelete,valueDelete);
    }
    public void selectOk(){
        click(clickOk);
    }
    public void clickDeleteIssue(){
        click(deleteIssues);
    }
    public void checkResolve(String resolveIssue){
        comboBoxSelectByVisibleText(resolveReport,resolveIssue);
    }
    public void selectChooseResolve (String chooseField){
        comboBoxSelectByVisibleText(chooseResolve, chooseField);
    }
    public void buttonResolveIssue(){
        click(buttonResolve);
    }


}
