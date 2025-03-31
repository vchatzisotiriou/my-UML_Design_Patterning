package task;

import java.util.ArrayList;
import java.util.List;

import dao.DAOFactory;

public class TaskList{
	private int taskCount=0;
    private List<Task> tasks;

    private List<TaskListObserver>  observers;

    public TaskList() {
        this.tasks = new ArrayList<>();
        this.observers = new ArrayList<>();
		retrieveTasks();
    }

    public void addObserver(TaskListObserver observer){
        observers.add(observer);
    }

    public void removeObserver(TaskListObserver observer){
        observers.remove(observer);
    }

    private void notifyObservers(){
        for(TaskListObserver observer : observers){
            observer.update(tasks);
        }
    }


    private void retrieveTasks() {
    	tasks = DAOFactory.getTaskDAO().getAllTasks();
    }
    
    public List<Task> getTasks() {
        return tasks;
    }
    
    
    public int getNextTaskNumber() {
        return ++taskCount;
    }

    synchronized public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }
    
    
    public void setTaskCompleted(int index) {
    	tasks.get(index).setCompleted();
    }
 
}
