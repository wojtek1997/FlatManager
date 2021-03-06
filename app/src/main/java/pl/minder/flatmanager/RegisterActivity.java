package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.Model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    InterfaceApi interfaceApi;

    EditText edFirstName;
    EditText edLastName;
    EditText edPhoneNr;
    EditText edEmail;
    EditText edLogin;
    EditText edPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.btnNewRegister).setOnClickListener(this);
        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        edPhoneNr = findViewById(R.id.edPhoneNr);
        edEmail = findViewById(R.id.edEmail);
        edLogin = findViewById(R.id.edLoginRegister);
        edPassword = findViewById(R.id.edPasswordRegister);


        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnNewRegister) {

            if(edFirstName.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
            }else{
                if(edLastName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
                }else{
                    if(edPhoneNr.getText().toString().equals("")){
                        Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
                    }else{
                        if(edEmail.getText().toString().equals("")){
                            Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
                        }else{
                            if(edLogin.getText().toString().equals("")){
                                Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
                            }else{
                                if(edPassword.getText().toString().equals("")){
                                    Toast.makeText(getApplicationContext(), "Wszystkie pola nie zostały uzupełnione!", Toast.LENGTH_LONG).show();
                                }else{
                                    User user = new User();

                                    String newPassword = EncodePassword(edPassword.getText().toString());

                                    user.setTypUzytkownika("lokator");
                                    user.setImie(edFirstName.getText().toString());
                                    user.setNazwisko(edLastName.getText().toString());
                                    user.setNrTelefonu(Integer.parseInt(edPhoneNr.getText().toString()));
                                    user.setAdresEmail(edEmail.getText().toString());
                                    user.setLogin(edLogin.getText().toString());
                                    user.setHaslo(newPassword);

                                    addUser(user);
                                }
                            }
                        }
                    }
                }
            }
        }



    }

    private void addUser(final User user) {

        Call<User> call = interfaceApi.addUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(getApplicationContext(), "Konto zostało pomyślnie utworzone!", Toast.LENGTH_LONG).show();
                call.cancel();


                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("login", user.getLogin().toString());
                intent.putExtra("password", user.getHaslo().toString());
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Konto zostało pomyślnie utworzone!", Toast.LENGTH_LONG).show();
                call.cancel();


                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("login", user.getLogin().toString());
                intent.putExtra("password", user.getHaslo().toString());
                startActivity(intent);
            }
        });




    }

    private String EncodePassword(String password) {
        String result = "";
        char d;
        for(int i = 0; i < password.length(); i++) {
            d = password.charAt(i);
            d += 7;
            result += d;
        }

        return result;
    }
}
