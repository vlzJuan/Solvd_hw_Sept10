package solvd.laba;

import java.io.File;

import static solvd.laba.serviceclasses.LogService.logToFile;
import static solvd.laba.serviceclasses.MenuService.operateOverText;
import static solvd.laba.serviceclasses.MenuService.textMenu;

public class Main {

    public static void main(String[] args) {

        String logFileName = "./src/main/resources/log_file.txt";
        File logFile = new File(logFileName);
        logToFile(logFile, "Initialized log session.", false);

        String text = textMenu(logFile);

        System.out.println(text);

        operateOverText(logFile,text);

    }

}