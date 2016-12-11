package com.example.samar.retrofitintegration;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by samar on 11/12/16.
 */

public interface IApiMethods {

    @GET("/get/curators.json")
    Curator getCurators(
            @Query("api_key") String key
    );
}
