package com.example.gb_homework_1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.gb_homework_1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int passengersCount = 0;
    private static final int MaxPassengersCount = 49;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passengersCount < MaxPassengersCount) {
                    passengersCount++;
                }
                else {
                    passengersCount++;
                }
                updateUI();
            }
        });

        binding.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passengersCount > 0) {
                    passengersCount--;
                }
                updateUI();
            }
        });

        binding.reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passengersCount = 0;
                updateUI();
            }
        });
        updateUI();
    }

    private void updateUI() {
        binding.passengerCount.setText(String.valueOf(passengersCount));

        if (passengersCount == 0) {
            binding.passengerCount.setTextColor(Color.GREEN);
            binding.minusButton.setEnabled(false);
            binding.reset.setVisibility(View.GONE);
        } else if (passengersCount <= MaxPassengersCount && passengersCount > 0) {
            binding.passengerCount.setTextColor(Color.BLUE);
            binding.minusButton.setEnabled(true);
            binding.reset.setVisibility(View.GONE);
        } else {
            binding.passengerCount.setTextColor(Color.RED);
            binding.minusButton.setEnabled(true);
            binding.reset.setVisibility(View.VISIBLE);
        }
    }
}
