package com.example.andriod.snookercounter;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scorePlayer1;
    int scorePlayer2;
    int breakScore;
    String lastPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        }
        decorView.setSystemUiVisibility(uiOptions);
        // hide Cursor in both EditText-Views
        hideCursor();
        // set button background if Androidversion newer than KITKAT
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            String[] buttonIds = {"redButton", "yellowButton", "greenButton", "brownButton", "blueButton", "pinkButton", "blackButton"};
            int[] drawableFile = {R.drawable.redbutton, R.drawable.yellowbutton, R.drawable.greenbutton, R.drawable.brownbutton, R.drawable.bluebutton, R.drawable.pinkbutton, R.drawable.blackbutton};
            for (int playerNum = 1; playerNum <= 2; playerNum++) {
                for (int i = 0; i < buttonIds.length; i++) {
                    int id = getResources().getIdentifier(buttonIds[i] + playerNum, "id", getPackageName());
                    Button button = (Button) findViewById(id);
                    Drawable drawableId = getResources().getDrawable(drawableFile[i]);
                    button.setBackground(drawableId);
                }
            }
        }
        /* load saved variable after config changes */
        if (savedInstanceState != null) {
            scorePlayer1 = savedInstanceState.getInt("scorePlayer1");
            scorePlayer2 = savedInstanceState.getInt("scorePlayer2");
            breakScore = savedInstanceState.getInt("breakScore");
            lastPlayer = savedInstanceState.getString("lastPlayer");
            displayScore("scoreView1", scorePlayer1);
            displayScore("scoreView2", scorePlayer2);
            displayScore("scoreBreak1", 0);
            displayScore("scoreBreak2", 0);
            displayScore(lastPlayer, breakScore);
        } else {
        /* Set all Scores to zero and display reseted scores if app is started */
            lastPlayer = "scoreBreak1";
            scorePlayer2 = 0;
            scorePlayer1 = 0;
            breakScore = 0;
            displayScore("scoreView1", scorePlayer1);
            displayScore("scoreView2", scorePlayer2);
            displayScore("scoreBreak1", breakScore);
            displayScore("scoreBreak2", breakScore);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("scorePlayer1", scorePlayer1);
        outState.putInt("scorePlayer2", scorePlayer2);
        outState.putInt("breakScore", breakScore);
        outState.putString("lastPlayer", lastPlayer);
    }

    /* Remove Cursor */
    public void hideCursor() {
        String[] editTextIds = {"namePlayer1", "namePlayer2"};
        for (String selectedId : editTextIds) {
            int idEditText = getResources().getIdentifier(selectedId, "id", getPackageName());
            EditText editTextObject = (EditText) findViewById(idEditText);
            editTextObject.setCursorVisible(false);
        }
    }

    /* Set Points for Player 2 */
    public void scoreRed2(View view) {
        int points = 1;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    public void scoreYellow2(View view) {
        int points = 2;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    public void scoreGreen2(View view) {
        int points = 3;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    public void scoreBrown2(View view) {
        int points = 4;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    public void scoreBlue2(View view) {
        int points = 5;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    public void scorePink2(View view) {
        int points = 6;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    public void scoreBlack2(View view) {
        int points = 7;
        scorePlayer2 += points;
        scoreBreak("scoreBreak2", points);
        displayScore("scoreView2", scorePlayer2);
    }

    /* Set Points for Player 1 */
    public void scoreRed1(View view) {
        int points = 1;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    public void scoreYellow1(View view) {
        int points = 2;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    public void scoreGreen1(View view) {
        int points = 3;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    public void scoreBrown1(View view) {
        int points = 4;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    public void scoreBlue1(View view) {
        int points = 5;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    public void scorePink1(View view) {
        int points = 6;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    public void scoreBlack1(View view) {
        int points = 7;
        scorePlayer1 += points;
        scoreBreak("scoreBreak1", points);
        displayScore("scoreView1", scorePlayer1);
    }

    /* calculate scoreBreak */
    public void scoreBreak(String currentPlayer, int points) {
        if (currentPlayer == lastPlayer) {
            breakScore += points;
        } else {
            /* Reset scoreBreak if player changed */
            if (lastPlayer != null) {
                displayScore(lastPlayer, 0);
                lastPlayer = currentPlayer;
                breakScore = points;
            }
        }
        displayScore(lastPlayer, breakScore);
    }

    /*Reset Scores */
    public void resetScores(View view) {
        scorePlayer1 = 0;
        scorePlayer2 = 0;
        breakScore = 0;
        displayScore("scoreView1", scorePlayer1);
        displayScore("scoreView2", scorePlayer2);
        displayScore("scoreBreak1", breakScore);
        displayScore("scoreBreak2", breakScore);
    }

    /* Display updated Scores */
    public void displayScore(String player, int score) {
        int id = getResources().getIdentifier(player, "id", getPackageName());
        TextView scoreView = (TextView) findViewById(id);
        scoreView.setText(String.valueOf(score));
    }
}
