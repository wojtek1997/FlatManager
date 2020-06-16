package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.UserData;
import pl.minder.flatmanager.Model.UsersBills;
import retrofit2.Retrofit;

public class BillsActivity extends AppCompatActivity implements View.OnClickListener {

    InterfaceApi interfaceApi;

    ListView lvBills;

    ArrayList<String> bills;

    ArrayAdapter arrayAdapter;

    /*TextView tvDescription;
    TextView tvAmount;
    TextView tvBillSensor;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        findViewById(R.id.btnBack).setOnClickListener(this);
        findViewById(R.id.btnRefresh).setOnClickListener(this);

        /*tvDescription = findViewById(R.id.tvDescription1);
        tvAmount = findViewById(R.id.tvAmount1);
        tvBillSensor = findViewById(R.id.tvBillSensor1);*/

        lvBills = findViewById(R.id.lvBills);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);

        bills = new ArrayList<>();

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bills);

        lvBills.setAdapter(arrayAdapter);

    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnBack) {

            Intent intent = new Intent(BillsActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(i == R.id.btnRefresh){

            getBills(UserData.idUser, bills);
            arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bills);
            lvBills.setAdapter(arrayAdapter);
            //bills = new ArrayList<>();
        }

    }


    private void getBills (Long idUser, final ArrayList<String> bills){
        interfaceApi.getBillsForUser(idUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UsersBills>>() {

                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<UsersBills> usersBills) {

                                   bills.clear();

                                   for(int i=0; i<usersBills.size(); i++) {
                                       String Sensor;
                                       boolean SenseorBill = usersBills.get(i).getRachunek().getCzyRozlicznoy();

                                       if (SenseorBill == true) {
                                           Sensor = "Rachunek rozliczony";
                                       } else {
                                           Sensor = "Rachunek nierozliczony!";
                                       }


                                       String description = usersBills.get(i).getRachunek().getOpis();
                                       String amount = usersBills.get(i).getRachunek().getKwota().toString();

                                       String bill = "OPIS: " + description + "\n" + "KWOTA: " + amount + "zł \n" + "    " + Sensor;


                                       bills.add(bill);
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
}
