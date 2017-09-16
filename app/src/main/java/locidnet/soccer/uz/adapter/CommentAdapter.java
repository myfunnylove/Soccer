package locidnet.soccer.uz.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.model.Comment;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.Holder> {
    private Context ctx;
    private ArrayList<Comment> list;
    private LayoutInflater inflater;

    public CommentAdapter(Context ctx, ArrayList<Comment> list) {
        this.ctx = ctx;
        this.list = list;
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(inflater.inflate(R.layout.item_comment_box,parent,false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Comment chooseDate = list.get(position);

        holder.name.setText(chooseDate.getName());
        holder.time.setText(chooseDate.getTime());
        if (Integer.valueOf(chooseDate.getCommentScore()) > 0)  holder.commentScore.setTextColor(ctx.getResources().getColor(R.color.colorAccent));
        else if (Integer.valueOf(chooseDate.getCommentScore()) == 0)  holder.commentScore.setTextColor(ctx.getResources().getColor(R.color.lightText));
        else   holder.commentScore.setTextColor(ctx.getResources().getColor(R.color.material_red_500));

        holder.commentScore.setText(chooseDate.getCommentScore());
        holder.commentText.setText(chooseDate.getCommentText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        TextView name;


        @BindView(R.id.time)
        TextView time;


        @BindView(R.id.commentText)
        TextView commentText;


        @BindView(R.id.commentScore)
        TextView commentScore;

        @BindView(R.id.reply)
        AppCompatImageView reply;

        @BindView(R.id.logo)
        AppCompatImageView logo;


        @BindView(R.id.like)
        AppCompatImageView like;

        @BindView(R.id.dislike)
        AppCompatImageView dislike;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }


}
