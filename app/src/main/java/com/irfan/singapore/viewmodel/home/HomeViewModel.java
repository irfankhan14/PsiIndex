package com.irfan.singapore.viewmodel.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.irfan.singapore.model.PsiResponse;
import com.irfan.singapore.utils.ApiService;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<PsiResponse> responseMutableLiveData;
    private MutableLiveData<String> errorMsg;
    private MutableLiveData<Boolean> progressDialog;
    private Retrofit retrofit;

    public HomeViewModel() {
        // Initialize the variables
        responseMutableLiveData = new MutableLiveData<>();
        errorMsg = new MutableLiveData<>();
        progressDialog = new MutableLiveData<>();
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        fetchDataFromApi();
    }

    // Set the response data
    private void fetchDataFromApi() {
        // call the api
        ApiService apiService = retrofit.create(ApiService.class);
        progressDialog.postValue(true);
        apiService
                .getPsiResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onError(Throwable throwable) {
        // Handle on API Failure
        errorMsg.postValue(throwable.getLocalizedMessage());
        progressDialog.postValue(false);
    }

    private void onSuccess(PsiResponse psiResponse) {
        // Handle on API Success
        progressDialog.postValue(false);
        if (psiResponse.getRegionMetadata().size() != 0) {
            responseMutableLiveData.postValue(psiResponse);
        } else {
            errorMsg.postValue("No data available currently");
        }
    }

    // Get the response data
    public LiveData<PsiResponse> getResponseData() {
        return responseMutableLiveData;
    }

    public LiveData<String> getErrorMessage() {
        return errorMsg;
    }

    public LiveData<Boolean> getProgressDialog() {
        return progressDialog;
    }

}