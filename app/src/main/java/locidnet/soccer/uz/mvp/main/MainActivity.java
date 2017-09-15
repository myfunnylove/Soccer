package locidnet.soccer.uz.mvp.main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;


import java.util.ArrayList;

import butterknife.BindView;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.adapter.MainPagerAdapter;
import locidnet.soccer.uz.base.BaseActivity;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.main.fragment.MainFragment;
import locidnet.soccer.uz.mvp.main.fragment.MatchesFragment;
import locidnet.soccer.uz.mvp.main.fragment.NewsFragment;
import locidnet.soccer.uz.mvp.main.fragment.SettingsFragment;
import locidnet.soccer.uz.mvp.main.fragment.StatisticsFragment;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class MainActivity extends BaseActivity {

    @BindView(R.id.drawer)
    DrawerLayout drawerLayout;

    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    @BindView(R.id.navigation)
    NavigationView navigationView;


    @BindView(R.id.pager)
    ViewPager pager;

    FragmentPagerAdapter mainPagerAdapter;
    ActionBarDrawerToggle toggle;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {

        initActionBar();
        initDrawer();
        initPager();
        initTablayout();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
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
        tabLayout.getTabAt(0).setIcon(R.drawable.style_select_news);
        tabLayout.getTabAt(1).setIcon(R.drawable.style_select_soccer);
        tabLayout.getTabAt(2).setIcon(R.drawable.style_select_analize);
        tabLayout.getTabAt(3).setIcon(R.drawable.style_select_settings);
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


    private void initActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        toolbar.setNavigationOnClickListener(view -> {
            drawerLayout.openDrawer(Gravity.LEFT);
        });
    }

    private void initDrawer() {
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        navigationView.setNavigationItemSelectedListener((item) -> {
            drawerLayout.closeDrawers();
            return true;
        });

    }
    private ArrayList<BaseFragment> initFragments(){
        ArrayList<BaseFragment> fragments = new ArrayList<>();
        NewsFragment newsFragment = NewsFragment.getInstance();
        MatchesFragment matchesFragment = MatchesFragment.getInstance();
        StatisticsFragment statisticsFragment = StatisticsFragment.getInstance();
        SettingsFragment settingsFragment = SettingsFragment.getInstance();

        fragments.add(newsFragment);
        fragments.add(matchesFragment);
        fragments.add(statisticsFragment);
        fragments.add(settingsFragment);

        return fragments;
    }
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.LEFT)) {
            drawerLayout.closeDrawer(Gravity.LEFT);
        } else {
                super.onBackPressed();
        }
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


        toggle.onConfigurationChanged(newConfig);
    }
}
