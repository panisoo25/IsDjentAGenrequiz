package com.example.isdjentagenrequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondQuestionActivity extends AppCompatActivity {

    boolean correctAnswer = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second_question);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnTrue = findViewById(R.id.btnTrue2);
        Button btnFalse = findViewById(R.id.btnFalse2);

        View.OnClickListener answerClickListener = v -> {
            boolean userAnswer = (v.getId() == R.id.btnTrue2);
            boolean isCorrect = (userAnswer == correctAnswer);

            Intent intent = new Intent(SecondQuestionActivity.this, ResultActivity.class);
            intent.putExtra("isCorrect", isCorrect);
            intent.putExtra("explanationKey", "everything is fine!");

            intent.putExtra("questionNumber", 2);

            startActivity(intent);
        };

        btnTrue.setOnClickListener(answerClickListener);
        btnFalse.setOnClickListener(answerClickListener);
    }
}