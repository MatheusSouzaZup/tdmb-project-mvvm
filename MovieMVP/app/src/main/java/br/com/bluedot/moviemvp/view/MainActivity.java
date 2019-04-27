package br.com.bluedot.moviemvp.view;

import android.support.v4.app.Fragment;

import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.ActivityMainBinding;
import br.com.bluedot.moviemvp.view.feed.FeedFragment;
import br.com.bluedot.moviemvp.viewmodel.MainViewModel;


public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    public void init() {
        getBinding().bnvMain.setOnNavigationItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()) {
                case R.id.menu_feed:
                    replaceFragment(new FeedFragment());
                    return true;
                case R.id.menu_search:
                    return true;

                case R.id.menu_favorites:
                    return true;
            }
            return false;
        });
        getBinding().bnvMain.setSelectedItemId(R.id.menu_feed);
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.short_fade_in, R.anim.short_fade_out)
                .replace(R.id.container, fragment)
                .commit();
    }
}
