package com.centropygebicolor.reefquiz.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class QuestionRepository {
    private final QuestionBank questionBank;

    public QuestionRepository(QuestionBank questionBank) {
        this.questionBank = questionBank;
    }

    public List<Question> getQuestions() {
        List<Question> allQuestions = questionBank.getQuestions();
        List<Question> random10Questions = new ArrayList<>();
        Random random = new Random();

// Utilisez un ensemble pour éviter de sélectionner le même élément deux fois
        Set<Integer> selectedIndices = new HashSet<>();

        while (random10Questions.size() < 10 && selectedIndices.size() < allQuestions.size()) {
            int randomIndex = random.nextInt(allQuestions.size());

            // Vérifiez si cet indice a déjà été sélectionné
            if (!selectedIndices.contains(randomIndex)) {
                random10Questions.add(allQuestions.get(randomIndex));
                selectedIndices.add(randomIndex);
            }
        }
        return random10Questions;
    }
}
