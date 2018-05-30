package com.retrofit;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

//创建retrofit对象
//创建网络请求接口实例
//发送网络请求
//处理返回数据
public class Test {
    public static void main(String[] args){

//            创建retrofit对象
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.dytt8.net/") // 设置 网络请求 Url,注意baseUrl应该以/结尾
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析，依赖已经加入
                .build();
//            创建网络请求接口实例
        GetMovieIndex getMovieIndex=retrofit.create(GetMovieIndex.class);
//        发送网络请求之前，对发送请求进行封装
        Call<ResponseBody> call=getMovieIndex.movieIndex();

//        发送网络请求(同步)，异步暂时未实现！
        try {

            Response<ResponseBody> response=call.execute();
            String result=new String(response.body().bytes(),"gbk");
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
