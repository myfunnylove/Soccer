package locidnet.soccer.uz.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
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
import locidnet.soccer.uz.model.News;
import locidnet.soccer.uz.mvp.newsDetail.NewsDetailActivity;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context ctx;
    private ArrayList<News> list;
    private LayoutInflater inflater;

    private final int HEADER = 1;
    private final int BODY = 2;
    private Drawable nothot,hot;

    public NewsAdapter(Context ctx, ArrayList<News> list) {
        this.ctx = ctx;
        this.list = list;
        nothot = VectorDrawableCompat.create(ctx.getResources(),R.drawable.highlight_icon_comment,ctx.getTheme());
        hot = VectorDrawableCompat.create(ctx.getResources(),R.drawable.highlight_dark_icon_comment,ctx.getTheme());
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getItemViewType(int position) {

        if (position == 0 || position % 5 == 0)
            return HEADER;
        else
            return BODY;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == HEADER){
            return new Header(inflater.inflate(R.layout.item_news_header,parent,false));
        }else{
            return new Body(inflater.inflate(R.layout.item_news_body,parent,false));

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        Log.d("position",position+"");
        News news = list.get(position);
        if (getItemViewType(position) == HEADER){
            Header header = (Header) holder;
            header.title.setText(news.getDate());
            header.container.setOnClickListener((view) -> {

            });
        }else if (getItemViewType(position) == BODY){
            Body body = (Body) holder;
            body.title.setText(news.getTitle());
            body.container.setOnClickListener((view) -> {
                ctx.startActivity(new Intent(ctx, NewsDetailActivity.class));
            });
            body.comment.setText(news.getCommentCount());
            body.time.setText(news.getDate());

            if (news.isHot()) body.hot.setImageDrawable(hot);
            else body.hot.setImageDrawable(nothot);

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
        CardView container;

        @BindView(R.id.title)
        TextView title;

        @BindView(R.id.comment)
        TextView comment;

        @BindView(R.id.time)
        TextView time;


        @BindView(R.id.hot)
        AppCompatImageView hot;

        public Body(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }


}
