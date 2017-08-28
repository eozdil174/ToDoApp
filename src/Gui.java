import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends ToDo{

    public static void main(String [] args) {
        JFrame frame = new JFrame("ToDoApp");
        frame.setSize(300, 500);
        frame.setBackground(Color.gray);
       // frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(10, 430, 100, 25);
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        JTextArea textArea = new JTextArea();
        textArea.setBounds(10,20,100,100);
        for(int i = 0; i < todoList.size(); i++)
        {
            textArea.insert(todoList.get(i), i);
        }

        frame.add(textArea);
        //frame.add(quitButton);

    }
}
