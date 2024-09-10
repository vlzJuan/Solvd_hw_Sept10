package solvd.laba.serviceclasses;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static solvd.laba.serviceclasses.LogService.logToFile;
import static solvd.laba.serviceclasses.StringEvalService.*;

public class MenuService {

    public static String textMenu(File logFile){

        Scanner scan = new Scanner(System.in);
        String ret = "";
        int choice;
        boolean prompt = true;
        while(prompt) {
            try {
                System.out.println("1 - Enter text manually");
                System.out.println("2 - Read text from file");

                choice = scan.nextInt();

                if(choice<1 || choice>2){
                    throw new IndexOutOfBoundsException("Incorrect option selected. Try again.");
                }

                switch(choice){
                    case 1:
                        logToFile( logFile, "User selected option: Enter text manually");
                        ret = ret.concat(constructStringFromInput());
                        break;
                    case 2:
                        logToFile(logFile, "User selected option: Read text from file" );
                        ret = ret.concat(constructStringFromFile());
                        break;
                    default:
                        break;
                }
                prompt=false;
            }
            catch(InputMismatchException e){
                scan.nextLine();    // Clean the buffer from stdin.
                System.out.println("Please, input the int corresponding to your selected option.");
            }
            catch(IndexOutOfBoundsException e){
                System.out.println(e);
            }
        }// End of the while

        return ret;
    }



    private static String constructStringFromInput(){

        Scanner scan = new Scanner(System.in);
        StringBuilder ret = new StringBuilder();
        System.out.println("Enter lines to store as text (enter empty line to stop):");
        while(scan.hasNextLine()){
            String aux = scan.nextLine();
            if(!aux.isEmpty()){
                ret.append(aux + "\n");
            }
            else{
                break;
            }
        }
        return ret.toString();
    }



    public static void operateOverText(File logFile, String text){

        Scanner scan = new Scanner(System.in);
        int choice;
        boolean prompt = true;
        while(prompt) {
            try {
                System.out.println("Pick an operation to perform over the text:");
                System.out.println("1 - Calculate the number of words in the text (Case insensitive)");
                System.out.println("2 - Calculate the number of characters in the text (no whitespace)");
                System.out.println("3 - Find occurrences of a word in the text (Case insensitive)");

                choice = scan.nextInt();

                if(choice<1 || choice>3){
                    throw new IndexOutOfBoundsException("Incorrect option selected. Try again.");
                }

                switch(choice){
                    case 1:
                        logToFile( logFile, "User selected option: Calculate number of words in text.");
                        System.out.println("The text has " + countUniqueWords(text)+ " unique words.");
                        break;
                    case 2:
                        logToFile(logFile, "User selected option: Calculate number of characters in text" );
                        System.out.println("The text has " + countLetters(text) + " non-space characters.");
                        break;
                    case 3:
                        logToFile(logFile, "User selected option: Find occurrences of a word in text.");
                        System.out.println("Input a word to search in the text:");
                        scan.nextLine(); // Eats up the \n in the buffer.
                        String searchable = scan.nextLine();

                        // May throw IllegalArgumentException. Will be caught by the main 'try' here.
                        int matches = countWordMatches(text, searchable);
                        System.out.println("The word was in the text " + matches + " times.");

                        break;
                    default:
                        break;
                }
                prompt=false;
            }
            catch(InputMismatchException e){
                scan.nextLine();    //  Clean buffer from mismatched conversion to int.
                System.out.println("Please, input the int corresponding to your selected option.");
            }
            catch(IndexOutOfBoundsException | IllegalArgumentException e){
                System.out.println(e);
            }
        }// End of the while

    }




}
