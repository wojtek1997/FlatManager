package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.NewUser;
import pl.minder.flatmanager.GlobalData.User;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    InterfaceApi interfaceApi;
    EditText edLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        edLogin = findViewById(R.id.edLogin);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnLogin) {

            String login = edLogin.getText().toString();

            getUser(login);

            if( NewUser.login.equals(login)){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"zly login", Toast.LENGTH_LONG).show();
            }

        }

    }

    /*public boolean checkLoginExist (String login){

        // tutaj probowałem zrobić to, ale dość nieudolnie :P
        return true;

    }*/

    private void getUser(String login) {
        compositeDisposable.add(interfaceApi.getUserByLogin(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<User>() {
                    @Override
                    public void accept(User user) throws Exception {
                        User user1 = user;
                        NewUser.idUser = user1.getIdUzytkownika();
                        NewUser.type = user1.getTypUzytkownika();
                        NewUser.firstName = user1.getImie();
                        NewUser.lastName = user1.getNazwisko();
                        NewUser.telefonNumber = user1.getNrTelefonu();
                        NewUser.emailAdress = user1.getAdresEmail();
                        NewUser.login = user1.getLogin();
                        NewUser.password = user1.getHaslo();


                        Log.e("userid: ", NewUser.idUser.toString() + "/n type: " + NewUser.type + "/n firstname: " + NewUser.firstName + "/n lastname: " + NewUser.lastName + "/n telefonnumber: " + NewUser.telefonNumber.toString() + "/n emailadress: " + NewUser.emailAdress + "/n login: " + NewUser.login + "/n password: " + NewUser.password);

                    }
                })
        );

    }

    @Override
    protected void onStop(){
        compositeDisposable.clear();
        super.onStop();
    }
}
