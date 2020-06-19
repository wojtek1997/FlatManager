package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.GregorianCalendar;

import androidx.appcompat.app.AppCompatActivity;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.FlatData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ProblemActivity extends AppCompatActivity implements View.OnClickListener{

    InterfaceApi interfaceApi;

    EditText edProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem);

        findViewById(R.id.btnSendProblem).setOnClickListener(this);

        edProblem=findViewById(R.id.edProblem);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnSendProblem) {

            String type = "problem";
            String date = "";

            long timestamp = System.currentTimeMillis(); //pobiera czas jako timestamp
            Date date2 = new Date(timestamp); // tworzy obiekt daty na podstawie timestamp
            GregorianCalendar calendar = new GregorianCalendar();
            calendar.setTime(date2); //ustawia datę timestampu do kalendarza

            String day = String.valueOf(date2.getDay());
            String month = String.valueOf(date2.getMonth() + 1);
            String year = String.valueOf(date2.getYear());
            year = year.substring(year.length()-2);
            date = month + "/" + day + "/" + year;
            Log.e("DAta : ", date);

            String description = edProblem.getText().toString();

            addProblem(type, date, description, FlatData.idFlat);


            Intent intent = new Intent(ProblemActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void addProblem(String type, String description, String date, Long idFlat){
        Call<String> call = interfaceApi.addProblem(type, description, date, idFlat);
        call.enqueue(new Callback<String>(){
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(getApplicationContext(), "Pomyślnie wysłano!", Toast.LENGTH_LONG).show();
                call.cancel();


                Intent intent = new Intent(ProblemActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Wystąpił błąd, spróbuj ponownie!", Toast.LENGTH_LONG).show();
                call.cancel();


                Intent intent = new Intent(ProblemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
