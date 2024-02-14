package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ModelClass.EbooksListModelClass;

import ws.wolfsoft.e_books.AudioBookActivity;
import ws.wolfsoft.e_books.BookDetailActivity;
import ws.wolfsoft.e_books.BookListActivity;
import ws.wolfsoft.e_books.BookReadingActivity;
import ws.wolfsoft.e_books.EbooksCategoryActivity;
import ws.wolfsoft.e_books.EbooksCategorySelectActivity;
import ws.wolfsoft.e_books.EbooksFilterActivity;
import ws.wolfsoft.e_books.EbooksLoginActivity;
import ws.wolfsoft.e_books.EbooksSettingActivity;
import ws.wolfsoft.e_books.HomePageActivity;
import ws.wolfsoft.e_books.MyLibraryActivity;
import ws.wolfsoft.e_books.R;


public class EbooksListRecycleAdapter extends RecyclerView.Adapter<EbooksListRecycleAdapter.MyViewHolder>{

    Context context;


    private List<EbooksListModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView title;


        public MyViewHolder(View view) {
            super(view);

            title=(TextView)view.findViewById(R.id.title);




        }

    }


    public EbooksListRecycleAdapter(Context context, List<EbooksListModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public EbooksListRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ebooks_list, parent, false);


        return new EbooksListRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final  int position) {
        EbooksListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (position == 0) {
                    Intent i = new Intent(context, EbooksLoginActivity.class);
                    context.startActivity(i);
                }else if (position == 1) {
                    Intent i = new Intent(context, EbooksFilterActivity.class);
                    context.startActivity(i);
                }else if (position == 2) {
                    Intent i = new Intent(context, EbooksCategorySelectActivity.class);
                    context.startActivity(i);
                }else if (position == 3) {
                    Intent i = new Intent(context, HomePageActivity.class);
                    context.startActivity(i);
                }else if (position == 4) {
                    Intent i = new Intent(context, BookListActivity.class);
                    context.startActivity(i);
                }else if (position == 5) {
                    Intent i = new Intent(context, BookDetailActivity.class);
                    context.startActivity(i);
                }else if (position == 6) {
                    Intent i = new Intent(context, MyLibraryActivity.class);
                    context.startActivity(i);
                }else if (position == 7) {
                    Intent i = new Intent(context, BookReadingActivity.class);
                    context.startActivity(i);
                }else if (position == 8) {
                    Intent i = new Intent(context, AudioBookActivity.class);
                    context.startActivity(i);
                }else if (position == 9) {
                    Intent i = new Intent(context, EbooksSettingActivity.class);
                    context.startActivity(i);
                }else if (position == 10) {
                    Intent i = new Intent(context, EbooksCategoryActivity.class);
                    context.startActivity(i);
                }
            }

        });



    }



    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


