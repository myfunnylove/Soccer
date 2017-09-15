package locidnet.soccer.uz.adapter;

import android.content.Context;
import android.support.graphics.drawable.VectorDrawableCompat;
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
import locidnet.soccer.uz.model.Match;
import locidnet.soccer.uz.model.News;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class MatchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context ctx;
    private ArrayList<Match> list;
    private LayoutInflater inflater;


    private final int HEADER = 1;
    private final int BODY = 2;

    private String leauge = "";


    public MatchAdapter(Context ctx, ArrayList<Match> list) {
        this.ctx = ctx;
        this.list = list;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("tengmi",position+""+leauge+""+list.get(position).getLeague());
        if (position != 0 && position != 8){
            return BODY;
        }else{
            leauge = list.get(position).getLeague();
            return HEADER;

        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER){
            return new Header(inflater.inflate(R.layout.item_match_header,parent,false));
        }else{
            return new Body(inflater.inflate(R.layout.item_match_body,parent,false));

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Match match = list.get(position);

        if (getItemViewType(position) == HEADER){
            Header header = (Header) holder;
            header.container.setOnClickListener(view ->{

            });
            header.title.setText(leauge);
        }else{
            Body body = (Body) holder;
            body.guestName.setText(match.getGuestName());
            body.guestSchet.setText(match.getGuestSchet());
            body.time.setText(match.getDatetime());
            body.hostName.setText(match.getHostName());
            body.hostSchet.setText(match.getHostSchet());
            body.container.setOnClickListener(view ->{

            });

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Header extends RecyclerView.ViewHolder {
        @BindView(R.id.container)
        ViewGroup container;

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

        @BindView(R.id.hostName)
        TextView hostName;

        @BindView(R.id.hostSchet)
        TextView hostSchet;

        @BindView(R.id.guestName)
        TextView guestName;

        @BindView(R.id.guestSchet)
        TextView guestSchet;

        @BindView(R.id.time)
        TextView time;

        public Body(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
