package ng.edu.oouagoiwoye.myquiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {
    String uname;
    String report;
    String score;
    RatingBar ratings;
    TextView statusTextView;
    TextView scoreTextView;
    TextView reportTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        uname = getIntent().getStringExtra("uname");
        score = getIntent().getStringExtra("score");
        report = getIntent().getStringExtra("report");
        statusTextView = findViewById(R.id.uname);
        statusTextView.setText("Dear "+uname+" your score is");
        scoreTextView = findViewById(R.id.score);
        scoreTextView.setText(score);
        ratings = findViewById(R.id.ratings);
        ratings.setRating(Integer.parseInt(score));
        reportTextView = findViewById(R.id.report);
        reportTextView.setText(report);



    }

    public void toastMaker(CharSequence text)
    {
        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void emailReport(View view)
    {
        String body = "Dear "+uname+"\n";
        body += "Thank you for partipating in our Quiz.\n Below is the report of your quiz";
        body += "REPORT\n";
        body += report;
        body += "\n Tnak you for participating in our Quiz.\n We hope to see you soon\n\n SIGNED\n MANAGEMENT";
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, "MY QUIZ REPORT");
        intent.putExtra(Intent.EXTRA_TEXT, body);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
