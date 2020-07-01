package pl.minder.flatmanager.ClientApi;

import java.util.List;

import io.reactivex.Observable;
import pl.minder.flatmanager.Model.Event;
import pl.minder.flatmanager.Model.User;
import pl.minder.flatmanager.Model.UsersBills;
import pl.minder.flatmanager.Model.UsersContracts;
import pl.minder.flatmanager.Model.UsersFlats;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface InterfaceApi {

    /*
    Get
     */

    @GET("usersl")
    Observable<User> getUserByLogin(@Query("login") String login);

    @GET("userslandp")
    Observable<List<User>> getLoginAndPassword();

    @GET("flatsusersid")
    Observable<List<UsersFlats>> getFlatForUser(@Query("idUzytkownika") Long idUser);

    @GET("ownerflatsid")
    Observable<List<UsersFlats>> getOwner(@Query("idMieszkania") Long idFlat);

    @GET("billsusersid")
    Observable<List<UsersBills>> getBillsForUser(@Query("idUzytkownika") Long idUser);

    @GET("contractsusersid")
    Observable<List<UsersContracts>> getContractForUser(@Query("idUzytkownika") Long idUser);

    @GET("announce")
    Observable<List<Event>> getAnnouncement(@Query("idMieszkania") Long idFlat);

    /*
    Post
     */

    @POST("users")
    Call<User> addUser(@Body User user);

    @POST("events")
    Call<String> addProblem(@Query("typZdarenia") String type, @Query("opis") String description, @Query("dataZgloszenia") String date, @Query("idMieszkania") Long idFlat);

}
