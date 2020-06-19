package pl.minder.flatmanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pl.minder.flatmanager.Adapters.BillsLVAdapter;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.UserData;
import pl.minder.flatmanager.Model.UsersBills;
import retrofit2.Retrofit;

public class BillsActivity extends AppCompatActivity implements View.OnClickListener {

    InterfaceApi interfaceApi;

    ListView lvBills;

    List<String> billsDescription;
    List<String> billsAmount;
    List<String> billsSensor;

    Integer billImageId = (R.drawable.bill);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        findViewById(R.id.btnBack).setOnClickListener(this);
        findViewById(R.id.btnRefresh).setOnClickListener(this);



        lvBills = findViewById(R.id.lvBills);

        billsDescription = new ArrayList<>();
        billsAmount = new ArrayList<>();
        billsSensor = new ArrayList<>();


        BillsLVAdapter billsLVAdapter = new BillsLVAdapter(this, billsDescription, billsAmount, billsSensor,billImageId);
        lvBills.setAdapter(billsLVAdapter);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);



    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnBack) {

            Intent intent = new Intent(BillsActivity.this, MainActivity.class);
            startActivity(intent);
        }else if(i == R.id.btnRefresh){

            getBills(UserData.idUser, billsDescription, billsAmount, billsSensor);
            BillsLVAdapter billsLVAdapter = new BillsLVAdapter(this, billsDescription, billsAmount, billsSensor,billImageId);
            lvBills.setAdapter(billsLVAdapter);
            //bills = new ArrayList<>();
        }

    }


    private void getBills (Long idUser, final List<String> billsDescription, final List<String> billsAmount, final List<String> billsSensor){
        interfaceApi.getBillsForUser(idUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UsersBills>>() {

                               @Override
                               public void onSubscribe(Disposable d) {

                               }

                               @Override
                               public void onNext(List<UsersBills> usersBills) {

                                   billsDescription.clear();
                                   billsAmount.clear();
                                   billsSensor.clear();

                                   for(int i=0; i<usersBills.size(); i++) {
                                       boolean SenseorBill = usersBills.get(i).getCzyRozlicznoy();

                                       if (SenseorBill == true) {
                                           billsSensor.add("Rachunek rozliczony");
                                       } else {
                                           billsSensor.add("Rachunek nierozliczony!");
                                       }


                                       billsDescription.add(usersBills.get(i).getRachunek().getOpis());
                                       billsAmount.add(usersBills.get(i).getRachunek().getKwota().toString() + "zł");


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
