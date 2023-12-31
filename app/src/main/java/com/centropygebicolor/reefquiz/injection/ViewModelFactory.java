package com.centropygebicolor.reefquiz.injection;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.centropygebicolor.reefquiz.data.QuestionBank;
import com.centropygebicolor.reefquiz.data.QuestionRepository;
import com.centropygebicolor.reefquiz.ui.quiz.QuizViewModel;

import org.jetbrains.annotations.NotNull;

public class ViewModelFactory implements ViewModelProvider.Factory {
    private final QuestionRepository questionRepository;
    private static ViewModelFactory factory;

    public static ViewModelFactory getInstance() {
        if (factory == null) {
            synchronized (ViewModelFactory.class) {
                if (factory == null) {
                    factory = new ViewModelFactory();
                }
            }
        }
        return factory;
    }

    private ViewModelFactory() {
        QuestionBank questionBank = QuestionBank.getInstance();
        this.questionRepository = new QuestionRepository(questionBank);
    }

    @Override
    @NotNull
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(QuizViewModel.class)) {
            return (T) new QuizViewModel(questionRepository);
        } throw new IllegalArgumentException("Unknown ViewModel class");
    }

}
