package a11021047.madlibs;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class ReadActivity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Intent intent = getIntent();
        //Story story = intent.getParcelableExtra("story");

        story = (Story) intent.getSerializableExtra("story");
        EditText editText = findViewById(R.id.read);
//        String text = story.toString();
        String text = story.getNextPlaceholder();
        editText.setHint(text);

    }

    public void processText(View v) {
        EditText editText = findViewById(R.id.read);
        String text = editText.getText().toString();
        story.fillInPlaceholder(text);
        Intent intent;
        System.out.println(story.getPlaceholderRemainingCount());
        if (story.getPlaceholderRemainingCount() != 0) {
            intent = new Intent(this, ReadActivity.class);
            intent.putExtra("story", story);
        }
        else {
            intent = new Intent(this, ShowStoryActivity.class);
            intent.putExtra("story", story);
        }
        startActivity(intent);
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outstate) {
        super.onSaveInstanceState(outstate);

        outstate.putSerializable("story", story);
//        EditText editText = findViewById(R.id.read);
//        String text = editText.getText().toString();
//        outstate.putString("text", text);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        story = (Story) savedInstanceState.getSerializable("story");
//        String text = savedInstanceState.getString("text");
//        EditText editText = findViewById(R.id.read);
//        editText.setText(text);
    }

}
