package pl.minder.flatmanager;

import android.content.Intent;
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
import pl.minder.flatmanager.GlobalData.UserData;
import pl.minder.flatmanager.Model.UsersContracts;
import retrofit2.Retrofit;

public class ContractActivity extends AppCompatActivity implements View.OnClickListener {

    InterfaceApi interfaceApi;

    TextView tvConclusionDate;
    TextView tvExpirationDate;
    TextView tvRent;
    TextView tvDeposit;
    TextView tvNoticePeriod;
    TextView tvFlatCity;
    TextView tvFlatStreet;
    TextView tvFlatHouseNr;
    TextView tvFlatFlatNr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        findViewById(R.id.btnBackFromContract).setOnClickListener(this);

        tvConclusionDate = findViewById(R.id.tvConclusionDate);
        tvExpirationDate = findViewById(R.id.tvExpirationDate);
        tvRent = findViewById(R.id.tvRent);
        tvDeposit = findViewById(R.id.tvDeposit);
        tvNoticePeriod = findViewById(R.id.tvDeposit);
        tvFlatCity = findViewById(R.id.tvFlatCity);
        tvFlatStreet = findViewById(R.id.tvFlatStreet);
        tvFlatHouseNr = findViewById(R.id.tvFlatHouseNr);
        tvFlatFlatNr = findViewById(R.id.tvFlatFlatNr);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }


    @Override
    protected void onStart() {
        super.onStart();
        getContract(UserData.idUser);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnBackFromContract) {

            Intent intent = new Intent(ContractActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void getContract(Long idUser){
        interfaceApi.getContractForUser(idUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UsersContracts>>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<UsersContracts> usersContracts) {
                        tvConclusionDate.setText(usersContracts.get(0).getUmowa().getDataZawarcia());
                        tvExpirationDate.setText(usersContracts.get(0).getUmowa().getDataZakonczenia());
                        tvRent.setText(usersContracts.get(0).getUmowa().getCzynsz().toString());
                        tvDeposit.setText(usersContracts.get(0).getUmowa().getKaucja().toString());
                        tvNoticePeriod.setText(usersContracts.get(0).getUmowa().getOkresWypowiedzenia().toString());
                        tvFlatCity.setText(usersContracts.get(0).getUmowa().getMieszkanie().getMiasto());
                        tvFlatStreet.setText(usersContracts.get(0).getUmowa().getMieszkanie().getUlica());
                        tvFlatHouseNr.setText(usersContracts.get(0).getUmowa().getMieszkanie().getNrDomu().toString());
                        tvFlatFlatNr.setText(usersContracts.get(0).getUmowa().getMieszkanie().getNrMieszkania().toString());

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
