package com.example.newkey;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class news1_hot_news_adapter extends RecyclerView.Adapter<news1_hot_news_adapter.HotNewsViewHolder> {
    private List<news1_item> newsItems;

    public news1_hot_news_adapter(List<news1_item> newsItems) {
        this.newsItems = newsItems;
    }

    @NonNull
    @Override
    public HotNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news1_hot_news, parent, false);
        return new HotNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotNewsViewHolder holder, int position) {
        news1_item currentItem = newsItems.get(position);
        Glide.with(holder.itemView.getContext()).load(currentItem.getImg()).into(holder.newsImage);
        holder.newsTitle.setText(currentItem.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), news3_activity.class);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsItems.size();
    }

    public static class HotNewsViewHolder extends RecyclerView.ViewHolder {
        public ImageView newsImage;
        public TextView newsTitle;

        public HotNewsViewHolder(View itemView) {
            super(itemView);
            newsImage = itemView.findViewById(R.id.news1_hot_item);
            newsTitle = itemView.findViewById(R.id.news1_hot_item_title);
        }
    }
}
