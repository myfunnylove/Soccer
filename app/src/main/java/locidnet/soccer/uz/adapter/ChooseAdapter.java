package locidnet.soccer.uz.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.model.ChooseDate;
import locidnet.soccer.uz.model.Match;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class ChooseAdapter extends RecyclerView.Adapter<ChooseAdapter.Holder> {
    private Context ctx;
    private ArrayList<ChooseDate> list;
    private LayoutInflater inflater;

    public ChooseAdapter(Context ctx, ArrayList<ChooseDate> list) {
        this.ctx = ctx;
        this.list = list;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_choose_date,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
            ChooseDate chooseDate = list.get(position);

        if (chooseDate.isSelected()){

            holder.title.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_click_accent));
            holder.title.setTextColor(ctx.getResources().getColor(R.color.white));

        }else {

            holder.title.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_click_accent_light));
            holder.title.setTextColor(ctx.getResources().getColor(R.color.white));

        }
        holder.title.setText(chooseDate.getTitle());
        holder.title.setOnClickListener(view -> {
            setChange(holder.getAdapterPosition());
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }

    public void setChange(int pos){
        for (int i = 0; i < list.size(); i++) {
            if (i == pos) list.get(i).setSelected(true);
            else list.get(i).setSelected(false);
        }
    }
}
