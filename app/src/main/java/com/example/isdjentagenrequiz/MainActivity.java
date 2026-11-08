package com.example.isdjentagenrequiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    boolean correctAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnTrue = findViewById(R.id.btnTrue);
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = true;

                boolean isCorrect;
                String explanation = "Djent is not a genre because misha said so";
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("explanationKey", explanation);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("questionNumber", 1);
                startActivity(intent);
            }
        });

        Button btnFalse = findViewById(R.id.btnFalse);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean userAnswer = false;

                boolean isCorrect;
                if (userAnswer == correctAnswer) {
                    isCorrect = true;
                } else {
                    isCorrect = false;
                }

                String explanation = "Djent is not a genre because misha said so";

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("explanationKey", explanation);
                intent.putExtra("isCorrect", isCorrect);
                intent.putExtra("questionNumber", 1);
                startActivity(intent);
            }
        });
    }

}