package QuizApp;

public class Participant extends User {
	 public Participant(int userId, String name, String email) {
	 super(userId, name, email);
	 }
	 public Result takeQuiz(Quiz quiz, int[] answers) {
	 int score = quiz.evaluate(answers);
	 return new Result(this, quiz, score);
	 }
	 public void viewResult(Result result) {
	 result.display();
	 }
	}
