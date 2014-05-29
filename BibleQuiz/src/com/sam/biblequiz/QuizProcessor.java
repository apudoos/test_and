package com.sam.biblequiz;

public class QuizProcessor {
	
	private int mQuestion;
	private int mAnswer;
	
	public QuizProcessor (int question, int answer) {
		setmQuestion(question);
		setmAnswer(answer);
	}

	public int getmAnswer() {
		return mAnswer;
	}

	public void setmAnswer(int mAnswer) {
		this.mAnswer = mAnswer;
	}

	public int getmQuestion() {
		return mQuestion;
	}

	public void setmQuestion(int mQuestion) {
		this.mQuestion = mQuestion;
	}
	
	
	

}
