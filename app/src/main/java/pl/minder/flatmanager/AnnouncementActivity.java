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
import pl.minder.flatmanager.Adapters.AnnounceLVAdapter;
import pl.minder.flatmanager.ClientApi.ClientApi;
import pl.minder.flatmanager.ClientApi.InterfaceApi;
import pl.minder.flatmanager.GlobalData.FlatData;
import pl.minder.flatmanager.Model.Event;
import retrofit2.Retrofit;

public class AnnouncementActivity extends AppCompatActivity implements View.OnClickListener{

    InterfaceApi interfaceApi;

    ListView lvAnnounce;

    List<String> announceDescription;
    List<String> announceDate;
    Integer announceImageId = (R.drawable.announce);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);

        findViewById(R.id.btnBackFromAnnouncement).setOnClickListener(this);
        findViewById(R.id.btnRefreshAnnounce).setOnClickListener(this);

        lvAnnounce = findViewById(R.id.lvAnnounce);

        announceDescription = new ArrayList<>();
        announceDate = new ArrayList<>();

        Retrofit retrofit = ClientApi.getInstance();
        interfaceApi = retrofit.create(InterfaceApi.class);
    }



    @Override
    public void onClick(View view) {
        int i = view.getId();

        if (i == R.id.btnBackFromAnnouncement) {

            Intent intent = new Intent(AnnouncementActivity.this, MainActivity.class);
            startActivity(intent);

        }else if(i == R.id.btnRefreshAnnounce){
            getAnnouncement(FlatData.idFlat, announceDescription, announceDate);
            AnnounceLVAdapter announcesLVAdapter = new AnnounceLVAdapter(this, announceDescription, announceDate, announceImageId);
            lvAnnounce.setAdapter(announcesLVAdapter);
        }

    }

    private void getAnnouncement(Long idFlat, final List<String> announceDescription, final List<String> announceDate){

        interfaceApi.getAnnouncement(idFlat)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Event>>() {
                    @Override
                    public void onSubscribe(Disposable d) {


                    }

                    @Override
                    public void onNext(List<Event> events) {

                        announceDescription.clear();
                        announceDate.clear();

                        for(int i=0; i<events.size(); i++) {

                            announceDescription.add(events.get(i).getOpis());
                            announceDate.add(events.get(i).getDataZgloszenia());

                        }
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
