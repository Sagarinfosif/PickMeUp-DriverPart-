package com.drive.pickmeup;

import com.drive.pickmeup.ModelClass.UserRegisterModel;
import com.drive.pickmeup.Pojo.CityPojo;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.Pojo.RegisterationPojo;
import com.drive.pickmeup.Pojo.StatesPojo;
import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiInterface {

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("phoneValidate")
    Call<Map> verifyPhone(@Body JsonObject data
    );


    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("userRegister")
    Call<UserRegisterModel> registeration(@Body JsonObject data
    );


    @POST("stateList")
    Call<StatesPojo> getStates();

    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("cityList")
    Call<CityPojo> getCities(@Body JsonObject data
    );

    @POST("driverRegister")
    @FormUrlEncoded
    Call<RegisterPojo> registerData(@Field("username") String username,
                                    @Field("email") String email,
                                    @Field("phone") String phone,
                                    @Field("password") String password,
                                    @Field("address") String address,
                                    @Field("postCode") String postCode,
                                    @Field("city") String city,
                                    @Field("state") String state,
                                    @Field("id_document") String id_document,
                                    @Field("driving_license") String driving_license,
                                    @Field("vehicleType") String vehicleType,
                                    @Field("reg_id") String reg_id,
                                    @Field("device_type") String device_type,
                                    @Field("latitude") String latitude,
                                    @Field("longitude") String longitude,
                                    @Field("countryCode") String countryCode,
                                    @Field("countryName") String countryName);


    @POST("driverMatchOtp")
    @FormUrlEncoded
    Call<RegisterPojo> otpMatch(@Field("phone") String phone,
                                @Field("otp") String otp,
                                @Field("countryCode") String countryCode
    );

    @POST("driverResendOtp")
    @FormUrlEncoded
    Call<RegisterPojo> resendOtp(@Field("phone") String phone,
                                 @Field("countryCode") String countryCode
    );

    @POST("driverLogin")
    @FormUrlEncoded
    Call<RegisterPojo> login(@Field("email") String email,
                             @Field("password") String password,
                             @Field("reg_id") String reg_id,
                             @Field("device_type") String device_type,
                             @Field("latitude") String latitude,
                             @Field("longitude") String longitude
    );


    @POST("updateDriverProfile")
    @Multipart
    Call<RegisterPojo> profileUpdate(@Part("id") RequestBody id,
                                     @Part("name") RequestBody name,
                                     @Part("address") RequestBody address,
                                     @Part MultipartBody.Part image);


    @POST("changeDriverPhone")
    @FormUrlEncoded
    Call<RegisterPojo> updateMobile(@Field("userId") String userId,
                                    @Field("countryCode") String countryCode,
                                    @Field("phone") String phone
    );


    @POST("driverChangePassword")
    @FormUrlEncoded
    Call<Map> updatePassword(@Field("userId") String userId,
                             @Field("otp") String otp,
                             @Field("new_password") String password

    );


    @POST("driverForgotPassword")
    @FormUrlEncoded
    Call<RegisterPojo> forgotPassword(@Field("countryCode") String userId,
                                      @Field("phone") String countryCode

    );




    @POST("driverUpdateEmail")
    @FormUrlEncoded
    Call<RegisterPojo> updateEmail(@Field("userId") String userId,
                             @Field("email") String email

    );




}
