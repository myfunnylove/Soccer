package locidnet.soccer.uz.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.model.ChooseDate;
import locidnet.soccer.uz.model.MatchTable;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class MatchTableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context ctx;
    private ArrayList<MatchTable> list;
    private LayoutInflater inflater;
    private final int HEADER = 1;
    private final int BODY = 2;
    public MatchTableAdapter(Context ctx, ArrayList<MatchTable> list) {
        this.ctx = ctx;
        this.list = list;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getItemViewType(int position) {
        if (position != 0){
            return BODY;
        }else{
            return HEADER;

        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER){
            return new Header(inflater.inflate(R.layout.item_table_list_header,parent,false));
        }else{
            return new Body(inflater.inflate(R.layout.item_table_list_body,parent,false));

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MatchTable chooseDate = list.get(position);

        if (getItemViewType(position) == HEADER){
            Header header = (Header) holder;
            header.title.setText(chooseDate.getLeauge());
        }else{
            Body body = (Body) holder;
            if (position == 1 || position == 2) body.container.setBackgroundDrawable(ctx.getResources().getDrawable(R.drawable.bg_ligh_green));
            body.position.setText(chooseDate.getPosition());
            body.name.setText(chooseDate.getName());
            body.win.setText(chooseDate.getWin());
            body.nichya.setText(chooseDate.getNichya());
            body.fall.setText(chooseDate.getFall());
            body.score.setText(chooseDate.getScore());
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Header extends RecyclerView.ViewHolder {


        @BindView(R.id.title)
        TextView title;

        public Header(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    public class Body extends RecyclerView.ViewHolder {

        @BindView(R.id.container)
        ViewGroup container;

        @BindView(R.id.position)
        TextView position;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.win)
        TextView win;

        @BindView(R.id.nichya)
        TextView nichya;

        @BindView(R.id.fall)
        TextView fall;

        @BindView(R.id.score)
        TextView score;

        @BindView(R.id.logo)
        AppCompatImageView logo;

        public Body(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
