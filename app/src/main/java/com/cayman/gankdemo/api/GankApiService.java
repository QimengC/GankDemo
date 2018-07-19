package com.cayman.gankdemo.api;

import com.cayman.gankdemo.bean.GankBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface GankApiService {

    //http://gank.io/api/data/all/10/1'
    //baseUrl = "http://gank.io/api/"

    // 更推荐使用这种办法，只需要传递参数即可
//    @GET("data/android/{pagesize}/{page}")
//    Call<GankBean> getData(@Path("pagesize") int pagesize, @Path("page") int page);


    // 更推荐使用这种办法，只需要传递参数即可
    @GET("data/all/{pagesize}/{page}")
    Observable<GankBean> getData(@Path("pagesize") int pagesize, @Path("page") int page);

}
