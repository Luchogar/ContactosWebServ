package com.anncode.aplicacioncontactos.restApi;

/**
 * Created by Luis García on 04/01/2017.
 */

public final class ConstantesRestApi {
    public static final String VERSION="/v1/";
    public static final String ROOT_URL="https://api.instagram.com"+VERSION;
    public static final String ACCESS_TOKEN="4353219524.e098ce0.52a1ee8bf4a947babd4dfb2b071aae1f";
    public static final String KEY_ACCESS_TOKEN="?access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER="users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER=KEY_GET_RECENT_MEDIA_USER+KEY_ACCESS_TOKEN+ACCESS_TOKEN;


    //https://api.instagram.com/v1/users/self/?access_token=4353219524.e098ce0.52a1ee8bf4a947babd4dfb2b071aae1f
}
