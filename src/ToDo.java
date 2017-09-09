import java.io.*;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;

/**
 *
 * @author eozdil
 */
public class ToDo{

    static int lineNum = 0;
    static ArrayList<String> todoList = new ArrayList<String>();

    static void getList(){File file = new File("todo.txt");       //List location

        if (file.exists()) {

            lineNum = 1;
                try {
                    FileReader reader = new FileReader("todo.txt");
                    BufferedReader bufferedReader = new BufferedReader(reader);

                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
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
    }

    public static void main(String[] args) {
        getList();
    }       //Main method for taking input and reading todoList

    static void removeTask() {
        int choice;
        System.out.println("Which item do you want to remove? ");       //Taking input from user
        choice = 1; //The task number for deleting. Replace with gui button or textBox

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

    static String todo;
    static void addTask() {
              //Taking input from user
        try {
            FileWriter writer = new FileWriter("todo.txt", true);
            BufferedWriter bfWriter = new BufferedWriter(writer);
            bfWriter.newLine();
            bfWriter.write(todo);           //Writing new task to text file
            lineNum++;
            bfWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        }       //Adding new task
    }






