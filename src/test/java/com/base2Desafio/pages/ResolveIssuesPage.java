package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class ResolveIssuesPage extends PageBase {
    //Mapeando seletores
    By chooseResolve = By.name("resolution");
    By buttonResolve = By.className("button");
    By consultingNameResolve = By.xpath("/html/body/div[2]/form/div/table/tbody/tr[2]/td[2]");

    //Actions
    public void selectChooseResolve (String chooseField){
        comboBoxSelectByVisibleText(chooseResolve, chooseField);
    }

    public void buttonResolveIssue(){
        click(buttonResolve);
    }

    public String getNameResolve(){
        return getText(consultingNameResolve);
    }
}
