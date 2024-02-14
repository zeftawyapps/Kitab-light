package ws.wolfsoft.e_books;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.TextView;

import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;

import Adapter.CategoryBooksRecycleAdapter;
import Adapter.CategorySelectRecycleAdapter;
import ModelClass.CategorySelectModelClass;

public class EbooksCategoryActivity extends AppCompatActivity {


    private ArrayList<CategorySelectModelClass> categorySelectModelClasses;
    private RecyclerView recyclerView;
    private CategoryBooksRecycleAdapter bAdapter;

    String txt[]=  {"Romance","Science Fiction","Young Adult","Adult Fiction","Mystery","Fantasy","Short Stories",
            "Biography","Educations","Comics","Historical","Horror"};
    String sub_title[] = {"500+ Books","200+ Books","300+ Books","250+ Books","700+ Books","100+ Books",
            "300+ Books","350+ Books","100+ Books","250+ Books","800+ Books","450+ Books",};

    TextView title;

    BottomBar bottomBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks_category);



        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.orange)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.orange)); //status bar or the time bar at the top
        }



        bottomBar = findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++)
        { bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL); }



        title = findViewById(R.id.title);
        title.setText("Category");

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(ContextCompat.getColor(this, R.color.orange)); // Navigation bar the soft bottom of some phones like nexus and some Samsung note series
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.orange)); //status bar or the time bar at the top
        }




        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(EbooksCategoryActivity.this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        categorySelectModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            CategorySelectModelClass beanClassForRecyclerView_contacts = new CategorySelectModelClass(txt[i],sub_title[i]);
            categorySelectModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new CategoryBooksRecycleAdapter(EbooksCategoryActivity.this,categorySelectModelClasses);
        recyclerView.setAdapter(bAdapter);

    }
}
