package QuizApp;

import java.util.List;
public class Question {
 private static int idCounter = 1;
 private int questionId;
 private String text;
 private List<String> options;
 private int correctAnswer; // index (0-based)
 public Question(String text, List<String> options, int correctAnswer) {
 this.questionId = idCounter++;
 this.text = text;
 this.options = options;
 this.correctAnswer = correctAnswer;
 }
 public boolean checkAnswer(int answerIndex) {
 return answerIndex == correctAnswer;
 }
 public String getText() {
 return text;
 }
 public List<String> getOptions() {
 return options;
 }
}
