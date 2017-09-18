package locidnet.soccer.uz.mvp.comment;

import android.support.annotation.BinderThread;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import butterknife.BindView;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.adapter.MainPagerAdapter;
import locidnet.soccer.uz.base.BaseActivity;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.mvp.comment.fragment.NewCommentsFragment;
import locidnet.soccer.uz.mvp.comment.fragment.PopCommentsFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticLentaFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticPlayerFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticTableFragment;
import locidnet.soccer.uz.mvp.statistics.fragments.StatisticsMatchesFragment;

/**
 * Created by Sarvar on 16.09.2017.
 */

public class CommentActivity extends BaseActivity {


    public static final int NEW_COMMENTS = R.string.newComment;
    public static final int POPULAR_COMMENTS = R.string.popularComment;
    public static final String COMMENT_TYPE = "commentType";
    FragmentPagerAdapter mainPagerAdapter;

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


    @BindView(R.id.edit)
    FloatingActionButton editFAB;


    @Override
    protected int getLayout() {
        return R.layout.activity_comment;
    }

    @Override
    protected void init() {
        initActionBar();
        initPager();
        initTablayout();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.comments));

        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });

        editFAB.setImageDrawable(VectorDrawableCompat.create(getResources(),R.drawable.white_icon_edit,this.getTheme()));
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
        NewCommentsFragment newCommentsFragment       = NewCommentsFragment.getInstance();
        PopCommentsFragment popCommentsFragment       = PopCommentsFragment.getInstance();

        fragments.add(newCommentsFragment);
        fragments.add(popCommentsFragment);

        return fragments;
    }
}
