package locidnet.soccer.uz.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Sarvar on 15.09.2017.
 */

public abstract class BaseFragment extends Fragment {

    protected View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(getFragmentView(),container,false);
        ButterKnife.bind(this,rootView);
        init();

        return rootView;
    }


    protected abstract int getFragmentView();
    protected abstract void init();
    public abstract String getTitle();

}
