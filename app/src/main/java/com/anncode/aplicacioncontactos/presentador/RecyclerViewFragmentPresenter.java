package com.anncode.aplicacioncontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.anncode.aplicacioncontactos.model.ConstructorContactos;
import com.anncode.aplicacioncontactos.model.Contacto;
import com.anncode.aplicacioncontactos.restApi.EndpointApi;
import com.anncode.aplicacioncontactos.restApi.adapter.RestApiAdapter;
import com.anncode.aplicacioncontactos.restApi.model.ContactoResponse;
import com.anncode.aplicacioncontactos.vista.fragment.IRecyclerViewFragmentView;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by anahisalgado on 21/04/16.
 */

public class RecyclerViewFragmentPresenter implements IRecylerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        //obtenerContactos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent= restApiAdapter.contruyeGsonDeserializadorMediaRecent();
        EndpointApi endpointApi =  restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall=endpointApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse= response.body();
                contactos= contactoResponse.getContactos();
                mostrarContactosRV();

            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context,"!Algo paso en la conexion intenta de nuevo",Toast.LENGTH_LONG).show();
                Log.e("Fallo la conexión", t.toString());

            }
        });

    }


    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarGridLayout();
    }
}
