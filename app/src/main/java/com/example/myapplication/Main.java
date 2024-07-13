package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main extends AppCompatActivity {
    private boolean xTurn = true;
    private Queue<Button> xButtons = new ArrayDeque<>();
    private Queue<Button> oButtons = new ArrayDeque<>();
    private Button[][] buttons = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button(this);
                button.setLayoutParams(new GridLayout.LayoutParams());
                button.setTextSize(40);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((Button) v).getText().equals("")) {
                            if (xTurn) {
                                button.setText("X");
                                xButtons.add(button);
                                if (xButtons.size() > 3) {
                                    Button oldestX = xButtons.poll();
                                    oldestX.setText("");
                                }
                            } else {
                                button.setText("O");
                                oButtons.add(button);
                                if (oButtons.size() > 3) {
                                    Button oldestO = oButtons.poll();
                                    oldestO.setText("");
                                }
                            }
                            xTurn = !xTurn;
                            checkWinner();
                        }
                    }
                });
                buttons[i][j] = button;
                gridLayout.addView(button, new GridLayout.LayoutParams());
            }
        }
    }

    private void checkWinner() {
        for (int i = 0; i < 3; i++) {
            // Check rows and columns
            if (checkLine(buttons[i][0], buttons[i][1], buttons[i][2]) ||
                    checkLine(buttons[0][i], buttons[1][i], buttons[2][i])) {
                return;
            }
        }
        if (checkLine(buttons[0][0], buttons[1][1], buttons[2][2]) ||
                checkLine(buttons[0][2], buttons[1][1], buttons[2][0])) {
            return;
        }
    }

    private boolean checkLine(Button b1, Button b2, Button b3) {
        if (!b1.getText().equals("") && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
            showWinnerDialog(b1.getText().toString());
            return true;
        }
        return false;
    }

    private void showWinnerDialog(String winner) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        builder.setMessage("Winner is " + winner + ". Do you want to quit or start a new game?");

        builder.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                resetGame();
            }
        });

        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void resetGame() {
        xTurn = true;
        xButtons.clear();
        oButtons.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    // Method to handle the close button click
    public void closeApp(View view) {
        finish(); // Closes the activity
    }
}
