package locidnet.soccer.uz.mvp.main.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import butterknife.OnClick;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.base.Base;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.newsDetail.NewsDetailActivity;
import locidnet.soccer.uz.mvp.statistics.StatisticsDetailActivity;


/**
 * Created by Sarvar on 15.09.2017.
 */

public class StatisticsFragment extends BaseFragment {

    private static StatisticsFragment mInstance;



    public static StatisticsFragment getInstance() {
        if (mInstance == null) mInstance = new StatisticsFragment();
        return mInstance;
    }
    public static StatisticsFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new StatisticsFragment();

        mInstance.setArguments(data);

        return mInstance;
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_statistics;
    }

    @Override
    protected void init() {

    }

    @Override
    public String getTitle() {
        return Base.context().getString(R.string.statistics);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    @OnClick(R.id.container)
    public void click(View view){
        startActivity(new Intent(getActivity(), StatisticsDetailActivity.class));
    }

}
