package locidnet.soccer.uz.mvp.comment.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.adapter.CommentAdapter;
import locidnet.soccer.uz.base.Base;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.comment.CommentActivity;
import locidnet.soccer.uz.util.Demo;

/**
 * Created by Sarvar on 16.09.2017.
 */

public class NewCommentsFragment extends BaseFragment {


    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.list)
    RecyclerView list;


    private CommentAdapter adapter;
    private LinearLayoutManager manager;
    private boolean pull = false;
    private static NewCommentsFragment mInstance;


    public static NewCommentsFragment getInstance() {
        if (mInstance == null) mInstance = new NewCommentsFragment();
        return mInstance;
    }
    public static NewCommentsFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new NewCommentsFragment();

        mInstance.setArguments(data);

        return mInstance;
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_comment;
    }

    @Override
    protected void init() {

        manager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(manager);
        list.setHasFixedSize(true);




        list.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (manager.findFirstVisibleItemPosition() == 0){
                    refreshLayout.setEnabled(true);
                }else{
                    refreshLayout.setEnabled(false);
                }
            }
        });
        adapter = new CommentAdapter(getActivity(), Demo.comments);
        list.setAdapter(adapter);



        refreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.highlight,R.color.carrot,R.color.pomegranate);
        refreshLayout.setOnRefreshListener(() ->{
            new Handler().postDelayed(() -> {
                refreshLayout.setRefreshing(false);

            },2000);
        });
    }

    @Override
    public String getTitle() {
        return Base.context().getString(R.string.newComment);
    }
}
