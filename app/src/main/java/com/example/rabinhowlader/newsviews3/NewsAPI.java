package com.example.rabinhowlader.newsviews3;

import com.example.rabinhowlader.newsviews3.model.News;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NewsAPI {
    private static final String key ="33b011ee932c4275a0d99cb663a0f24e";
    private static final String url="https://newsapi.org/v2/everything/";

    public static PostService postService = null;
    public static PostService getPostService(){
        if (postService==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            postService = retrofit.create(PostService.class);


        }
        return postService;
    }

    public interface PostService{
        @GET("?q=bitcoin&from=2018-11-30&sortBy=publishedAt&apiKey=33b011ee932c4275a0d99cb663a0f24e" )
        Call<News> getPostList();


    }

    }

