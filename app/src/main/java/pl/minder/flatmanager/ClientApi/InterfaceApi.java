package pl.minder.flatmanager.ClientApi;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceApi {

    @GET("usersexist")
    Boolean checkExists(@Query("login") String login);
}
