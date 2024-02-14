package ws.wolfsoft.e_books;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import Adapter.EbooksListRecycleAdapter;
import ModelClass.EbooksListModelClass;

public class EbooksListActivity extends AppCompatActivity {

    private ArrayList<EbooksListModelClass> ebooksListModelClasses;
    private RecyclerView recyclerView;
    private EbooksListRecycleAdapter bAdapter;



    String txt[]=  {"1.LoginActivity","2.FilterActivity","3.SelectCategoryActivity","4.HomePageActivity","5.BookListActivity",
    "6.BookDetailActivity","7.MyLibraryActivity","8.BookReadingActivity","9.AudioBookActivity","10.EbooksSettingActivity",
    "11.EbookCategoryActivity"};


    TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks_list);



        textView = (TextView)findViewById(R.id.number);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+917490844738"));
                startActivity(intent);

            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(EbooksListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ebooksListModelClasses = new ArrayList<>();

        for (int i = 0; i < txt.length; i++) {
            EbooksListModelClass beanClassForRecyclerView_contacts = new EbooksListModelClass(txt[i]);
            ebooksListModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new EbooksListRecycleAdapter(EbooksListActivity.this,ebooksListModelClasses);
        recyclerView.setAdapter(bAdapter);
    }
}
