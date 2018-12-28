package com.example.rabinhowlader.newsviews3;

import com.example.rabinhowlader.newsviews3.model.News;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class NewsAPI {
    private static final String key ="a55f2408baa54c2ab6303d6e8476d80d";
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
        @GET("?key="+key)
        Call<News> getPostList();
    }
}
