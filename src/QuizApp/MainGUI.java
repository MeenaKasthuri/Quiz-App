package QuizApp;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainGUI {
    private JFrame frame;
    private JPanel panel;
    private ButtonGroup optionsGroup;
    private JRadioButton[] optionButtons;
    private JButton nextButton;

    private String userName = "Diego Jota";
    private String selectedCategory;
    private int currentQuestionIndex = 0;
    private int score = 0;

    private List<Question> questions;

    
    private final Color backgroundColor = new Color(30, 30, 47);           
    private final Color titleColor = new Color(255, 111, 97);              
    private final Color questionTextColor = new Color(242, 242, 242);      
    private final Color optionTextColor = new Color(197, 198, 199);        
    private final Color buttonBgColor = new Color(11, 206, 175);           
    private final Color buttonFgColor = new Color(30, 30, 47);            

    public MainGUI() {
        frame = new JFrame("Quiz Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);

        frame.getContentPane().setBackground(backgroundColor);

        showCategorySelection();
        frame.setVisible(true);
    }

    private void showCategorySelection() {
        panel = new JPanel();
        panel.setBackground(backgroundColor);
        panel.setLayout(new GridLayout(5, 1));

        JLabel label = new JLabel("Select a quiz category:", SwingConstants.CENTER);
        label.setFont(new Font("Courier New", Font.BOLD, 22));
        label.setForeground(titleColor);
        panel.add(label);

        String[] categories = {"Java Basics", "Technology Awareness", "Software Engineering Basics"};
        for (String category : categories) {
            JButton btn = new JButton(category);
            btn.setFont(new Font("Verdana", Font.BOLD, 18));
            btn.setBackground(buttonBgColor);
            btn.setForeground(buttonFgColor);
            btn.setFocusPainted(false);

            btn.addActionListener(e -> {
                selectedCategory = category;
                currentQuestionIndex = 0;
                score = 0;
                switch (category) {
                    case "Java Basics":
                        questions = QuizData.getJavaQuestions();
                        break;
                    case "Technology Awareness":
                        questions = QuizData.getTechQuestions();
                        break;
                    case "Software Engineering Basics":
                        questions = QuizData.getSEQuestions();
                        break;
                }
                showQuestionScreen();
            });

            panel.add(btn);
        }

        frame.setContentPane(panel);
        frame.revalidate();
    }

    private void showQuestionScreen() {
        if (currentQuestionIndex >= questions.size()) {
            showResult();
            return;
        }

        Question q = questions.get(currentQuestionIndex);

        panel = new JPanel(new BorderLayout());
        panel.setBackground(backgroundColor);

        JLabel title = new JLabel("Quiz: " + selectedCategory, SwingConstants.CENTER);
        title.setFont(new Font("Courier New", Font.BOLD, 20));
        title.setForeground(titleColor);
        panel.add(title, BorderLayout.NORTH);

        JPanel qPanel = new JPanel(new GridLayout(q.getOptions().size() + 1, 1));
        qPanel.setBackground(backgroundColor);

        JLabel qLabel = new JLabel("Q" + (currentQuestionIndex + 1) + ": " + q.getText());
        qLabel.setFont(new Font("Monospaced", Font.PLAIN, 18));
        qLabel.setForeground(questionTextColor);
        qPanel.add(qLabel);

        optionsGroup = new ButtonGroup();
        optionButtons = new JRadioButton[q.getOptions().size()];
        for (int i = 0; i < q.getOptions().size(); i++) {
            optionButtons[i] = new JRadioButton(q.getOptions().get(i));
            optionButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 16));
            optionButtons[i].setForeground(optionTextColor);
            optionButtons[i].setBackground(backgroundColor);
            optionsGroup.add(optionButtons[i]);
            qPanel.add(optionButtons[i]);
        }

        panel.add(qPanel, BorderLayout.CENTER);

        nextButton = new JButton("Next");
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        nextButton.setBackground(buttonBgColor);
        nextButton.setForeground(buttonFgColor);
        nextButton.setFocusPainted(false);
        nextButton.addActionListener(e -> handleNext(q));
        panel.add(nextButton, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.revalidate();
    }

    private void handleNext(Question question) {
        int selected = -1;
        for (int i = 0; i < optionButtons.length; i++) {
            if (optionButtons[i].isSelected()) {
                selected = i;
                break;
            }
        }

        if (selected == -1) {
            JOptionPane.showMessageDialog(frame, "Please select an answer.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (question.checkAnswer(selected)) {
            score++;
        }

        currentQuestionIndex++;
        showQuestionScreen();
    }

    private void showResult() {
        panel = new JPanel(new BorderLayout());
        panel.setBackground(backgroundColor);

        JLabel result = new JLabel("<html><center>Thank you, " + userName +
                "!<br>You scored " + score + " out of " + questions.size() + ".</center></html>", SwingConstants.CENTER);
        result.setFont(new Font("Arial", Font.BOLD, 22));
        result.setForeground(buttonBgColor);

        panel.add(result, BorderLayout.CENTER);

        JButton exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        exit.setBackground(buttonBgColor);
        exit.setForeground(buttonFgColor);
        exit.setFocusPainted(false);
        exit.addActionListener(e -> System.exit(0));
        panel.add(exit, BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.revalidate();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainGUI::new);
    }
}
