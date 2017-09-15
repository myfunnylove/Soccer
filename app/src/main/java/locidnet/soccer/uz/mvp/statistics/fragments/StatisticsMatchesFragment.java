package locidnet.soccer.uz.mvp.statistics.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.adapter.ChooseAdapter;
import locidnet.soccer.uz.adapter.MatchAdapter;
import locidnet.soccer.uz.base.Base;
import locidnet.soccer.uz.base.BaseFragment;
import locidnet.soccer.uz.util.Demo;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class StatisticsMatchesFragment extends BaseFragment {

    private static StatisticsMatchesFragment mInstance;



    public static StatisticsMatchesFragment getInstance() {
        if (mInstance == null) mInstance = new StatisticsMatchesFragment();
        return mInstance;
    }
    public static StatisticsMatchesFragment getInstance(Bundle data) {
        if (mInstance == null) mInstance = new StatisticsMatchesFragment();

        mInstance.setArguments(data);

        return mInstance;
    }




    @BindView(R.id.refreshLayout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.list)
    RecyclerView list;

    @BindView(R.id.listChoose)
    RecyclerView listChoose;

    private MatchAdapter adapter;
    private ChooseAdapter chooseAdapter;
    private LinearLayoutManager manager,chooseManager;
    private boolean pull = false;


    @Override
    protected int getFragmentView() {
        return R.layout.fragment_match;
    }

    @Override
    protected void init() {
        manager = new LinearLayoutManager(getActivity());
        list.setLayoutManager(manager);
        list.setHasFixedSize(true);

        chooseManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        listChoose.setLayoutManager(chooseManager);
        listChoose.setHasFixedSize(true);



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
        adapter = new MatchAdapter(getActivity(), Demo.matches);
        list.setAdapter(adapter);

        chooseAdapter = new ChooseAdapter(getActivity(),Demo.choose);
        listChoose.setAdapter(chooseAdapter);

        refreshLayout.setColorSchemeResources(R.color.colorAccent,R.color.highlight,R.color.carrot,R.color.pomegranate);
        refreshLayout.setOnRefreshListener(() ->{
            new Handler().postDelayed(() -> {
                refreshLayout.setRefreshing(false);

            },2000);
        });
    }

    @Override
    public String getTitle() {
        return Base.context().getString(R.string.matches);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}
