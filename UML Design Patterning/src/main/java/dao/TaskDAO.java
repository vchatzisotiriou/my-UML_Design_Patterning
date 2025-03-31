package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import task.Task;

/**
 * 
 */
public class TaskDAO {
    private String tasks_directory;
    
    public TaskDAO(String taskdir) {
		tasks_directory = taskdir;
	}

	public void saveTask(Task task) {
        File directory = new File(tasks_directory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = tasks_directory + task.getId() + ".txt";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(task);
            System.out.println("Task saved: " + task);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = new ArrayList<>();
        File directory = new File(tasks_directory);
        if (directory.exists()) {
            File[] files = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (files != null) {
                for (File file : files) {
                    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
                        Task task = (Task) inputStream.readObject();
                        tasks.add(task);
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return tasks;
    }
    
    public void deleteTask(Task task) {
        File fileToDelete = new File(tasks_directory + task.getId() + ".txt");
        if (fileToDelete.exists()) {
            if (fileToDelete.delete()) {
                System.out.println("Task deleted: " + task);
            } else {
                System.out.println("Failed to delete task: " + task);
            }
        } else {
            System.out.println("Task file not found: " + task);
        }
    }

}
