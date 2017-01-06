package com.anncode.aplicacioncontactos.restApi;

import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Luis García on 05/01/2017.
 */

public interface EndpointApi {
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();
}
