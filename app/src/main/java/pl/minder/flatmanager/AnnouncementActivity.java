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
import pl.minder.flatmanager.GlobalData.FlatData;
import pl.minder.flatmanager.Model.UsersEvents;
import retrofit2.Retrofit;

public class AnnouncementActivity extends AppCompatActivity implements View.OnClickListener{

    InterfaceApi interfaceApi;

    TextView tvAnnouncement;
    TextView tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        findViewById(R.id.btnBackFromAnnouncement).setOnClickListener(this);

        tvAnnouncement = findViewById(R.id.tvAnnounceDescription);
        tvDate = findViewById(R.id.tvAnnounceDate);

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getAnnouncement(FlatData.idFlat);
    }

    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnBackFromAnnouncement) {

            Intent intent = new Intent(AnnouncementActivity.this, MainActivity.class);
            startActivity(intent);
        }

    }

    private void getAnnouncement(Long idFlat){

        interfaceApi.getAnnouncement(idFlat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UsersEvents>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<UsersEvents> usersEvents) {
                        tvAnnouncement.setText(usersEvents.get(0).getZdarzenie().getOpis());
                        tvDate.setText(usersEvents.get(0).getZdarzenie().getDataZgloszenia());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError:", e.getMessage());
                    }


                    @Override
                    public void onComplete() {

                    }
                });
    }


}
