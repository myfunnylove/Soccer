package locidnet.soccer.uz.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;

import locidnet.soccer.uz.base.BaseFragment;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {


    ArrayList<BaseFragment> fragments;

    public MainPagerAdapter(FragmentManager fm, ArrayList<BaseFragment> baseFragments) {
        super(fm);
        fragments = baseFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
