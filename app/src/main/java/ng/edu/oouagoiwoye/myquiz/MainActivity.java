package ng.edu.oouagoiwoye.myquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText uname;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname = (EditText) findViewById(R.id.uname);
    }


    public void logIn(View view)
    {
        name =  uname.getText().toString();
        if(name.isEmpty() )
        {
            CharSequence text = "You are required to provide a name to start the quiz";
            toastMaker(text);
        } else {
            CharSequence text = "Welcome "+name+" to Quiz 1.0";
            //toastMaker(text);
            Intent quiz = new Intent(this, QuizActivity.class);
            quiz.putExtra("uname", name);
            startActivity(quiz);
        }


    }


    public void toastMaker(CharSequence text)
    {
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}
