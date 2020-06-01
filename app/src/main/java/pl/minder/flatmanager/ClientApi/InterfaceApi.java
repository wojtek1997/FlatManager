package pl.minder.flatmanager.ClientApi;

import io.reactivex.Observable;
import pl.minder.flatmanager.GlobalData.User;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceApi {

    @GET("usersexist")
    Boolean checkExists(@Query("login") String login);

    @GET("usersl")
    Observable<User> getUserByLogin(@Query("login") String login);
}
