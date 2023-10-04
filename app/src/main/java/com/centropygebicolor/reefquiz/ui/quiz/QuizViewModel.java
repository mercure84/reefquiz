package com.centropygebicolor.reefquiz.ui.quiz;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.centropygebicolor.reefquiz.data.Question;
import com.centropygebicolor.reefquiz.data.QuestionRepository;

import java.util.List;

public class QuizViewModel extends ViewModel {

    private QuestionRepository questionRepository;
    private List<Question> questions;
    private Integer currentQuestionIndex = 0;

    public QuizViewModel(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
        this.questions = questionRepository.getQuestions();
    }

    MutableLiveData<Question> currentQuestion = new MutableLiveData<Question>();
    MutableLiveData<Integer> score = new MutableLiveData<Integer>(0);
    MutableLiveData isLastQuestion = new MutableLiveData<Boolean>(false);

    public void startQuiz() {
        currentQuestion.postValue(questionRepository.getQuestions().get(0));
    }

    public void nextQuestion() {
        Integer nextIndex = currentQuestionIndex + 1;
        if (nextIndex >= questions.size()) {
            return; // should not happened as the 'Next' button is not  displayed at the last question
        } else if (nextIndex == questions.size() - 1) {
            isLastQuestion.postValue(true);
        }
        currentQuestionIndex = nextIndex;
        currentQuestion.postValue(questions.get(currentQuestionIndex));
    }

    public boolean isAnswerValid(int answerIndex) {
        Question question = currentQuestion.getValue();
        boolean isValid = question != null && question.getAnswerIndex() ==  answerIndex;
        Integer currentScore = score.getValue();
        if (currentScore != null && isValid) {
            score.setValue(currentScore + 1);
        }
        return isValid;
    }

}
