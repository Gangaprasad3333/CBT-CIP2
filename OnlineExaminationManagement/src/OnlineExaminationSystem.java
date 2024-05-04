import java.util.*;

public class OnlineExaminationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Dummy users
        User[] users = {
            new User("user1", "password1"),
            new User("user2", "password2")
        };

        // Sample questions
       
        MultipleChoiceQuestion[] questions = {
            new MultipleChoiceQuestion("Who Invented Java Programming?", new String[]{"Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"}, 2),
            new MultipleChoiceQuestion("What is the extension of compiled java classes?", new String[]{".txt", ".js", ".class", ".java"}, 3),
            new MultipleChoiceQuestion("Which of these keywords is used to define interfaces in Java?", new String[]{"intf", "Intf", "interface", "Interface"}, 3),
            new MultipleChoiceQuestion("Which of the following is a superclass of every class in Java?", new String[]{"ArrayList", "Abstract class", "Object class", "String"}, 3),
            new MultipleChoiceQuestion("Which one of the following is not an access modifier?", new String[]{"Protected", "Void", "Public", "Private"}, 2)
        };

        // Login
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User currentUser = null;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                break;
            }
        }
        if (currentUser == null) {
            System.out.println("Invalid username or password.");
            return;
        }

        // Menu
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("Menu:");
            System.out.println("1. Update Profile");
            System.out.println("2. Update Password");
            System.out.println("3. Take Exam");
            System.out.println("4. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    currentUser.updateProfile(newUsername);
                    System.out.println("Profile updated successfully!");
                    break;
                case 2:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    currentUser.updatePassword(newPassword);
                    System.out.println("Password updated successfully!");
                    break;
                case 3:
                   
                    takeExam(questions, scanner);
                    break;
                case 4:
                    loggedIn = false;
                    System.out.println("Logout successful.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

  
    private static void takeExam(MultipleChoiceQuestion[] questions, Scanner scanner) {
        for (int i = 0; i < questions.length; i++) {
        	MultipleChoiceQuestion question = questions[i];
            System.out.println("Question " + (i + 1) + ":");
            question.displayQuestion();

            // Timer for each question (30 seconds)
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    timer.cancel(); // Stop the timer
                }
            };
            timer.schedule(task, 30000);

            // Taking answer
            System.out.print("Enter your answer: ");
            int selectedOption = scanner.nextInt();
            timer.cancel(); // Cancel the timer as soon as the answer is provided

            if (question.checkAnswer(selectedOption)) {
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }

            // Pause for readability
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
