package locidnet.soccer.uz.mvp.statistics.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.adapter.ChooseAdapter;
import locidnet.soccer.uz.adapter.MatchAdapter;
import locidnet.soccer.uz.adapter.MatchTableAdapter;
import locidnet.soccer.uz.base.Base;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.newsDetail.NewsDetailActivity;
import locidnet.soccer.uz.util.Demo;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class StatisticTableFragment extends BaseFragment {

    private static StatisticTableFragment mInstance;



    public static StatisticTableFragment getInstance() {
        if (mInstance == null) mInstance = new StatisticTableFragment();
        return mInstance;
    }
    public static StatisticTableFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new StatisticTableFragment();

        mInstance.setArguments(data);

        return mInstance;
    }


    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.list)
    RecyclerView list;


    private MatchTableAdapter adapter;
    private LinearLayoutManager manager;
    private boolean pull = false;


    @Override
    protected int getFragmentView() {
        return R.layout.fragment_table;
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
        adapter = new MatchTableAdapter(getActivity(), Demo.tableAdapters);
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
        return Base.context().getString(R.string.table);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
