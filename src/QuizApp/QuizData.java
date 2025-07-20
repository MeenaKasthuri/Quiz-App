package QuizApp;

import java.util.Arrays;
import java.util.List;

public class QuizData {
    public static List<Question> getJavaQuestions() {
        return Arrays.asList(
            new Question("What is the size of int in Java?", Arrays.asList("16 bits", "32 bits", "64 bits", "Depends on OS"), 1),
            new Question("Which keyword is used to create a subclass?", Arrays.asList("this", "import", "extends", "instanceof"), 2),
            new Question("What is JVM?", Arrays.asList("Java Variable Method", "Java Virtual Machine", "Java Verified Mode", "None"), 1),
            new Question("Which method is the entry point of Java?", Arrays.asList("start()", "main()", "run()", "execute()"), 1),
            new Question("Which package contains Scanner class?", Arrays.asList("java.io", "java.util", "java.lang", "java.awt"), 1)
        );
    }

    public static List<Question> getTechQuestions() {
        return Arrays.asList(
            new Question("Which company developed the Android OS?", Arrays.asList("Apple", "Google", "Microsoft", "IBM"), 1),
            new Question("What does IoT stand for?", Arrays.asList("Internet of Things", "Internet of Technology", "Information of Technology", "Input of Tools"), 0),
            new Question("Which device is used to input handwriting?", Arrays.asList("Scanner", "Stylus", "Mouse", "Joystick"), 1)
        );
    }

    public static List<Question> getSEQuestions() {
        return Arrays.asList(
            new Question("SDLC stands for?", Arrays.asList("System Data Life Cycle", "Software Development Life Cycle", "Software Design Logic Code", "System Debug Level Code"), 1),
            new Question("Main focus of Agile?", Arrays.asList("Strict planning", "Customer collaboration", "Lengthy docs", "Testing only"), 1),
            new Question("Tool for version control?", Arrays.asList("Git", "Jira", "Docker", "Postman"), 0),
            new Question("Use Case Diagram shows?", Arrays.asList("UI layout", "Code flow", "Actor interactions", "Database schema"), 2),
            new Question("First SDLC phase?", Arrays.asList("Testing", "Design", "Analysis", "Requirement gathering"), 3),
            new Question("V-model focuses on?", Arrays.asList("Verification and Validation", "User Interface", "Agile Tasks", "Code Security"), 0),
            new Question("SCRUM is a type of?", Arrays.asList("Database", "Programming Language", "Agile framework", "Testing tool"), 2)
        );
    }
}
