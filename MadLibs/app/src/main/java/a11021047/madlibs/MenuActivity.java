package a11021047.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class MenuActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, ReadActivity.class);
        InputStream instream = this.getResources().openRawResource(R.raw.madlib0_simple);
        if (v == findViewById(R.id.button_simple)) {
            try {
                instream = this.getResources().openRawResource(R.raw.madlib0_simple);
            }
            catch (Exception e) {
                findViewById(R.id.button_simple).setVisibility(View.GONE);
                TextView textView = findViewById(R.id.error);
                textView.setText(e.toString());
            }
        }
        if (v == findViewById(R.id.button_tarzan)) {
            try {
                instream = this.getResources().openRawResource(R.raw.madlib1_tarzan);
            }
            catch (Exception e) {
                findViewById(R.id.button_tarzan).setVisibility(View.GONE);
                TextView textView = findViewById(R.id.error);
                textView.setText(e.toString());
            }
        }
        if (v == findViewById(R.id.button_uni)) {
            try {
                instream = this.getResources().openRawResource(R.raw.madlib2_university);
            }
            catch (Exception e) {
                findViewById(R.id.button_uni).setVisibility(View.GONE);
                TextView textView = findViewById(R.id.error);
                textView.setText(e.toString());
            }
        }
        if (v == findViewById(R.id.button_clothes)) {
            try {
                instream = this.getResources().openRawResource(R.raw.madlib3_clothes);
            }
            catch (Exception e) {
                findViewById(R.id.button_clothes).setVisibility(View.GONE);
                TextView textView = findViewById(R.id.error);
                textView.setText(e.toString());
            }
        }
        if (v == findViewById(R.id.button_dance)) {
            try {
                instream = this.getResources().openRawResource(R.raw.madlib4_dance);
            }
            catch (Exception e) {
                findViewById(R.id.button_dance).setVisibility(View.GONE);
                TextView textView = findViewById(R.id.error);
                textView.setText(e.toString());
            }
        }
        if (v == findViewById(R.id.button_random)) {
//            int randomNum = ThreadLocalRandom.current().nextInt(0, 5);
//            Random rand = new Random();
//            int randomNum = rand.nextInt(5);
            int randomNum = (int) (Math.random() * (4));
            System.out.println(randomNum);
            try {
                switch (randomNum) {
                    case 0:
                        instream = this.getResources().openRawResource(R.raw.madlib0_simple);
                        break;
                    case 1:
                        instream = this.getResources().openRawResource(R.raw.madlib1_tarzan);
                        break;
                    case 2:
                        instream = this.getResources().openRawResource(R.raw.madlib2_university);
                        break;
                    case 3:
                        instream = this.getResources().openRawResource(R.raw.madlib3_clothes);
                        break;
                    case 4:
                        instream = this.getResources().openRawResource(R.raw.madlib4_dance);
                        break;
                }
//                instream = this.getResources().openRawResource(R.raw.madlib0_simple);
            }
            catch (Exception e) {
                findViewById(R.id.button_random).setVisibility(View.GONE);
                TextView textView = findViewById(R.id.error);
                textView.setText(e.toString());
            }
        }
        if (instream != null) {
            story = new Story(instream);
            intent.putExtra("story", story);
            startActivity(intent);
//            finish();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);

        outstate.putSerializable("story", story);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        story = (Story) savedInstanceState.getSerializable("story");
    }
}
