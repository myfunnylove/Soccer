package locidnet.soccer.uz.mvp.main.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import locidnet.soccer.uz.R;
import locidnet.soccer.uz.base.Base;
import locidnet.soccer.uz.base.BaseFragment;


/**
 * Created by Sarvar on 15.09.2017.
 */

public class SettingsFragment extends BaseFragment {

    private static SettingsFragment mInstance;



    public static SettingsFragment getInstance() {
        if (mInstance == null) mInstance = new SettingsFragment();
        return mInstance;
    }
    public static SettingsFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new SettingsFragment();

        mInstance.setArguments(data);

        return mInstance;
    }

    @Override
    protected int getFragmentView() {
        return R.layout.fragment_settings;
    }

    @Override
    protected void init() {

    }

    @Override
    public String getTitle() {
        return Base.context().getString(R.string.settings);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
