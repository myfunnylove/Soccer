package locidnet.soccer.uz.mvp.newsDetail;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.widget.LinearLayout;

import butterknife.BindView;
import locidnet.soccer.uz.R;
import locidnet.soccer.uz.base.BaseActivity;
import locidnet.soccer.uz.mvp.comment.CommentActivity;

/**
 * Created by Sarvar on 15.09.2017.
 */

public class NewsDetailActivity extends BaseActivity {



    @BindView(R.id.coordinator)
    CoordinatorLayout coordinatorLayout;

    @BindView(R.id.appbar)
    AppBarLayout appBarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.commentBox)
    LinearLayout commentBox;


    @Override
    protected int getLayout() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void init() {
        initActionBar();
        commentBox.setOnClickListener(view -> {
            startActivity(new Intent(this, CommentActivity.class));
        });
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
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        toolbar.setNavigationOnClickListener(view -> {
            onBackPressed();
        });


    }
}
