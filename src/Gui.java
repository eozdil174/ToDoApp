import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends addTaskTab{
    public static JFrame frame = new JFrame("ToDoApp");

    public static void main(String [] args) {
        frame.setSize(800 ,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel listPanel = new JPanel();
        listPanel.setBounds(0, 0,400,600);
        listPanel.setBackground(new Color(25,95,133));

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(39,70,89));
        controlPanel.setBounds(400,0,400,600);

        JTextArea todoOutput = new JTextArea();                 //Write new showlist function
        todoOutput.setBackground(new Color(25,95,133));
        todoOutput.setBounds(0,0,400,600);
        todoOutput.setFont(new Font("Arial",Font.PLAIN, 16));
        todoOutput.setLineWrap(true);
        todoOutput.setWrapStyleWord(true);
        todoOutput.setText();
        listPanel.add(todoOutput);

        frame.add(listPanel);
        frame.add(controlPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void showList(){
        getList();

        for(int i = 0; i < todoList.size();i++)
        {


        }


    }



}