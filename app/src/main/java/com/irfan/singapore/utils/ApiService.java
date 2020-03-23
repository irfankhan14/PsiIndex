package com.irfan.singapore.utils;

import com.irfan.singapore.model.PsiResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by ikhans
 */
public interface ApiService {

    String BASE_URL = "https://api.data.gov.sg/v1/environment/";

    @GET("psi")
    Observable<PsiResponse> getPsiResponse();
}
