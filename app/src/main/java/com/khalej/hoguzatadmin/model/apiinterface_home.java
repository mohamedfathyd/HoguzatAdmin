package com.khalej.hoguzatadmin.model;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface apiinterface_home {

    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_login.php")
    Call<List<contact_userinfo>> getcontacts_login(@Field("phonee") String phone, @Field("passw") String password);
    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_Registraion.php")
    Call<ResponseBody> getcontacts_newaccount(@Field("name") String name, @Field("password") String password, @Field("address") String address,
                                              @Field("phone") String phone);

    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_menSalon_category.php")
    Call<List<contact_category>>getSalonCategry(@Field("id") int id, @Field("country") int country, @Field("gender") int gender);

    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_search.php")
    Call<List<contact_category>>getSalonCategrySearch(@Field("id") int id, @Field("country") int country, @Field("gender") int gender,
                                                      @Field("city") String city);

    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_menSalon_category_stuff.php")
    Call<List<content_stuff>>getStuff(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_menSalon_category_servcies.php")
    Call<List<content_servcies>>getServcies(@Field("id") int id);

    @FormUrlEncoded
    @POST("montag/Hoguzat/Hoguzat_add_order.php")
    Call<ResponseBody> getcontacts_order(@Field("name") String name, @Field("address") String address,
                                         @Field("phone") String phone,
                                         @Field("details") String details,
                                         @Field("price") double price

    );

    @FormUrlEncoded
    @POST("montag/handmade/HandMade_order_ready.php")
    Call<ResponseBody> update_status2(@Field("id") int id);
    @GET("montag/handmade/HandMade_all_neworders.php")
    Call<List<contact_order>> get_all_neworders();

    @FormUrlEncoded
    @POST("montag/handmade/HandMade_delete_generalcategory.php")
    Call<ResponseBody> delete_first(@Field("id") int id);
    @GET("montag/handmade/HandMade_all_generalcategory.php")
    Call<List<contact_category>> getcontacts_first();
    @FormUrlEncoded
    @POST("Hoguzat_add_category.php")
    Call<ResponseBody> getcontacts_add_first_category(@Field("name") String name,@Field("details") String details,
                                                      @Field("offers") String offers,
                                                      @Field("image") String image,
                                                      @Field("country") int country,@Field("lat") Double lat,
                                                      @Field("lng") Double lng);

    @FormUrlEncoded
    @POST("Hoguzat_add_stuff.php")
    Call<ResponseBody> getcontacts_add_first_stuff(@Field("sub_id")int id,@Field("name") String name,
                                                      @Field("image") String image);

    @FormUrlEncoded
    @POST("Hoguzat_add_servcies.php")
    Call<ResponseBody> getcontacts_add_first_servcies(@Field("sub_id")int id,@Field("name") String name,
                                                   @Field("price") Double price);

}

