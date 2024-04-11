import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password; 
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class OnlineExamination{
    private static User currentUser;
    private static Timer timer;
    private static int timeRemaining = 60; // 1 minute (in seconds)

  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOnline Examination System:");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Start Exam");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    updateProfileAndPassword(scanner);
                    break;
                case 3:
                    if (currentUser == null) {
                        System.out.println("Please login first.");
                    } else {
                        startExam(scanner);
                    }
                    break;
                case 4:
                    logout();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
//Login
    private static void login(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // You can replace this with actual user authentication logic...
        if ("abc".equals(username) && "abc@123".equals(password)) {
            currentUser = new User("abc", "abc@123");
            System.out.println("Login successful.");
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }
        
    private static void updateProfileAndPassword(Scanner scanner) {
        if (currentUser == null) {
            System.out.println("Please Login First.");
        } else {
            System.out.println("Profile and Password update functionality.");
        }
    }

    private static void startExam(Scanner scanner) {
        System.out.println("Starting the exam....");

        // Start a timer for the exam
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Exam auto-submitted.");
                timer.cancel();
            }
        }, timeRemaining * 1000);

        // Implement MCQs and answer selection logic here
        // For simplicity, we'll simulate MCQs
        int questions = 3;
        int correctAnswers = 0;

        for (int i = 1; i <= questions; i++) {
			System.out.println("\nQuestion " + i + ":");
			if (i == 1){
            System.out.println("What is 4 + 5?");
            System.out.print("a) 9 b) 8 c) 5  d) 6\nYour answer: ");
			}else if (i ==2){
		    System.out.println("What is 5 * 3?");
            System.out.print("a) 3  b) 9 c) 5  d) 15\nYour answer: ");
			}else if (i ==3){
		    System.out.println("What is 3 / 6?");
            System.out.print("a) 3  b) 9 c) 2 d) 6\nYour answer: ");
			}
            String answer = scanner.nextLine().trim();
			if (i == 1 &&"a".equalsIgnoreCase(answer)) {
                correctAnswers++;
            } else if (i == 2 &&"d".equalsIgnoreCase(answer)) {
                correctAnswers++;
			}else if(i == 3 &&"c".equalsIgnoreCase(answer)) {
                correctAnswers++;
	   }
	}
        System.out.println("\nExam completed.");
        System.out.println("Correct answers: " + correctAnswers + " out of " + questions);

        // End the exam session
        closeSession();
    }

    private static void closeSession() {
        if (timer != null) {
            timer.cancel();
        }
        currentUser = null;
        System.out.println("\nSession closed.");
    }

    private static void logout() {
        closeSession();
        System.out.println("Logout successful.");
    }
}
