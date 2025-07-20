package QuizApp;

public class Admin extends User {
	 public Admin(int userId, String name, String email) {
	 super(userId, name, email);
	 }
	 public Quiz createQuiz(String title) {
	 return new Quiz(title);
	 }
	 public void addQuestion(Quiz quiz, Question question) {
	 quiz.addQuestion(question);
	 }
	}
