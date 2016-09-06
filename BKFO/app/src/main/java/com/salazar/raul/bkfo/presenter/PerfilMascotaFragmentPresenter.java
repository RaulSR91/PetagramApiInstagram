package com.salazar.raul.bkfo.presenter;

import android.content.Context;
import android.net.IpPrefix;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.salazar.raul.bkfo.DB.ConstructorMascotas;
import com.salazar.raul.bkfo.R;
import com.salazar.raul.bkfo.pojo.Mascotas;
import com.salazar.raul.bkfo.pojo.Usuarios;
import com.salazar.raul.bkfo.restApi.EndPointsApi;
import com.salazar.raul.bkfo.restApi.adapter.RestApiAdapter;
import com.salazar.raul.bkfo.restApi.model.MascotaResponse;
import com.salazar.raul.bkfo.restApi.model.UserResponse;
import com.salazar.raul.bkfo.vista_fragment.IPerfilMascota;
import com.salazar.raul.bkfo.vista_fragment.IRecyclerViewFragmentView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter {
    private IPerfilMascota iPerfilMascota;/*Vista de Perfil Mascotas*/
    private ArrayList<Mascotas> mascotas;
    private ArrayList<Usuarios> usuario;
    private Context context;

    public  PerfilMascotaFragmentPresenter(IPerfilMascota iPerfilMascota, Context context ){
        this.iPerfilMascota  = iPerfilMascota;
        this.context = context;
        /*Los datos ahora de manejan desde un webServices*/

        this.obtenerIdUsuario();
        this.obtenerMediosRecientes();
    }



    @Override
    public void mostrarMascotasRV() {
        iPerfilMascota.inicializarAdaptadorRV(iPerfilMascota.CrearAdaptador(mascotas));
//        iRecyclerViewFragmentView.generarLinearLayoutVertical();
        iPerfilMascota.generarGridLayout();
    }

    public void mostrarUsuarios(ArrayList<Usuarios> usuarios){
       iPerfilMascota.asignarFotoPerfil(usuarios);





    }

    @Override
    public void obtenerIdUsuario() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
       //Call<UserResponse> userResponseCall = endpointsApi.getUser("jcma1979");
        Call<UserResponse> userResponseCall = endpointsApi.getPerfilUsuario();

        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                usuario = userResponse.getUsuarios();
                mostrarUsuarios(usuario);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });


    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndPointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<MascotaResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse contactoResponse = response.body();
                mascotas = contactoResponse.getContactos();
                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
}
