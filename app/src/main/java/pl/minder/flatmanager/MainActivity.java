package pl.minder.flatmanager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.FlatData;
import pl.minder.flatmanager.Model.UsersFlats;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    InterfaceApi interfaceApi;

    TextView tvCity;
    TextView tvStreet;
    TextView tvHouse;
    TextView tvFlat;
    TextView tvArea;
    TextView tvRoomsNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnLogout).setOnClickListener(this);
        findViewById(R.id.btnCall).setOnClickListener(this);
        findViewById(R.id.btnProblem).setOnClickListener(this);
        findViewById(R.id.btnBills).setOnClickListener(this);
        findViewById(R.id.btnContract).setOnClickListener(this);
        findViewById(R.id.btnAnnouncement).setOnClickListener(this);

        tvCity = findViewById(R.id.tvCity);
        tvStreet = findViewById(R.id.tvStreet);
        tvHouse = findViewById(R.id.tvHouse);
        tvFlat = findViewById(R.id.tvFlat);
        tvArea = findViewById(R.id.tvArea);
        tvRoomsNr = findViewById(R.id.tvRoomsNr);



        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    protected void onStart () {
        super.onStart();

        if(FlatData.city != null)
            tvCity.setText(FlatData.city);
        if(FlatData.street != null)
            tvStreet.setText(FlatData.street);
        if(FlatData.houseNr != null)
            tvHouse.setText(FlatData.houseNr.toString());
        if(FlatData.flatNr != null)
            tvFlat.setText(FlatData.flatNr.toString());
        if(FlatData.flatArea != null)
            tvArea.setText(FlatData.flatArea.toString());
        if(FlatData.roomsNr != null)
            tvRoomsNr.setText(FlatData.roomsNr.toString());
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnLogout) {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else if (i == R.id.btnCall) {

            callToOwner(FlatData.idFlat);

        }else if (i == R.id.btnProblem) {

            Intent intent = new Intent(MainActivity.this, ProblemActivity.class);
            startActivity(intent);
        }else if (i == R.id.btnBills) {

            Intent intent = new Intent(MainActivity.this, BillsActivity.class);
            startActivity(intent);
        }else if (i == R.id.btnContract) {

            Intent intent = new Intent(MainActivity.this, ContractActivity.class);
            startActivity(intent);
        }else if (i == R.id.btnAnnouncement) {

            Intent intent = new Intent(MainActivity.this, AnnouncementActivity.class);
            startActivity(intent);
        }

    }

    private void callToOwner(Long idFlat){
        interfaceApi.getOwner(idFlat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UsersFlats>>() {

                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<UsersFlats> usersFlats) {
                                   String phoneNr;
                                   String phoneNrToUriParse;

                                   phoneNr = usersFlats.get(0).getUzytkownicy().getNrTelefonu().toString();

                                   phoneNrToUriParse = "tel:" + phoneNr;

                                   Intent intent = new Intent();
                                   intent.setAction(Intent.ACTION_VIEW);

                                   intent.setData(Uri.parse(phoneNrToUriParse));
                                   startActivity(intent);
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
}


