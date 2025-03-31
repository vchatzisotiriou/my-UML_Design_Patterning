package app;

import conf.SettingsManager;
import task.TaskList;

public class TaskApp {
	
	
	public static void main(String[] args) {
		SettingsManager sm = SettingsManager.getInstance();
		TaskUI taskui = new TaskUI(sm);
		TaskList tlist = new TaskList();
		
		TaskController tctl = new TaskController(TaskList, TaskUI);
		
		Task task1 = new TaskBuilder()
                .setId(1)
                .setTitle("Update Website Content")
                .setDescription("Review and update website content")
                .setPriority(1)
                .setCreationDate(LocalDateTime.now())
                .build();

        System.out.println(task1);

        tctl.createTask("Update Website Content", "Review and update website content", 1);
        tctl.completeTask(0);
        tctl.deleteTask(taskList.getTasks().get(0));

	}
}
