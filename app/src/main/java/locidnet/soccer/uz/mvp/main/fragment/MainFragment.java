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

/**
 * Created by Sarvar on 15.09.2017.
 */

public class MainFragment extends BaseFragment {

    private static MainFragment mInstance;



    public static MainFragment getInstance() {
        if (mInstance == null) mInstance = new MainFragment();
        return mInstance;
    }
    public static MainFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new MainFragment();

        mInstance.setArguments(data);

        return mInstance;
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_news;
    }

    @Override
    protected void init() {

    }

    @Override
    public String getTitle() {
        return Base.context().getString(R.string.main);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



}
