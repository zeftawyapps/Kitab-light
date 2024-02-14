package ws.wolfsoft.e_books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import Adapter.BookListRecycleAdapter;
import Adapter.RecommandedRecycleAdapter;
import ModelClass.RecommandedModelClass;

public class BookListActivity extends AppCompatActivity {

    private ArrayList<RecommandedModelClass> recommandedModelClasses;
    private RecyclerView recyclerView;
    private BookListRecycleAdapter bAdapter;

    private Integer image[]= {R.drawable.blink_imges,R.drawable.me_befor_you,R.drawable.how_to_win,R.drawable.blink_imges,R.drawable.me_befor_you,R.drawable.how_to_win};
    private String title[] = {"Blink: The Power of Thinking Without\n" +
            "Thinking","Me Before You","How to Win Friends and Influence\n" +
            "People","Blink: The Power of Thinking Without\n" +
            "Thinking","Me Before You","How to Win Friends and Influence\n" +
            "People"};
    private String rating[] = {"4.5","4.0","3.2","4.5","4.0","3.2"};
    private String author_name[] =  {"Malcolm Gladwell","Jojo Moyes","Dale Carnegie","Malcolm Gladwell","Jojo Moyes","Dale Carnegie"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);


        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(BookListActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recommandedModelClasses = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            RecommandedModelClass beanClassForRecyclerView_contacts = new RecommandedModelClass(image[i],title[i],rating[i],author_name[i]);
            recommandedModelClasses.add(beanClassForRecyclerView_contacts);
        }
        bAdapter = new BookListRecycleAdapter(BookListActivity.this,recommandedModelClasses);
        recyclerView.setAdapter(bAdapter);

    }
}
