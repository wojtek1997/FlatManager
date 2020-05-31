package pl.minder.flatmanager.ClientApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClientApi {

    private static Retrofit ourInstance;


    public static Retrofit getInstance() {
        OkHttpClient.Builder okhttpClientBuilder = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        okhttpClientBuilder.addInterceptor(logging);


        if (ourInstance == null)
            ourInstance = new Retrofit.Builder()
                    .baseUrl("https://flatmanagerapp.herokuapp.com/api/flatmanager/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okhttpClientBuilder.build())

                    .build();
        return ourInstance;
    }

    public ClientApi() {
    }
}
