package com.salazar.raul.bkfo.restApi;

import com.salazar.raul.bkfo.restApi.model.MascotaResponse;
import com.salazar.raul.bkfo.restApi.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public interface EndPointsApi {
    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET(ConstantesRestApi.GET_INFO_USER)
    Call<UserResponse> getPerfilUsuario();

}
