package ws.wolfsoft.e_books;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EbooksFilterActivity extends AppCompatActivity implements View.OnClickListener{


    Spinner spinner;


    TextView one,two,three,four,five;

    ImageView star1,star2,star3,star4,star5;

    LinearLayout linear1, linear2, linear3, linear4,linear5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebooks_filter);

        spinner = (Spinner) findViewById(R.id.sp_car_name);


        List<String> list = new ArrayList<String>();
        list.add("Popular first");
        list.add("Popular first");
        list.add("Popular first");
        list.add("Popular first");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(EbooksFilterActivity.this, R.layout.spinner_item, R.id.spinner_text, list);
        spinner.setAdapter(dataAdapter);


        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);
        linear3 = (LinearLayout) findViewById(R.id.linear3);
        linear4 = (LinearLayout) findViewById(R.id.linear4);
        linear5 = (LinearLayout) findViewById(R.id.linear5);

        one = (TextView) findViewById(R.id.one);
        two = (TextView) findViewById(R.id.two);
        three = (TextView) findViewById(R.id.three);
        four = (TextView) findViewById(R.id.four);
        five = (TextView) findViewById(R.id.five);

        star1 = (ImageView) findViewById(R.id.star1);
        star2 = (ImageView) findViewById(R.id.star2);
        star3 = (ImageView) findViewById(R.id.star3);
        star4 = (ImageView) findViewById(R.id.star4);
        star5 = (ImageView) findViewById(R.id.star5);


        linear1.setOnClickListener(this);
        linear2.setOnClickListener(this);
        linear3.setOnClickListener(this);
        linear4.setOnClickListener(this);
        linear5.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.linear1:

                linear1.setBackgroundResource(R.drawable.orange_rect);
                linear2.setBackgroundResource(R.drawable.spinner_rect);
                linear3.setBackgroundResource(R.drawable.spinner_rect);
                linear4.setBackgroundResource(R.drawable.spinner_rect);
                linear5.setBackgroundResource(R.drawable.spinner_rect);

                star1.setImageResource(R.drawable.ic_star_white);
                star2.setImageResource(R.drawable.ic_star_gray);
                star3.setImageResource(R.drawable.ic_star_gray);
                star4.setImageResource(R.drawable.ic_star_gray);
                star5.setImageResource(R.drawable.ic_star_gray);


                one.setTextColor(Color.parseColor("#ffffff"));
                two.setTextColor(Color.parseColor("#828282"));
                three.setTextColor(Color.parseColor("#828282"));
                four.setTextColor(Color.parseColor("#828282"));
                five.setTextColor(Color.parseColor("#828282"));


                break;

            case R.id.linear2:

                linear1.setBackgroundResource(R.drawable.spinner_rect);
                linear2.setBackgroundResource(R.drawable.orange_rect);
                linear3.setBackgroundResource(R.drawable.spinner_rect);
                linear4.setBackgroundResource(R.drawable.spinner_rect);
                linear5.setBackgroundResource(R.drawable.spinner_rect);

                star1.setImageResource(R.drawable.ic_star_gray);
                star2.setImageResource(R.drawable.ic_star_white);
                star3.setImageResource(R.drawable.ic_star_gray);
                star4.setImageResource(R.drawable.ic_star_gray);
                star5.setImageResource(R.drawable.ic_star_gray);


                one.setTextColor(Color.parseColor("#828282"));
                two.setTextColor(Color.parseColor("#ffffff"));
                three.setTextColor(Color.parseColor("#828282"));
                four.setTextColor(Color.parseColor("#828282"));
                five.setTextColor(Color.parseColor("#828282"));

                break;

            case R.id.linear3:

                linear1.setBackgroundResource(R.drawable.spinner_rect);
                linear2.setBackgroundResource(R.drawable.spinner_rect);
                linear3.setBackgroundResource(R.drawable.orange_rect);
                linear4.setBackgroundResource(R.drawable.spinner_rect);
                linear5.setBackgroundResource(R.drawable.spinner_rect);

                star1.setImageResource(R.drawable.ic_star_gray);
                star2.setImageResource(R.drawable.ic_star_gray);
                star3.setImageResource(R.drawable.ic_star_white);
                star4.setImageResource(R.drawable.ic_star_gray);
                star5.setImageResource(R.drawable.ic_star_gray);


                one.setTextColor(Color.parseColor("#828282"));
                two.setTextColor(Color.parseColor("#828282"));
                three.setTextColor(Color.parseColor("#ffffff"));
                four.setTextColor(Color.parseColor("#828282"));
                five.setTextColor(Color.parseColor("#828282"));


                break;


            case R.id.linear4:


                linear1.setBackgroundResource(R.drawable.spinner_rect);
                linear2.setBackgroundResource(R.drawable.spinner_rect);
                linear3.setBackgroundResource(R.drawable.spinner_rect);
                linear4.setBackgroundResource(R.drawable.orange_rect);
                linear5.setBackgroundResource(R.drawable.spinner_rect);

                star1.setImageResource(R.drawable.ic_star_gray);
                star2.setImageResource(R.drawable.ic_star_gray);
                star3.setImageResource(R.drawable.ic_star_gray);
                star4.setImageResource(R.drawable.ic_star_white);
                star5.setImageResource(R.drawable.ic_star_gray);


                one.setTextColor(Color.parseColor("#828282"));
                two.setTextColor(Color.parseColor("#828282"));
                three.setTextColor(Color.parseColor("#828282"));
                four.setTextColor(Color.parseColor("#ffffff"));
                five.setTextColor(Color.parseColor("#828282"));

                break;


            case R.id.linear5:


                linear1.setBackgroundResource(R.drawable.spinner_rect);
                linear2.setBackgroundResource(R.drawable.spinner_rect);
                linear3.setBackgroundResource(R.drawable.spinner_rect);
                linear4.setBackgroundResource(R.drawable.spinner_rect);
                linear5.setBackgroundResource(R.drawable.orange_rect);

                star1.setImageResource(R.drawable.ic_star_gray);
                star2.setImageResource(R.drawable.ic_star_gray);
                star3.setImageResource(R.drawable.ic_star_gray);
                star4.setImageResource(R.drawable.ic_star_gray);
                star5.setImageResource(R.drawable.ic_star_white);


                one.setTextColor(Color.parseColor("#828282"));
                two.setTextColor(Color.parseColor("#828282"));
                three.setTextColor(Color.parseColor("#828282"));
                four.setTextColor(Color.parseColor("#828282"));
                five.setTextColor(Color.parseColor("#ffffff"));

                break;


        }

    }
}
