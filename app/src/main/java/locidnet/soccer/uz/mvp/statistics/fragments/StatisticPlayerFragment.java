package locidnet.soccer.uz.mvp.statistics.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import butterknife.BindView;
import butterknife.OnClick;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.base.Base;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.newsDetail.NewsDetailActivity;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class StatisticPlayerFragment extends BaseFragment {

    private static StatisticPlayerFragment mInstance;



    public static StatisticPlayerFragment getInstance() {
        if (mInstance == null) mInstance = new StatisticPlayerFragment();
        return mInstance;
    }
    public static StatisticPlayerFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new StatisticPlayerFragment();

        mInstance.setArguments(data);

        return mInstance;
    }

    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init() {
        refreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.highlight,R.color.carrot,R.color.pomegranate);
        refreshLayout.setOnRefreshListener(() ->{
            new Handler().postDelayed(() -> {
                refreshLayout.setRefreshing(false);

            },2000);
        });
    }

    @Override
    public String getTitle() {
        return Base.context().getString(R.string.statistics);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
