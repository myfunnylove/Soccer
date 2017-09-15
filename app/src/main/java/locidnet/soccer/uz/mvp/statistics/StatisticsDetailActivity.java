package locidnet.soccer.uz.mvp.statistics;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;

import java.util.ArrayList;

import butterknife.BindView;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.adapter.MainPagerAdapter;
import locidnet.soccer.uz.base.BaseActivity;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.main.fragment.MatchesFragment;
import locidnet.soccer.uz.mvp.main.fragment.NewsFragment;
import locidnet.soccer.uz.mvp.main.fragment.SettingsFragment;
import locidnet.soccer.uz.mvp.main.fragment.StatisticsFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticLentaFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticPlayerFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticTableFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticsMatchesFragment;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class StatisticsDetailActivity extends BaseActivity {


    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;


    @BindView(R.id.pager)
    ViewPager pager;

    FragmentPagerAdapter mainPagerAdapter;
    ActionBarDrawerToggle toggle;


    @Override
    protected int getLayout() {
        return R.layout.activity_statistics_detail;
    }

    @Override
    protected void init() {
        initActionBar();
        initPager();
        initTablayout();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.news_detail_menu,menu);
        return true;
    }
    private void initActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.statistics));

        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });
    }
    private void initPager() {
        mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(),initFragments());
        pager.setAdapter(mainPagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    private void initTablayout() {
        tabLayout.setupWithViewPager(pager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());
//                navigationView.getMenu().getItem(tab.getPosition()).setChecked(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private ArrayList<BaseFragment> initFragments(){
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        StatisticLentaFragment statisticLentaFragment       = StatisticLentaFragment.getInstance();
        StatisticsMatchesFragment statisticsMatchesFragment = StatisticsMatchesFragment.getInstance();
        StatisticTableFragment statisticTableFragment       = StatisticTableFragment.getInstance();
        StatisticPlayerFragment statisticPlayerFragment     = StatisticPlayerFragment.getInstance();

        fragments.add(statisticLentaFragment);
        fragments.add(statisticTableFragment);
        fragments.add(statisticsMatchesFragment);
        fragments.add(statisticPlayerFragment);

        return fragments;
    }
}
