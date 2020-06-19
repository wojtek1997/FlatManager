package pl.minder.flatmanager.Adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import pl.minder.flatmanager.R;

public class AnnounceLVAdapter extends ArrayAdapter<String> {

    private List<String> announceDescription;
    private List<String> announceDate;
    private Integer announceImageId;
    private Activity context;

    public AnnounceLVAdapter(Activity context, List<String> announceDescription, List<String> announceDate, Integer announceImageId) {
        super(context, R.layout.annonce_row_layout, announceDescription);

        this.context = context;
        this.announceDescription = announceDescription;
        this.announceDate = announceDate;
        this.announceImageId = announceImageId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        AnnounceLVAdapter.ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.annonce_row_layout,null,true);
            viewHolder= new AnnounceLVAdapter.ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (AnnounceLVAdapter.ViewHolder) r.getTag();
        }
        viewHolder.ivAnnounce.setImageResource(announceImageId);

        viewHolder.tvDescription.setText(announceDescription.get(position));
        viewHolder.tvDate.setText((announceDate.get(position)));

        return r;
    }

    class  ViewHolder{
        TextView tvDescription;
        TextView tvDate;
        ImageView ivAnnounce;
        ViewHolder(View v){
            tvDescription = v.findViewById(R.id.tvAnnounceDescription);
            tvDate = v.findViewById(R.id.tvDate);
            ivAnnounce = v.findViewById(R.id.ivAnnounce);

        }
    }
}
