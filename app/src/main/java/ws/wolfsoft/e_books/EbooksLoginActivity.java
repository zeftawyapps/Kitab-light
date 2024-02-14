package ws.wolfsoft.e_books;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Adapter.LoginPagerAdapter;
import me.relex.circleindicator.CircleIndicator;

public class EbooksLoginActivity extends AppCompatActivity {

    private LoginPagerAdapter loginPagerAdapter;

    private ViewPager viewPager;
    private CircleIndicator indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks_login);


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.orange)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.white)); //status bar or the time bar at the top
        }



//        circleindicator and viewpager used


        viewPager = (ViewPager) findViewById(R.id.viewpager);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);

        loginPagerAdapter = new LoginPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(loginPagerAdapter);

        indicator.setViewPager(viewPager);

        loginPagerAdapter.registerDataSetObserver(indicator.getDataSetObserver());

    }
}
