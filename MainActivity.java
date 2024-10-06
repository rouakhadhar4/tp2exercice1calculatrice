package com.example.tp2;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEntier1;
    private EditText editTextEntier2;
    private RadioButton radioButtonAdd;
    private RadioButton radioButtonSubtract;
    private RadioButton radioButtonMultiply;
    private RadioButton radioButtonDivide;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercice1);


        editTextEntier1 = findViewById(R.id.editTextText5);
        editTextEntier2 = findViewById(R.id.editTextText6);
        radioButtonAdd = findViewById(R.id.radioButton9);
        radioButtonSubtract = findViewById(R.id.radioButton7);
        radioButtonMultiply = findViewById(R.id.radioButton8);
        radioButtonDivide = findViewById(R.id.radioButton10);
        Button buttonCalculate = findViewById(R.id.button);
        textViewResult = findViewById(R.id.textView3);


        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Calcul demandé.");
                calculateResult();
            }
        });
    }

    private void calculateResult() {
        String input1 = editTextEntier1.getText().toString().trim();
        String input2 = editTextEntier2.getText().toString().trim();


        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Champs vides", Toast.LENGTH_SHORT).show();
            Log.d("MainActivity", "Champs vides");
            return;
        }

        int entier1;
        int entier2;


        try {
            entier1 = Integer.parseInt(input1);
            entier2 = Integer.parseInt(input2);
        } catch (NumberFormatException e) {
            Toast.makeText(getApplicationContext(), "Entrée invalide. Veuillez entrer des entiers.", Toast.LENGTH_SHORT).show();
            Log.d("MainActivity", "Entrée invalide: " + e.getMessage());
            return;
        }

        int result;


        if (radioButtonAdd.isChecked()) {
            result = entier1 + entier2;
        } else if (radioButtonSubtract.isChecked()) {
            result = entier1 - entier2;
        } else if (radioButtonMultiply.isChecked()) {
            result = entier1 * entier2;
        } else if (radioButtonDivide.isChecked()) {
            if (entier2 != 0) {
                result = entier1 / entier2;
            } else {
                textViewResult.setText("Division par zéro !");
                return;
            }
        } else {
            textViewResult.setText("Veuillez sélectionner une opération.");
            return;
        }


        textViewResult.setText("Résultat: " + result);
    }
}
