import java.util.*;

/**
 * This class is a special way of organizing things to be done in order. It's called "First-Come-First-Served (FCFS)" scheduling.
 * It means that tasks are done in the order they were given, like people standing in line at a store.
 */
public class FCFS implements Algorithm {

    // The tasks that need to be done
    private List<Task> taskQueue;

    /**
     * Creates a new organizer that uses the FCFS scheduling method.
     *
     * @param taskQueue A list of tasks to be done.
     */
    public FCFS(List<Task> taskQueue) {
        this.taskQueue = taskQueue;
    }

    /**
     * Runs the organizer and does each task in order, one at a time. Prints a message when each task is done.
     */
    public void schedule() {
        System.out.println("First-Come-First-Served (FCFS) Scheduling\n");

        int queueSize = taskQueue.size();

        Task currentTask;

        for(int i = 0; i < queueSize; i++){
            // Get the next task in line
            currentTask = this.pickNextTask();

            // Do the task for the amount of time it needs
            CPU.run(currentTask, currentTask.getBurst());

            // Tell everyone that the task is done
            System.out.println("Task " + currentTask.getName() + " finished.\n");
        }
    }

    /**
     * Takes the first task in line and gives it to the organizer to do.
     *
     * @return The first task in line.
     */
    public Task pickNextTask() {
        return taskQueue.remove(0);
    }
}
