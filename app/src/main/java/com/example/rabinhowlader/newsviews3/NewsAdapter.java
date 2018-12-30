package com.example.rabinhowlader.newsviews3;


import android.app.LauncherActivity;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.icu.util.RangeValueIterator;
import android.sax.Element;
import android.service.autofill.FieldClassification;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.rabinhowlader.newsviews3.model.Article;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
         final Article article=  articles.get(postion);
         newsViewHolder.postTitle.setText(articles.get(postion).getTitle());
         newsViewHolder.postDescription.setText(articles.get(postion).getDescription());
         newsViewHolder.postUrl.setText(articles.get(postion).getUrl());
         newsViewHolder.postArticle.setText(articles.get(postion).getAuthor());

        Document document = Jsoup.parse(article.getContent());
        Elements elements = document.select("img");

         Glide.with(context).load(article.getUrlToImage()).into(newsViewHolder.postImage);

         newsViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context,DetailActivity.class);
                 intent.putExtra("url",article.getUrl());
                 context.startActivity(intent);
             }
         });


     }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder{

        ImageView postImage;
        TextView postTitle;
        TextView postDescription;
        TextView postArticle;
        TextView postUrl;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            postImage =(ImageView)itemView.findViewById(R.id.postImage);
            postTitle =(TextView)itemView.findViewById(R.id.postTitle);
            postDescription=(TextView)itemView.findViewById(R.id.postDescription);
            postArticle = (TextView)itemView.findViewById(R.id.postArticle);
            postUrl = (TextView)itemView.findViewById(R.id.postUrl);
        }
    }
}
