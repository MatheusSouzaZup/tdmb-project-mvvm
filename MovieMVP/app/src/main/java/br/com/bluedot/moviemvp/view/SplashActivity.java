package br.com.bluedot.moviemvp.view;

import android.content.Intent;
import android.os.Handler;


import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.ActivitySplashBinding;
import br.com.bluedot.moviemvp.viewmodel.MainViewModel;

public class SplashActivity extends BaseActivity<ActivitySplashBinding, MainViewModel> {
    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected Class<MainViewModel> getViewModelClass() {
        return MainViewModel.class;
    }

    @Override
    public void init() {
        new Handler().postDelayed(() -> startActivity(new Intent(this, MainActivity.class)), 3000);

    }
}
