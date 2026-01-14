package com.example.github2;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final int DAILY_GOAL = 10;
    TextView goal, progress, status;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        setTitle("Добавление Коммитов");
        goal = findViewById(R.id.text_view_daily_goal);
        progress = findViewById(R.id.text_view_progress);
        status = findViewById(R.id.text_view_status);
        seekBar = findViewById(R.id.seek_bar);

        updateStatus(progress, status, 0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int value, boolean user) {
                updateStatus(progress, status, value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


    }
    private void updateStatus(TextView progressText, TextView statusText, int value) {
        progressText.setText(String.valueOf(value));
        if (value == 0)
        {
            statusText.setText("Еще не начал");
        }
        else if (value >= 1 && value <= 3)
        {
            statusText.setText("Начало");
        }
        else if (value >= 4 && value <= 7)
        {
            statusText.setText("Хороший прогресс");
        }
        else if (value >= 8 && value <= 9)
        {
            statusText.setText("Почти достиг");
        }
        else if (value >= DAILY_GOAL)
        {
            statusText.setText("Цель выполнена");
        }
        else
        {
            statusText.setText("Ошибка");
        }
    }
}