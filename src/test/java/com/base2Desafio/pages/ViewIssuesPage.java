package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class ViewIssuesPage extends PageBase {
    // Mapeamento de Seletores
    By searchReport = By.name("search");
    By clickSearch = By.className("button-small");
    By editPencil = By.xpath("//*[@id=\"buglist\"]/tbody/tr[4]/td[2]/a/img");
    By editSummary = By.name("summary");
    By clickEditSummary = By.className("button");
    By deleteReport = By.xpath("//*[@id=\"buglist\"]/tbody/tr[5]/td[1]/input");
    By selectDelete = By.name("action");
    By clickOk = By.className("button");
    By deleteIssues = By.className("button");


    // Actions
    public void fillReporter (String search){
        sendKeys(searchReport, search);
    }
    public void selectClickSearch(){
        click(clickSearch);
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
    public void clickDelete(){
        click(deleteReport);
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
}
