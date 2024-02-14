package ws.wolfsoft.e_books;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;
import com.roughike.bottombar.BottomBar;

public class MyLibraryActivity extends AppCompatActivity {

    TextView title;

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_library);


        bottomBar = findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++)
        { bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL); }



        title = findViewById(R.id.title);
        title.setText("My Library");

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.orange)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.orange)); //status bar or the time bar at the top
        }



        CircularProgressBar circularProgressBar = (CircularProgressBar)findViewById(R.id.circle_progress);
        circularProgressBar.setColor(ContextCompat.getColor(this, R.color.green));
        circularProgressBar.setBackgroundColor(ContextCompat.getColor(this, R.color.grey));
        circularProgressBar.setProgressBarWidth(getResources().getDimension(R.dimen.circle_width));
        circularProgressBar.setBackgroundProgressBarWidth(getResources().getDimension(R.dimen.circle_width));
        int animationDuration = 2500; // 2500ms = 2,5s
        circularProgressBar.setProgressWithAnimation(65, animationDuration); // Default duration = 1500ms
    }
}
