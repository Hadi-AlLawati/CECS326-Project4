import java.util.*;

// Define a class called "RR" that implements an interface called "Algorithm"
public class RR implements Algorithm {

    // Create a list of tasks to be executed and an iterator to iterate over them
    private List<Task> taskQueue;
    private ListIterator<Task> queueIterator;

    /**
     * The constructor initializes the list of tasks to the given list and initializes the iterator to the start of the list.
     *
     * @param taskList The list of tasks to be executed
     */
    public RR(List<Task> taskList) {
        taskQueue = new ArrayList<>(taskList);
        queueIterator = taskQueue.listIterator();
    }

    /**
     * The schedule method runs the Round Robin scheduling algorithm.
     * It selects the next task to run, runs it for a fixed time slice, and removes it from the queue if it is finished.
     */
    public void schedule() {
        // Print a message indicating that Round Robin scheduling is being used
        System.out.println("Round Robin Scheduling\n");

        // Keep executing tasks until the queue is empty
        while (!taskQueue.isEmpty()) {
            // Get the next task to execute
            Task currentTask = pickNextTask();

            // Determine how long to run the task for (either 10 units or the remaining burst time)
            int timeToRun = Math.min(currentTask.getBurst(), 10);

            // Run the task for the determined time
            CPU.run(currentTask, timeToRun);

            // Update the task's burst time
            currentTask.setBurst(currentTask.getBurst() - timeToRun);

            // If the task is finished, remove it from the queue and print a message
            if (currentTask.getBurst() <= 0) {
                queueIterator.remove();
                System.out.println("Task " + currentTask.getName() + " finished.");
            }
        }
    }

    /**
     * The pickNextTask method selects the next task to run from the task queue.
     * If there are more tasks in the queue, it returns the next task using the iterator.
     * If there are no more tasks in the queue, it resets the iterator to the start of the queue and returns the first task in the queue.
     *
     * @return The next task to run
     */
    public Task pickNextTask() {
        // If there are more tasks in the queue, return the next one
        if (queueIterator.hasNext()) {
            return queueIterator.next();
        }
        // If there are no more tasks in the queue, reset the iterator to the start and return the first task
        else {
            queueIterator = taskQueue.listIterator();
            return taskQueue.get(0);
        }
    }
}
