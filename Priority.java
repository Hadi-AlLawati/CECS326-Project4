import java.util.*;

/**
 * The Priority class is an implementation of the non-preemptive priority scheduling algorithm.
 * It schedules a list of tasks based on their priority, with higher-priority tasks scheduled first.
 */
public class Priority implements Algorithm {
    // The list of tasks to be scheduled
    private List<Task> taskQueue;

    /**
     * Constructs a new Priority object with the given list of tasks.
     * The list is sorted based on task priority using the Comparator.comparing() method.
     *
     * @param tasks The list of tasks to be scheduled.
     */
    public Priority(List<Task> tasks) {
        // Create a new ArrayList to avoid modifying the input list
        taskQueue = new ArrayList<>(tasks);
        // Sort the task list based on priority
        taskQueue.sort(Comparator.comparing(Task::getPriority));
    }

    /**
     * Schedules the tasks in the task queue using the priority scheduling algorithm.
     * For each task in the queue, the CPU.run() method is called to run the task,
     * and a message is printed indicating that the task has finished.
     */
    public void schedule() {
        System.out.println("Priority Scheduling\n");

        // Process each task in the task queue
        for (Task task : taskQueue) {
            CPU.run(task, task.getBurst());
            System.out.println("Task " + task.getName() + " finished.\n");
        }
    }

    /**
     * Removes and returns the next task to be scheduled from the task queue.
     *
     * @return The next task to be scheduled.
     */
    public Task pickNextTask() {
        // Remove and return the first task in the queue
        return taskQueue.remove(0);
    }
}
