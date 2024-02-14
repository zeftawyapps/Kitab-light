package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ModelClass.CategorySelectModelClass;
import ws.wolfsoft.e_books.R;


public class CategoryBooksRecycleAdapter extends RecyclerView.Adapter<CategoryBooksRecycleAdapter.MyViewHolder> {

    Context context;


    private List<CategorySelectModelClass> OfferList;


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView title, sub_title;
        ImageView imageView;
        FrameLayout frameLayout;


        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
            sub_title = (TextView) view.findViewById(R.id.sub_title);
            imageView = (ImageView)view.findViewById(R.id.triangle);
            frameLayout = (FrameLayout) view.findViewById(R.id.frameLayout);



        }

    }


    public CategoryBooksRecycleAdapter(Context context, List<CategorySelectModelClass> offerList) {
        this.OfferList = offerList;
        this.context = context;
    }

    @Override
    public CategoryBooksRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category_select_list, parent, false);


        return new CategoryBooksRecycleAdapter.MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        final CategorySelectModelClass lists = OfferList.get(position);
        holder.title.setText(lists.getTitle());
        holder.sub_title.setText(lists.getSub_title());

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (lists.isSelected() == false){
//                    lists.setSelected(true);
//                    //holder.tick.setImageResource(R.drawable.ic_radio_on_button);
//
//                    holder.frameLayout.setBackgroundResource(R.drawable.orange_light_rect);
//                    holder.imageView.setVisibility(View.VISIBLE);
//
//                }else {
//                    lists.setSelected(false);
//                    holder.frameLayout.setBackgroundResource(R.drawable.gray_light_rect);
//                    holder.imageView.setVisibility(View.GONE);
//                }
//
//
//
//            }
//        });


    }


    @Override
    public int getItemCount() {
        return OfferList.size();

    }

}


