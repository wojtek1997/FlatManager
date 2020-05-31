package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

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

            boolean exist = checkLoginExist(login);

            if(exist == true){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"zly login", Toast.LENGTH_LONG).show();
            }

        }

    }

    public boolean checkLoginExist (String login){

        // tutaj probowałem zrobić to, ale dość nieudolnie :P

    }
}
