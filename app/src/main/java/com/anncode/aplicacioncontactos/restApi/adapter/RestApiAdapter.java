package com.anncode.aplicacioncontactos.restApi.adapter;

import com.anncode.aplicacioncontactos.restApi.ConstantesRestApi;
import com.anncode.aplicacioncontactos.restApi.EndpointApi;
import com.anncode.aplicacioncontactos.restApi.deserializador.ContactoDeserializador;
import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Luis García on 05/01/2017.
 */

public class RestApiAdapter {

    public EndpointApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointApi.class);


    }
    public Gson contruyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class,new ContactoDeserializador());

        return  gsonBuilder.create();
    }
}
