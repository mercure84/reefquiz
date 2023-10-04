package com.centropygebicolor.reefquiz.ui.quiz;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.centropygebicolor.reefquiz.R;
import com.centropygebicolor.reefquiz.data.Question;
import com.centropygebicolor.reefquiz.databinding.FragmentQuizBinding;
import com.centropygebicolor.reefquiz.injection.ViewModelFactory;
import com.centropygebicolor.reefquiz.ui.welcome.WelcomeFragment;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuizFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuizFragment extends Fragment {

    public static QuizFragment newInstance() {
        QuizFragment fragment = new QuizFragment();
        return fragment;
    }

    private FragmentQuizBinding binding;
    private QuizViewModel viewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this, ViewModelFactory.getInstance()).get(QuizViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentQuizBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.startQuiz();
        viewModel.currentQuestion.observe(getViewLifecycleOwner(), new Observer<Question>() {
            @Override
            public void onChanged(Question question) {
                updateQuestion(question);
            }
        });

        binding.answer0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(binding.answer0, 0);
            }
        });
        binding.answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(binding.answer1, 1);
            }
        });
        binding.answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(binding.answer2, 2);
            }
        });
        binding.answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAnswer(binding.answer3, 3);
            }
        });

        viewModel.isLastQuestion.observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLastQuestion) {
                if (isLastQuestion) {
                    binding.next.setText("Terminer");
                } else {
                    binding.next.setText("Suivant");
                }

            }
        });

        binding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isLastQuestion = (Boolean) viewModel.isLastQuestion.getValue();
                if (isLastQuestion) {
                    displayResultDialog();
                } else {
                    viewModel.nextQuestion();
                    resetQuestion();
                }
            }
        });
    }

    private void resetQuestion() {
        List<Button> allAnswers = Arrays.asList(binding.answer0, binding.answer1, binding.answer2, binding.answer3);
        allAnswers.forEach(answer -> {
            answer.setBackgroundColor(Color.parseColor("#6200EE"));
        });
        binding.validityText.setVisibility(View.INVISIBLE);
        enableAllAnswers(true);
    }

    private void displayResultDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Quizz Terminé !");
        Integer score = viewModel.score.getValue();
        builder.setMessage("Votre score final est de " + score);
        builder.setPositiveButton("Quitter", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                goToWelcomeFragment();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    private void goToWelcomeFragment() {
        WelcomeFragment welcomeFragment = WelcomeFragment.newInstance();
        FragmentManager fragmentmanager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentmanager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container_view, welcomeFragment).commit();
    }


    private void updateQuestion(Question question) {
        binding.question.setText(question.getQuestion());
        binding.answer0.setText(question.getChoiceList().get(0));
        binding.answer1.setText(question.getChoiceList().get(1));
        binding.answer2.setText(question.getChoiceList().get(2));
        binding.answer3.setText(question.getChoiceList().get(3));
    }

    private void updateAnswer(Button button, Integer index) {
        showAnswerValidity(button, index);
        enableAllAnswers(false);
        binding.next.setVisibility(View.VISIBLE);
    }

    private void showAnswerValidity(Button button, Integer index) {
        Boolean isValid = viewModel.isAnswerValid(index);
        if (isValid) {
            button.setBackgroundColor((Color.parseColor("#388e3c")));
            binding.validityText.setText("Bonne réponse !");
            button.announceForAccessibility("Bonne réponse !");
        } else {
            button.setBackgroundColor(Color.RED);
            binding.validityText.setText("Mauvaise réponse !");
            button.announceForAccessibility("Mauvaise réponse !");
        }
        binding.validityText.setVisibility(View.VISIBLE);
    }

    private void enableAllAnswers(Boolean enable) {
        List<Button> allAnswers = Arrays.asList(binding.answer0, binding.answer1, binding.answer2, binding.answer3);
        allAnswers.forEach(answer -> {
            answer.setEnabled(enable);
        });
    }


}