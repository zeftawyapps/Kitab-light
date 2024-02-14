package ws.wolfsoft.e_books;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;

import Adapter.CategorySelectRecycleAdapter;
import Adapter.RecommandedRecycleAdapter;
import ModelClass.CategorySelectModelClass;
import ModelClass.RecommandedModelClass;

public class HomePageActivity extends AppCompatActivity {

    //  recommanded data


    private ArrayList<RecommandedModelClass> recommandedModelClasses;
    private RecyclerView recyclerView;
    private RecommandedRecycleAdapter bAdapter;

    private Integer image[]= {R.drawable.blink_imges,R.drawable.me_befor_you,R.drawable.how_to_win};
    private String title[] = {"Blink: The Power\n" +
            "of Thinking Wi…","Me Before You","How to Win \n" +
            "Friends and Inf…"};
    private String rating[] = {"4.5","4.0","3.2"};
    private String author_name[] =  {"Malcolm Gladwell","Jojo Moyes","Dale Carnegie"};



    //  top_50 data


    private ArrayList<RecommandedModelClass> recommandedModelClasses1;
    private RecyclerView recyclerView1;
    private RecommandedRecycleAdapter bAdapter1;

    private Integer image1[]= {R.drawable.cantbury,R.drawable.the_dreaming,R.drawable.the_beauty_purpose};
    private String title1[] = {"The Canterbury\n" +
            "Tales","The Dreaming\n" +
            "Reality","The Beauty of\n" +
            "Purpose in Life…"};
    private String rating1[] = {"4.0","4.0","4.5"};
    private String author_name1[] =  {"Geoffrey Chaucer","Noor Anand","Sahla Parveen"};



    BottomBar bottomBar;

    ImageView search_img;


    TextView title3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        title3 = findViewById(R.id.title);
        title3.setText("eBooks");

        search_img = findViewById(R.id.search_img);
        search_img.setVisibility(View.VISIBLE);

        bottomBar = findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++)
        { bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL); }


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.orange)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.orange)); //status bar or the time bar at the top
        }


        //        recommanded recyclerview code is here


        recyclerView = findViewById(R.id.recommanded_recyclerview);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(HomePageActivity.this,3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recommandedModelClasses = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            RecommandedModelClass beanClassForRecyclerView_contacts = new RecommandedModelClass(image[i],title[i],rating[i],author_name[i]);
            recommandedModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new RecommandedRecycleAdapter(HomePageActivity.this,recommandedModelClasses);
        recyclerView.setAdapter(bAdapter);




        //        recommanded recyclerview code is here


        recyclerView1 = findViewById(R.id.top50_books_recyclerview);
        RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(HomePageActivity.this,3);
        recyclerView1.setLayoutManager(layoutManager1);
        recyclerView1.setItemAnimator(new DefaultItemAnimator());

        recommandedModelClasses1 = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            RecommandedModelClass beanClassForRecyclerView_contacts = new RecommandedModelClass(image1[i],title1[i],rating1[i],author_name1[i]);
            recommandedModelClasses1.add(beanClassForRecyclerView_contacts);
        }
        bAdapter1 = new RecommandedRecycleAdapter(HomePageActivity.this,recommandedModelClasses1);
        recyclerView1.setAdapter(bAdapter1);
    }
}
