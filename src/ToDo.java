import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 *
 * @author eozdil
 */
public class ToDo {

    static Scanner scn = new Scanner(System.in);
    static int lineNum = 0;
    static ArrayList<String> todoList = new ArrayList<String>();

    public static void main(String[] args) {

        File file = new File("todo.txt");       //List location
        String answer = null;

        while (answer != "0") {
            if (file.exists() == true) {
                System.out.println("Todo File Found");
                System.out.println("Active Tasks: \n");
                lineNum = 1;
                try {
                    FileReader reader = new FileReader("todo.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println(lineNum + "- " + line);      //Reading the text line by line and writing to the screen
                        todoList.add(line);
                        lineNum++;
                    }
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("File not found. Creating the file.");
            }

            System.out.println("\nWhat do you want to do?" + "\n 1- Add new task\n 2- Set a task as completed \n 0- Exit");     //Taking input from user
            answer = scn.nextLine();
            switch (answer) {
                case "1":
                    addTask();
                    break;
                case "2":
                    removeTask();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error!");
            }
        }


    }       //Main method for taking input and reading todoList

    static void removeTask() {
        int choice;
        System.out.println("Which item do you want to remove? ");       //Taking input from user
        choice = scn.nextInt();

        ArrayList<String> list = new ArrayList<String>();           //Making an arrayList for keeping the items
        int number = 1;

        try {
            FileReader reader = new FileReader("todo.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if(number != choice)
                {
                    list.add(line);       //Adding items to arrayList
                }
                number++;
            }
            reader.close();

            PrintWriter outFile = new PrintWriter(new FileWriter("todo.txt"));
            for(int i = 0; i < list.size(); i++){
                outFile.println(list.get(i));               //Writing arrayList to main text again
            }
            outFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }    //Removing completed tasks

    static void addTask() {
        System.out.println("Your new task: ");      //Taking input from user
        String todo;
        char choice;
        Scanner scn = new Scanner(System.in);

        todo = scn.nextLine();

        try {
            FileWriter writer = new FileWriter("todo.txt", true);
            BufferedWriter bfWriter = new BufferedWriter(writer);

            bfWriter.write(todo);           //Writing new task to text file
            bfWriter.newLine();
            lineNum++;
            bfWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }       //Adding new task
    }






