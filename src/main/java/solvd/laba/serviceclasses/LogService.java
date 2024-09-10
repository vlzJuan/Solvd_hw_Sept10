package solvd.laba.serviceclasses;

import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;

import static java.lang.String.format;

public class LogService {

    private static final DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy , HH:mm:ss");

    public static void logToFile(File logFile, String log, boolean appendOption){
        try {
            FileUtils.write(logFile, format("%s : %s\n", LocalDateTime.now().format(pattern), log),
                    StandardCharsets.UTF_8, appendOption);
        }
        catch (IOException e){
            //
        }
    }


    public static void logToFile(File logFile, String log){
        logToFile(logFile, log, true);
    }

}
