package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class HomePage extends PageBase {

    //Mapeamento dos Seletores
    By bugOccurrence = By.linkText("Report Issue");
    By manageBug = By.linkText("Manage");
    By viewIssues = By.linkText("View Issues");

    //Actions
    public void clickReportIssue (){
        click(bugOccurrence);
    }
    public void clickManage (){
        click(manageBug);
    }
    public void clickViewIssues (){
        click(viewIssues);
    }

    }



