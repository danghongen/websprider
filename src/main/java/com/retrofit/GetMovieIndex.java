package com.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;


//创建用于描述网络请求的接口
public interface GetMovieIndex {
    @GET("/")
    public Call<ResponseBody> movieIndex();
}
