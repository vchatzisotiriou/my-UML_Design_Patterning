package dao;


public class DAOFactory {
	public static String TASKS_DIRECTORY = "tasks/";

    public static TaskDAO getTaskDAO() {
        return new TaskDAO(TASKS_DIRECTORY);
    }

}
