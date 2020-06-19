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

public class BillsLVAdapter extends ArrayAdapter<String> {

    private List<String> billsDescription;
    private List<String> billsAmount;
    private List<String> billsSensor;
    private Integer billImageId;
    private Activity context;

    public BillsLVAdapter(Activity context, List<String> billsDescription, List<String> billsAmount, List<String> billsSensor, Integer billImageId) {
        super(context, R.layout.bills_row_layout, billsDescription );

        this.context = context;
        this.billsDescription = billsDescription;
        this.billsAmount = billsAmount;
        this.billsSensor = billsSensor;
        this.billImageId = billImageId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r=convertView;
        ViewHolder viewHolder = null;
        if(r==null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.bills_row_layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) r.getTag();
        }
        viewHolder.ivBill.setImageResource(billImageId);

        viewHolder.tvDescription.setText(billsDescription.get(position));
        viewHolder.tvAmount.setText((billsAmount.get(position)));
        viewHolder.tvSensor.setText(billsSensor.get(position));

        return r;
    }

    class  ViewHolder{
        TextView tvDescription;
        TextView tvAmount;
        TextView tvSensor;
        ImageView ivBill;
        ViewHolder(View v){
            tvDescription = v.findViewById(R.id.tvDescription);
            tvAmount = v.findViewById(R.id.tvAmount);
            tvSensor = v.findViewById(R.id.tvBillSensor);
            ivBill = v.findViewById(R.id.ivBill);
        }
    }
}

