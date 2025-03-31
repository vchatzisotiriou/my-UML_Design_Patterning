package task;

import java.util.List;

public interface TaskListObserver{
	void update(List<Task> tasks);
}