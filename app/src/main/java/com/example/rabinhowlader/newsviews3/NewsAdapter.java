package com.example.rabinhowlader.newsviews3;


import android.app.LauncherActivity;

import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rabinhowlader.newsviews3.model.Article;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private Context context;
    private List<Article> articles;

    public NewsAdapter(Context context, List<Article> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.post_main,viewGroup,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder newsViewHolder, int postion) {
         Article article=  articles.get(postion);
         newsViewHolder.postTitle.setText(articles.get(postion).getTitle());
         newsViewHolder.postDescription.setText(articles.get(postion).getDescription());
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView postImage;
        TextView postTitle;
        TextView postDescription;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage =(ImageView)itemView.findViewById(R.id.postImage);
            postTitle =(TextView)itemView.findViewById(R.id.postTitle);
            postDescription=(TextView)itemView.findViewById(R.id.postDescription);
        }
    }
}
