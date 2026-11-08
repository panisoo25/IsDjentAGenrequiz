package com.example.isdjentagenrequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvResult = findViewById(R.id.tvResult);
        TextView tvResult2 = findViewById(R.id.tvResult2);
        View mainLayout = findViewById(R.id.main);
        TextView tvExplanation = findViewById(R.id.tvExplanation);
        String explanationText = getIntent().getStringExtra("explanationKey");

        boolean isCorrect = getIntent().getBooleanExtra("isCorrect", false);
        int questionNumber = getIntent().getIntExtra("questionNumber", 1);

        if (isCorrect) {
            tvResult.setText("You're right!");
            mainLayout.setBackgroundColor(getColor(R.color.result_correct));
        } else {
            tvResult.setText("You're wrong");
            mainLayout.setBackgroundColor(getColor(R.color.result_wrong));
        }

        if (questionNumber == 1) {
            tvResult2.setVisibility(View.VISIBLE);
            if (isCorrect) {
                tvResult2.setText("Djent is indeed not a Genre!");
            } else {
                tvResult2.setText("Djent is not a genre... : (");
            }
        } else {
            tvResult2.setVisibility(View.GONE);
        }

        if (tvExplanation != null) {
            tvExplanation.setText(explanationText);
        }

        Button btnNext = findViewById(R.id.btnNext);

        if (questionNumber == 1) {
            btnNext.setVisibility(View.VISIBLE);
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ResultActivity.this, SecondQuestionActivity.class);
                    startActivity(intent);
                }
            });
        } else {
            btnNext.setVisibility(View.GONE);
        }

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}