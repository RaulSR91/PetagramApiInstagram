package com.salazar.raul.bkfo.restApi;

/**
 * Created by rsalazarr on 05/09/2016.
 */
public final class ConstantesRestApi {
    /*Campos del instructor*/
    //https://api.instagram.com/v1/
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "3691098682.6966907.c986ce5c678b4462813fc5ca7a40a177";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN



    /*Obtener Id de un usuario especifico*/
    /*https://api.instagram.com/v1/users/search?q=jack&access_token=ACCESS-TOKEN*/
    public static final String SEARCH_USER = "users/searchxS?q=jcma1979";

   // public static final String GET_INFO_USER = SEARCH_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    //public static final String GET_INFO_USER = "https://api.instagram.com/v1/users/search?q=jcma1979&access_token=3691098682.6966907.c986ce5c678b4462813fc5ca7a40a177";
    public static final String GET_INFO_USER = "users/self/?access_token=3691098682.6966907.c986ce5c678b4462813fc5ca7a40a177";
}
