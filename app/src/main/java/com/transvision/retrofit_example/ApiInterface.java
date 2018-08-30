package com.transvision.retrofit_example;

import com.transvision.retrofit_example.online.Response123;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("/Service.asmx/TestSysDate")
    Call<List<Test>> getsyDate();

    @GET("/youtube/v3/search?part=id,snippet&maxResults=20&channelId=UCCq1xDJMBRF61kiOgU90_kw&key=AIzaSyBRLPDbLkFnmUv13B-Hq9rmf0y7q8HOaVs")
    Call<Response123> getresponse();

    @POST("/Retrofit_Discon_Recon.asmx/MRDetails")
    @FormUrlEncoded
    Call<List<MRLogin>> getlogin(@Field("MRCode") String mrcode,
                           @Field("DeviceId") String device,
                           @Field("PASSWORD") String password);

    @POST("/ReadFile.asmx/ReConList")
    @FormUrlEncoded
    Call<List<ReCon>> getRecon(@Field("MRCode") String mrcode,
                                 @Field("Date") String Date);
}
