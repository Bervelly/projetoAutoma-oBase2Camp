package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class ManagePage extends PageBase {
    // Mapeamento de Seletores

    By passwordField = By.name("password");
    By buttonLogin = By.className("button");
    By seeManage = By.linkText("Manage Projects");

    // Actions

    public void fillPassword (String password){
        sendKeys(passwordField, password);
    }
    public void clickButton (){
        click(buttonLogin);
    }
    public void clickManageProjects (){
        click(seeManage);
    }
}
