package QuizApp;

public class Result {
	 private Participant participant;
	 private Quiz quiz;
	 private int score;
	 public Result(Participant participant, Quiz quiz, int score) {
	 this.participant = participant;
	 this.quiz = quiz;
	 this.score = score;
	 }
	 public void display() {
	 System.out.println("Participant: " + participant.name);
	 System.out.println("Quiz: " + quiz.getTitle());
	 System.out.println("Score: " + score + "/" + quiz.getQuestions().size());
	 }
	}

