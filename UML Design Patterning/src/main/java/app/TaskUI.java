package app;
import javax.swing.*;

import conf.SettingsManager;
import task.Task;
import task.TaskListObserver;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class TaskUI implements TaskListObserver{


    @Override
    public void update(List<Task> tasks){
        showTasks(tasks);
    }



    private JFrame frame;
    private JList<Task> taskList;
    private JButton addButton,doneButton;
    
    private DefaultListModel<Task> listModel;
    private SettingsManager settingsManager;
    
    public TaskUI(SettingsManager settingsManager) {
        this.settingsManager = settingsManager;

        frame = new JFrame("Task Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
       

        JPanel panel = new JPanel(new BorderLayout());

        listModel = new DefaultListModel<>();
        taskList = new JList<Task>(listModel);
        taskList.setCellRenderer(new TaskCellRenderer()); // Set custom cell renderer
        
        applySettings(); // Apply settings when the UI is initialized
        
        JScrollPane scrollPane = new JScrollPane(taskList);
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        addButton = new JButton("Add Task");

        doneButton = new JButton("Task Done");

        buttonPanel.add(addButton);
        buttonPanel.add(doneButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
    
    // Pop-up a window to enter title
    public String getNewTaskTitle() {
    	return JOptionPane.showInputDialog(frame, "Enter task title:");
    }
    
    // Pop-up a window to enter descritpion
    public String getNewTaskDescription() {
    	return  JOptionPane.showInputDialog(frame, "Enter task description:");
    }

    // Method to apply settings to the UI
    private void applySettings() {
        String theme = settingsManager.getTheme();
        int fontSize = settingsManager.getFontSize();

        // Apply theme and font size to the UI elements
        frame.getContentPane().setBackground(getColorForTheme(theme));
        taskList.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, fontSize));
    }

    // Helper method to get color based on theme
    private Color getColorForTheme(String theme) {
        switch (theme) {
            case "Dark":
                return Color.DARK_GRAY;
            case "Light":
                return Color.WHITE;
            default:
                return Color.WHITE;
        }
    }
    
    
    // Show in JList a list of tasks
    public void showTasks(List<Task> tasks) {
        listModel.clear();
        for (Task task : tasks) {
            listModel.addElement(task);
        }
    }

    // Get the index of selected task
    public int getSelectedTaskIndex() {
        // Return the index of the selected task in the list
        // Example:
        return taskList.getSelectedIndex();
    }
    

    // Custom cell renderer for Task objects
    private class TaskCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Task task = (Task) value;

            // Check completion status to set foreground color
            if (task.isCompleted()) {
                label.setForeground(Color.GRAY); // Set color for completed tasks
            } else {
                label.setForeground(Color.BLACK); // Set default color for incomplete tasks
            }

            // Set text based on the task details
            label.setText(task.toString()); // Adjust as needed for task representation

            return label;
        }
    }
}

