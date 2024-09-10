package solvd.laba.serviceclasses;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

import static java.lang.String.format;


public class StringEvalService {


    /**
     *
     * @return  A String built from the file.
     */
    public static String constructStringFromFile() {

        String ret = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert the name for the file (In the resources folder) to parse.");
        String fileName = format("./src/main/resources/%s", scan.nextLine());

        File file = new File(fileName);
        try {
            ret = ret.concat(FileUtils.readFileToString(file, StandardCharsets.UTF_8));
        }
        catch(IOException e){
            System.out.println("The file was not found, string initialized empty. Retry.");
        }
        return ret;
    }


    public static int countUniqueWords(String text) {
        int ret = 0;
        if (!StringUtils.isBlank(text)) {
            // StringUtils.split does not correctly handle the newline character nor the tab.
            // I'll do a fix by replacing those characters with spaces,
            // then splitting the resulting string.

            System.out.println(text);

            String processedText = text.toLowerCase().replaceAll("\n\t\r", ",");

            System.out.println(processedText);

            String[] words = StringUtils.split(processedText, " ,.!?;:");
            HashSet<String> uniqueWords = new HashSet<>(Arrays.asList(words));
            for (String s:uniqueWords){
                System.out.println(s);
            }
            ret = uniqueWords.size();
        }
        return ret;
    }


    public static int countLetters(String text) {
        int ret = 0;
        if (!StringUtils.isBlank(text)) {
            // Note: replaceAll deprecated, functionality moved to 'RegexUtils'.
            // I'll limit myself to StringUtils this time.
            String lettersOnly = StringUtils.replaceAll(text, "[^a-zA-Z\n]", "");
            ret = lettersOnly.length();
        }
        return ret;
    }


    /**
     *
     * @param text  , the text on which to look for the word.
     * @param word  , the word to search in the text
     * @return      An int that counts how many times the word was in the text.
     * @throws IllegalArgumentException when the searchable word has length <=1
     */
    public static int countWordMatches(String text, String word) {
        int ret = 0;
        if (StringUtils.isBlank(word) || word.length() <= 1) {
            throw new IllegalArgumentException("The searchable word should have more than one letter.");
        }
        if (!StringUtils.isBlank(text)) {
            String searchWord = word.toLowerCase();
            ret = StringUtils.countMatches(text.toLowerCase(), searchWord);
        }
        return ret;
    }



}
