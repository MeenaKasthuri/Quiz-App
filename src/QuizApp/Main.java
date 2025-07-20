package QuizApp;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Admin admin = new Admin(1, "Alice Admin", "alice@quiz.com");

        // Java Quiz
        Quiz javaQuiz = admin.createQuiz("Java Basics");
        admin.addQuestion(javaQuiz, new Question( "What is the size of int in Java?",Arrays.asList("16 bits", "32 bits", "64 bits", "Depends on OS"),1));
        admin.addQuestion(javaQuiz, new Question("Which keyword is used to create a subclass?",Arrays.asList("this", "import", "extends", "instanceof"),2));
        admin.addQuestion(javaQuiz, new Question("Which of the following is not a primitive data type in Java?", Arrays.asList("int", "float", "String", "boolean"), 2));
        admin.addQuestion(javaQuiz, new Question("What is the default value of a boolean variable in Java?", Arrays.asList("true", "false", "0", "null"), 1));
        admin.addQuestion(javaQuiz, new Question("Which operator is used for comparing two values?", Arrays.asList("=", "==", "!=", "equals"), 1));
        admin.addQuestion(javaQuiz, new Question("Which loop is guaranteed to execute at least once?", Arrays.asList("for", "while", "do-while", "None of the above"), 2));
        admin.addQuestion(javaQuiz, new Question("What does the 'static' keyword mean in Java?", Arrays.asList("Method is abstract", "Method belongs to the class", "Variable is final", "Method is synchronized"), 1));


        // New Category: Software Engineering Basics
        Quiz seQuiz = admin.createQuiz("Software Engineering Basics");
        admin.addQuestion(seQuiz, new Question("SDLC stands for?",Arrays.asList("System Data Life Cycle", "Software Development Life Cycle", "Software Design Logic Code", "System Debug Level Code"),1));
        admin.addQuestion(seQuiz, new Question("Main focus of Agile?",Arrays.asList("Strict planning", "Customer collaboration", "Lengthy docs", "Testing only"),1));
        admin.addQuestion(seQuiz, new Question("Tool for version control?",Arrays.asList("Git", "Jira", "Docker", "Postman"),0));
        admin.addQuestion(seQuiz, new Question("Use Case Diagram shows?",Arrays.asList("UI layout", "Code flow", "Actor interactions", "Database schema"),2));
        admin.addQuestion(seQuiz, new Question("First SDLC phase?",Arrays.asList("Testing", "Design", "Analysis", "Requirement gathering"),3));
        admin.addQuestion(seQuiz, new Question("V-model focuses on?",Arrays.asList("Verification and Validation", "User Interface", "Agile Tasks", "Code Security"),0));
        admin.addQuestion(seQuiz, new Question("SCRUM is a type of?",Arrays.asList("Database", "Programming Language", "Agile framework", "Testing tool"),2));


        // Participant
        Participant participant = new Participant(2, "Bob Learner", "bob@learn.com");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a quiz: 1. Java Basics  2. Software Engineering Basics");
        int quizChoice = scanner.nextInt();

        Quiz selectedQuiz = (quizChoice == 2) ? seQuiz : javaQuiz;

        System.out.println("Welcome " + participant.name + " to the quiz: " + selectedQuiz.getTitle());

        int[] answers = new int[selectedQuiz.getQuestions().size()];
        for (int i = 0; i < selectedQuiz.getQuestions().size(); i++) {
            Question q = selectedQuiz.getQuestions().get(i);
            System.out.println("\nQ" + (i + 1) + ": " + q.getText());
            for (int j = 0; j < q.getOptions().size(); j++) {
                System.out.println((j + 1) + ". " + q.getOptions().get(j));
            }
            System.out.print("Your answer (1-" + q.getOptions().size() + "): ");
            answers[i] = scanner.nextInt() - 1;
        }

        Result result = participant.takeQuiz(selectedQuiz, answers);
        participant.viewResult(result);
        scanner.close();
    }
}
