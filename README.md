# Quiz Application
A Java-based quiz application with both console and GUI interfaces, designed for creating and taking quizzes on various technical topics.

## Features

Multiple-choice questions in the console

Checks your answers instantly

Shows feedback after each question

Displays your final score at the end

## Classes Overview

User.java: Base class for all users

Admin.java: Can create quizzes and add questions

Participant.java: Can take quizzes and view results

Question.java: Represents quiz questions with options

Quiz.java: Manages a collection of questions

Result.java: Stores and displays quiz results

QuizData.java: Contains predefined quiz questions

Main.java: Console interface entry point

MainGUI.java: Graphical interface entry point

## How to Run

Console Version: 

javac QuizApp/*.java

java QuizApp.Main

GUI Version

javac QuizApp/*.java

java QuizApp.MainGUI

## How It Works
The app shows a question with options

You type your answer

It checks if you are correct

After all questions, it shows your total score

java QuizApp.MainGUI

