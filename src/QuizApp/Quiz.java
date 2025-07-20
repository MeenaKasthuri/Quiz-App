package QuizApp;

import java.util.ArrayList;
import java.util.List;
public class Quiz {
 private static int idCounter = 1;
 private int quizId;
 private String title;
 private List<Question> questions;
 public Quiz(String title) {
 this.quizId = idCounter++;
 this.title = title;
 this.questions = new ArrayList<>();
 }
 public void addQuestion(Question q) {
 questions.add(q);
 }
 public int evaluate(int[] answers) {
 int score = 0;
 for (int i = 0; i < answers.length && i < questions.size(); i++) {
 if (questions.get(i).checkAnswer(answers[i])) {
 score++;
 }
 }
 return score;
 }
 public List<Question> getQuestions() {
 return questions;
 }
 public String getTitle() {
 return title;
 }
}

