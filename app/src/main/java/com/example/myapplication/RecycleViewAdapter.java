package com.example.myapplication;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    List<Item> items = new ArrayList<>();
    Context mContext;
    boolean shim = true;
    int count = 5;

    public RecycleViewAdapter(Context mContext, List<Item> items) {
        this.items = items;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.slider,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        if (shim) {
            viewHolder.shimmerFrameLayout.startShimmer();
        } else {
            viewHolder.shimmerFrameLayout.stopShimmer();
            viewHolder.shimmerFrameLayout.setShimmer(null);
            viewHolder.title.setBackgroundColor(Color.TRANSPARENT);
            viewHolder.image.setBackgroundColor(Color.TRANSPARENT);
            viewHolder.price.setBackgroundColor(Color.TRANSPARENT);
            viewHolder.mins.setBackgroundColor(Color.TRANSPARENT);
            viewHolder.mins.setTextColor(Color.parseColor("#4CAF50"));
            viewHolder.menuItem.setBackgroundResource(R.drawable.menu_item);
            viewHolder.title.setText(items.get(i).getTitle());
            viewHolder.price.setText(items.get(i).getPrice());
            viewHolder.mins.setText(items.get(i).getMins());
            viewHolder.image.setImageResource(items.get(i).getImage());
//            if (i % 2 == 0)
//                viewHolder.menuItem.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.my_animation));
//            else
                viewHolder.menuItem.setAnimation(AnimationUtils.loadAnimation(mContext,R.anim.my_animationm));
        }
    }

    @Override
    public int getItemCount() {
        return shim?5:items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, price, mins;
        ImageView image;
        ShimmerFrameLayout shimmerFrameLayout;
        CardView menuItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.menu_item_title);
            price = itemView.findViewById(R.id.menu_item_price);
            image = (ImageView) itemView.findViewById(R.id.menu_item_image);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmer);
            menuItem = itemView.findViewById(R.id.menu_item);
            mins = itemView.findViewById(R.id.menu_item_mins);
        }
    }
}
