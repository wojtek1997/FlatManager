package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.FlatData;
import pl.minder.flatmanager.GlobalData.UserData;
import pl.minder.flatmanager.Model.User;
import pl.minder.flatmanager.Model.UsersFlats;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    InterfaceApi interfaceApi;
    EditText edLogin;
    EditText edPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);
        edLogin = findViewById(R.id.edLogin);
        edPassword = findViewById(R.id.edPassword);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);


    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnLogin) {

            if(edLogin.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
            }else{
                if(edPassword.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
                }else{
                    String login = edLogin.getText().toString();
                    String password = edPassword.getText().toString();

                    getLoginAndPassword(login, password);
                }
            }


        }else if(i == R.id.btnRegister) {

            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }

    }




    private void getLoginAndPassword(final String login, final String passsword) {

        interfaceApi.getLoginAndPassword()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        boolean loginTrue = false;
                        String loginFromServer;
                        String passwordFromServer;
                        int index = 0;
                        for(int i = 0; i < users.size(); i++ ){
                            loginFromServer = users.get(i).getLogin();
                            if(loginFromServer.equals(login)){
                                loginTrue=true;
                                index = i;
                                break;
                            }
                        }

                        if(loginTrue == true){
                            passwordFromServer = users.get(index).getHaslo();
                            passwordFromServer = DecodePassword(passwordFromServer);
                            if(passwordFromServer.equals(passsword)){
                                UserData.idUser = users.get(index).getIdUzytkownika();
                                UserData.type = users.get(index).getTypUzytkownika();
                                UserData.firstName = users.get(index).getImie();
                                UserData.lastName = users.get(index).getNazwisko();
                                UserData.telefonNumber = users.get(index).getNrTelefonu();
                                UserData.emailAdress = users.get(index).getAdresEmail();
                                UserData.login = login;
                                UserData.password = passsword;

                                getFlat(UserData.idUser);

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(getApplicationContext(), "Podałeś błędne hasło", Toast.LENGTH_LONG).show();
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Podałeś błędny login", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError:", e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );

    }

    private void getFlat (Long idUser){
        interfaceApi.getFlatForUser(idUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UsersFlats>>() {

                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<UsersFlats> usersFlats) {
                                   FlatData.idFlat = usersFlats.get(0).getMieszkania().getIdMieszkania();
                                   FlatData.city = usersFlats.get(0).getMieszkania().getMiasto();
                                   FlatData.street = usersFlats.get(0).getMieszkania().getUlica();
                                   FlatData.houseNr = usersFlats.get(0).getMieszkania().getNrDomu();
                                   FlatData.flatNr = usersFlats.get(0).getMieszkania().getNrMieszkania();
                                   FlatData.flatArea = usersFlats.get(0).getMieszkania().getPowierzchnia();
                                   FlatData.roomsNr = usersFlats.get(0).getMieszkania().getLiczbaPokoi();
                               }

                               @Override
                               public void onError(Throwable e) {
                                   Log.e("onError:", e.getMessage());
                               }

                               @Override
                               public void onComplete() {

                               }

                }

        );
    }

    public static String DecodePassword(String password) {
        String result = "";
        char d;
        for(int i = 0; i < password.length(); i++) {
            d = password.charAt(i);
            d -= 7 ;
            result += d;
        }

        return result;
    }
}
