// Program thread untuk menampilkan pesan secara paralel

class TaskThread extends Thread {
    private String taskName;

    public TaskThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Task " + taskName + " started.");
            Thread.sleep(2000); // Simulasi delay 2 detik
            System.out.println("Task " + taskName + " completed.");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TaskThread task1 = new TaskThread("1");
        TaskThread task2 = new TaskThread("2");
        TaskThread task3 = new TaskThread("3");

        task1.start(); // Memulai thread untuk Task 1
        task2.start(); // Memulai thread untuk Task 2
        task3.start(); // Memulai thread untuk Task 3

        try {
            task1.join(); // Menunggu task1 selesai
            task2.join(); // Menunggu task2 selesai
            task3.join(); // Menunggu task3 selesai
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("All tasks are completed.");
    }
}
