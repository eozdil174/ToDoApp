import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Gui extends ToDo {
    public static JFrame frame = new JFrame("ToDoApp");
    public static JTextArea todoOutput = new JTextArea();
    public static JComboBox removeComboBox = new JComboBox();
    public static  JComboBox editTaskComboBox = new JComboBox();
    public static JCheckBox notifCheckbox = new JCheckBox("Notification");
    public static JSpinner notifSpinner = new JSpinner();

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
        newTaskInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todo = newTaskInput.getText();
                if(notifCheckbox.isSelected())setNotif();
                addTask();
                newTaskInput.setText(null);
                todoList.clear();
                todoOutput.setText(null);
                showList();
            }
        });
        controlPanel.add(newTaskInput);

        JSeparator taskInpSeparator = new JSeparator();
        taskInpSeparator.setForeground(Color.white);
        taskInpSeparator.setBounds(50,65,300,15);
        controlPanel.add(taskInpSeparator);

        SpinnerModel model1 = new SpinnerDateModel();
        notifSpinner.setModel(model1);
        notifSpinner.setBounds(220,120,130,25);
        controlPanel.add(notifSpinner);

        JButton addNewTaskButton = new JButton("Add New Task");
        addNewTaskButton.setForeground(Color.white);
        addNewTaskButton.setBackground(new Color(51, 109, 163));
        addNewTaskButton.setFont(new Font("Roboto", Font.PLAIN, 15));
        addNewTaskButton.setBorder(null);
        addNewTaskButton.setBounds(200,85,150,25);
        addNewTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                todo = newTaskInput.getText();
                if(notifCheckbox.isSelected())setNotif();
                addTask();
                newTaskInput.setText(null);
                todoList.clear();
                todoOutput.setText(null);
                showList();
            }
        });
        controlPanel.add(addNewTaskButton);

        notifCheckbox.setFont(new Font("Roboto", Font.PLAIN,13));
        notifCheckbox.setBackground(new Color(39, 70, 89));
        notifCheckbox.setForeground(Color.white);
        notifCheckbox.setBounds(50,90,100,15);
        controlPanel.add(notifCheckbox);

        JLabel notifLabel = new JLabel("Select a time for notification");
        notifLabel.setFont(new Font("Roboto", Font.PLAIN,13));
        notifLabel.setForeground(Color.white);
        notifLabel.setBounds(50,120,200,25);
        controlPanel.add(notifLabel);

        JSeparator removeSeparator = new JSeparator();
        removeSeparator.setForeground(Color.white);
        removeSeparator.setBounds(0,330,400,15);
        controlPanel.add(removeSeparator);

        removeComboBox.setBounds(280,360,70,25);
        removeComboBox.setFont(new Font("Roboto",Font.BOLD,14));
        controlPanel.add(removeComboBox);

        JLabel removeLabel = new JLabel("Select the task number for deleting");
        removeLabel.setForeground(Color.white);
        removeLabel.setFont(new Font("Roboto",Font.PLAIN,14));
        removeLabel.setBounds(50,361,250,25);
        controlPanel.add(removeLabel);

        JButton removeTaskButton = new JButton("Remove Selected Task");
        removeTaskButton.setBackground(new Color(51, 109, 163));
        removeTaskButton.setForeground(Color.white);
        removeTaskButton.setFont(new Font("Roboto",Font.PLAIN,15));
        removeTaskButton.setBorder(null);
        removeTaskButton.setBounds(150,400,200,25);
        removeTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = removeComboBox.getSelectedIndex() + 1;
                removeTask();
                showList();
            }
        });
        controlPanel.add(removeTaskButton);

        /*Bottom Components */

        JLabel editTaskLabel = new JLabel("Edit a Task");
        editTaskLabel.setForeground(Color.white);
        editTaskLabel.setFont(new Font("Roboto",Font.PLAIN,13));
        editTaskLabel.setBounds(50,440,150,25);
        controlPanel.add(editTaskLabel);

        JTextField editTaskTf = new JTextField(30);
        editTaskTf.setFont(new Font("Roboto", Font.PLAIN,16));
        editTaskTf.setForeground(Color.white);
        editTaskTf.setBackground(new Color(39, 70, 89));
        editTaskTf.setBorder(null);
        editTaskTf.setBounds(50,470,300,25);
        editTaskTf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editedTask = editTaskTf.getText();
                editNum = editTaskComboBox.getSelectedIndex() + 1;
                editTask();
                showList();
            }
        });
        controlPanel.add(editTaskTf);

        JSeparator editTaskTfSeparator = new JSeparator();
        editTaskTfSeparator.setForeground(Color.white);
        editTaskTfSeparator.setBounds(50,496,300,15);
        controlPanel.add(editTaskTfSeparator);

        JButton editTaskButton = new JButton("Edit Task");
        editTaskButton.setBackground(new Color(51, 109, 163));
        editTaskButton.setForeground(Color.white);
        editTaskButton.setFont(new Font("Roboto",Font.PLAIN,15));
        editTaskButton.setBorder(null);
        editTaskButton.setBounds(200,516,150,25);
        editTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editedTask = editTaskTf.getText();
                editNum = editTaskComboBox.getSelectedIndex() + 1;
                editTask();
                showList();
            }
        });
        controlPanel.add(editTaskButton);

        editTaskComboBox.setBounds(140,516,50,25);
        editTaskButton.setFont(new Font("Roboto",Font.BOLD,14));
        controlPanel.add(editTaskComboBox);

        JLabel editComboboxLabel = new JLabel("Task Number");
        editComboboxLabel.setForeground(Color.white);
        editComboboxLabel.setFont(new Font("Roboto",Font.PLAIN,13));
        editComboboxLabel.setBounds(50,516,100,25);
        controlPanel.add(editComboboxLabel);

        listPanel.setLayout(null);
        frame.add(listPanel);
        controlPanel.setLayout(null);
        frame.add(controlPanel);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void showList() {
        todoList.clear();
        todoOutput.setText(null);
        removeComboBox.removeAllItems();
        editTaskComboBox.removeAllItems();
        getList();
        for (int i = 0;i <todoList.size();i++)
        {
            todoOutput.append((i+1) + "- " + todoList.get(i) + "\n");
        }

        for(int i = 0;i<todoList.size();i++)
        {
            removeComboBox.addItem(i +1);
            editTaskComboBox.addItem(i +1);
        }

    }

    public static void setNotif(){
     new NotificationBackgroundTask();
    }
}