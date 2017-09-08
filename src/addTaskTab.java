import jdk.net.SocketFlow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addTaskTab extends ToDo{

    public static void addTaskTab(){
        JFrame frame = new JFrame("Add New Task");
        frame.setSize(300,150);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JTextField addTaskInp = new JTextField();
        addTaskInp.setBounds(10, 10, 260,30);

        JButton addTaskButton = new JButton("Add New Task");
        addTaskButton.setBounds(10,80,120,25);
        addTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todo = addTaskInp.getText();
                addTask();
                frame.setVisible(false);
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180,80,100,25);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.add(cancelButton);
        frame.add(addTaskInp);
        frame.add(addTaskButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
