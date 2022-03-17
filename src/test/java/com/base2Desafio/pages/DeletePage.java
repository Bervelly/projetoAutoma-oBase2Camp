package com.base2Desafio.pages;

import com.base2Desafio.bases.PageBase;
import org.openqa.selenium.By;

public class DeletePage extends PageBase {
    // Mapeamento de Seletores

    By deleteIssues = By.className("button");
    By consultingName = By.xpath("/html/body/div[2]/form/div/table/tbody/tr[2]/td[2]");


    //Actions

    public void clickDeleteIssue() {
        click(deleteIssues);
    }
    public String getName(){
      return getText(consultingName);
    }
}
