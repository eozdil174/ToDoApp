import com.sun.xml.internal.bind.v2.TODO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import javax.swing.*;
import javax.swing.border.Border;

public class Gui extends ToDo{
    public static JFrame frame = new JFrame("ToDoApp");
    public static JTextArea todoOutput = new JTextArea();

    public static void main(String[] args) {
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        JPanel listPanel = new JPanel();
        listPanel.setBounds(0, 0, 400, 600);
        listPanel.setBackground(new Color(25, 95, 133));

        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(new Color(39, 70, 89));
        controlPanel.setBounds(400, 0, 400, 600);

        JComboBox



        /* ListPanel components */

        JLabel todoLabel = new JLabel(" ToDo Tasks");
        todoLabel.setFont(new Font("Roboto", Font.BOLD,15));
        todoLabel.setForeground(Color.white);
        todoLabel.setBackground(new Color(25, 95, 133));
        todoLabel.setOpaque(true);
        todoLabel.setBounds(150,8,100,25);
        listPanel.add(todoLabel);

        JSeparator todoSeparator = new JSeparator();
        todoSeparator.setForeground(Color.white);
        todoSeparator.setBounds(0,20,400,25);
        listPanel.add(todoSeparator);

        todoOutput.setBackground(new Color(25, 95, 133));
        todoOutput.setBounds(5, 30, 395, 575);
        todoOutput.setFont(new Font("Roboto", Font.PLAIN, 16));
        todoOutput.setLineWrap(true);
        todoOutput.setWrapStyleWord(true);
        todoOutput.setForeground(Color.white);
        todoOutput.setEditable(false);
        listPanel.add(todoOutput);
        showList();

        /* Control panel components */

        JLabel todoInpLabel = new JLabel("New Task");
        todoInpLabel.setFont(new Font("Roboto", Font.PLAIN,13));
        todoInpLabel.setForeground(Color.white);
        todoInpLabel.setBounds(50,15,100,20);
        controlPanel.add(todoInpLabel);

        JTextField newTaskInput = new JTextField(30);
        newTaskInput.setBounds(50,40,300,25);
        newTaskInput.setBackground(new Color(39, 70, 89));
        newTaskInput.setForeground(Color.white);
        newTaskInput.setFont(new Font("Roboto",Font.PLAIN,16));
        newTaskInput.setBorder(null);
        controlPanel.add(newTaskInput);

        JSeparator taskInpSeparator = new JSeparator();
        taskInpSeparator.setForeground(Color.white);
        taskInpSeparator.setBounds(50,65,300,15);
        controlPanel.add(taskInpSeparator);

        JButton addNewTaskButton = new JButton("Add New Task");
        addNewTaskButton.setForeground(Color.white);
        addNewTaskButton.setBackground(new Color(51, 109, 163));
        addNewTaskButton.setBorder(null);
        addNewTaskButton.setBounds(200,85,150,25);
        addNewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todo = newTaskInput.getText();
                addTask();
                newTaskInput.setText(null);
                todoList.clear();
                todoOutput.setText(null);
                showList();
            }
        });
        controlPanel.add(addNewTaskButton);

        listPanel.setLayout(null);
        frame.add(listPanel);
        controlPanel.setLayout(null);
        frame.add(controlPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void showList() {
        getList();
        for (int i = 0;i <todoList.size();i++)
        {
            todoOutput.append((i+1) + "- " + todoList.get(i) + "\n");
        }
    }
}