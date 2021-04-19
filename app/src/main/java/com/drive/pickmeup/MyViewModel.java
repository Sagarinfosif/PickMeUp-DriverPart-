package com.drive.pickmeup;

import android.app.Activity;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.drive.pickmeup.ModelClass.ErrorModel;
import com.drive.pickmeup.ModelClass.UserRegisterModel;
import com.drive.pickmeup.Pojo.CityPojo;
import com.drive.pickmeup.Pojo.RegisterPojo;
import com.drive.pickmeup.Pojo.RegisterationPojo;
import com.drive.pickmeup.Pojo.StatesPojo;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {

    ApiInterface apiInterface = ApiBaseClient.getClient().create(ApiInterface.class);

    public LiveData<RegisterPojo> register(Activity activity, String username, String email,String phone,String password,String address,String postCode,String city,String state,String idDocument,String drivingLincense
    ,String vehicleType,String regId,String deviceType,String latitude,String longitude,String countryCode,String countryName) {
        MutableLiveData<RegisterPojo> registerPojo = new MutableLiveData<>();
        apiInterface.registerData(username,email,phone,password,address,postCode,city,state,idDocument,drivingLincense,vehicleType,regId,deviceType,latitude,longitude,countryCode,countryName).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if (response.body() != null) {
                    registerPojo.postValue(response.body());
                } else {
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return registerPojo;
    }




    public LiveData<RegisterPojo> otpMatch(Activity activity,String phone,String otp,String countryCode) {
        MutableLiveData<RegisterPojo> otpMatch = new MutableLiveData<>();
        apiInterface.otpMatch(phone,otp,countryCode).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body()!=null){
                    otpMatch.postValue(response.body());
                }else {
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return otpMatch;
    }



    public LiveData<RegisterPojo> otpResend(Activity activity,String phone,String countryCode) {
        MutableLiveData<RegisterPojo> otpResend = new MutableLiveData<>();
        apiInterface.resendOtp(phone,countryCode).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body()!=null){
                    otpResend.postValue(response.body());
                }else {
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return otpResend;
    }



    public LiveData<RegisterPojo> login(Activity activity,String email,String password,String reg_id,String device_type,String latitude,String logitude ) {
        MutableLiveData<RegisterPojo> loginPojo = new MutableLiveData<>();
        apiInterface.login(email,password,reg_id,device_type,logitude,latitude).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {

                if(response.body()!=null){

                    loginPojo.postValue(response.body());
                }else {
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return loginPojo;
    }


    public LiveData<RegisterPojo> profileUpdate(Activity activity, RequestBody id, RequestBody name, RequestBody address, MultipartBody.Part userImage) {
        MutableLiveData<RegisterPojo> updateProfilePojo = new MutableLiveData<>();
        apiInterface.profileUpdate(id,name,address,userImage).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {

              if(response.body()!=null){

                  updateProfilePojo.postValue(response.body());
              }else{
                  Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return updateProfilePojo;
    }


    public LiveData<RegisterPojo> updatePhoneNumber(Activity activity,String userId,String countryCode,String phone)
     {
        MutableLiveData<RegisterPojo> updatePhonePojo = new MutableLiveData<>();
        apiInterface.updateMobile(userId,countryCode,phone).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body()!=null){
                    updatePhonePojo.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return updatePhonePojo;
    }



    public LiveData<Map> changePassword(Activity activity,String userId,String otp,String newPassword)
    {
        MutableLiveData<Map> changePasswordPojo = new MutableLiveData<>();
        apiInterface.updatePassword(userId,otp,newPassword).enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Call<Map> call, Response<Map> response) {
                if(response.body()!=null){
                    changePasswordPojo.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Map> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return changePasswordPojo;
    }

    public LiveData<RegisterPojo> forgotPassword(Activity activity,String countryCode,String phone)
    {
        MutableLiveData<RegisterPojo> forgotPasswordPojo = new MutableLiveData<>();
        apiInterface.forgotPassword(countryCode,phone).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body()!=null){
                    forgotPasswordPojo.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return forgotPasswordPojo;
    }


    public LiveData<RegisterPojo> updateEmail(Activity activity,String userId,String email)
    {
        MutableLiveData<RegisterPojo> updateEmailPojo = new MutableLiveData<>();
        apiInterface.updateEmail(userId,email).enqueue(new Callback<RegisterPojo>() {
            @Override
            public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                if(response.body()!=null){
                    updateEmailPojo.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return updateEmailPojo;
    }


    public LiveData<Map> phoneRegister(Activity activity, JsonObject data)
    {
        MutableLiveData<Map> phoneRegister = new MutableLiveData<>();
        apiInterface.verifyPhone(data).enqueue(new Callback<Map>() {
            @Override
            public void onResponse(Call<Map> call, Response<Map> response) {
                if(response.body()!=null){
                    phoneRegister.postValue(response.body());
                }else if (response.code()==400){
                    ErrorModel errorResponse = new Gson().fromJson(response.errorBody().charStream(),ErrorModel.class);
                    Toast.makeText(activity, ""+errorResponse.getErrorMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Map> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return phoneRegister;
    }


    public LiveData<UserRegisterModel> registration(Activity activity, JsonObject data)
    {
        MutableLiveData<UserRegisterModel> resgisteration = new MutableLiveData<>();
        apiInterface.registeration(data).enqueue(new Callback<UserRegisterModel>() {
            @Override
            public void onResponse(Call<UserRegisterModel> call, Response<UserRegisterModel> response) {
                if(response.body()!=null){
                    resgisteration.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserRegisterModel> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return resgisteration;
    }


    public LiveData<StatesPojo> getStates(Activity activity)
    {
        MutableLiveData<StatesPojo> statePojo = new MutableLiveData<>();
        apiInterface.getStates().enqueue(new Callback<StatesPojo>() {
            @Override
            public void onResponse(Call<StatesPojo> call, Response<StatesPojo> response) {
                if(response.body()!=null){
                    statePojo.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<StatesPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return statePojo;
    }

    public LiveData<CityPojo> getCities(Activity activity, JsonObject data)
    {
        MutableLiveData<CityPojo> cityPojo = new MutableLiveData<>();
        apiInterface.getCities(data).enqueue(new Callback<CityPojo>() {
            @Override
            public void onResponse(Call<CityPojo> call, Response<CityPojo> response) {
                if(response.body()!=null){
                    cityPojo.postValue(response.body());
                }else{
                    Toast.makeText(activity, "response null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CityPojo> call, Throwable t) {
                Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        return cityPojo;
    }

}
