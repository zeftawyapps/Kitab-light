package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ModelClass.EbooksListModelClass;
import ws.wolfsoft.e_books.BookDetailActivity;
import ws.wolfsoft.e_books.BookListActivity;
import ws.wolfsoft.e_books.BookReadingActivity;
import ws.wolfsoft.e_books.EbooksCategorySelectActivity;
import ws.wolfsoft.e_books.EbooksFilterActivity;
import ws.wolfsoft.e_books.EbooksLoginActivity;
import ws.wolfsoft.e_books.HomePageActivity;
import ws.wolfsoft.e_books.MyLibraryActivity;
import ws.wolfsoft.e_books.R;


public class BookReadingRecycleAdapter extends RecyclerView.Adapter<BookReadingRecycleAdapter.MyViewHolder>{

    Context context;
    TextView title;
    int textSize = 3;
    int saveProgress;



    private List<EbooksListModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {



        TextView title;
        SeekBar seekBar;
        int progress;





        public MyViewHolder(View view) {
            super(view);

            title=(TextView)view.findViewById(R.id.titleasas);
        }

    }


    public BookReadingRecycleAdapter(Context context, List<EbooksListModelClass> offerList,int saveProgress) {
        this.OfferList = offerList;
        this.context = context;
        this.saveProgress = saveProgress;

    }

    @Override
    public BookReadingRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_bookreading_list, parent, false);


        return new BookReadingRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final  int position) {
        EbooksListModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());



        holder.title.setTextIsSelectable(true);
        saveProgress+=1;


        holder.title.setTextSize(saveProgress);

    }



    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


