package br.com.bluedot.moviemvp.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


import javax.inject.Inject;

import br.com.bluedot.moviemvp.viewmodel.BaseViewModel;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel> extends AppCompatActivity implements HasSupportFragmentInjector {

    private static final int PERMISSIONS_REQUEST_CODE = 10001;
    private RequestListener mRequestCallback;

    private T mViewDataBinding;
    private V mViewModel;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    protected abstract int getContentLayoutId();

    protected abstract Class<V> getViewModelClass();

    public abstract void init();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);

        mViewDataBinding = DataBindingUtil.setContentView(this, getContentLayoutId());

        if (getViewModelClass() != null)
            mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(getViewModelClass());

        init();
    }

    protected T getBinding() {
        return mViewDataBinding;
    }

    public V getViewModel() {
        return mViewModel;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }

    /**
     * @param permission Need Manifest.permission
     * @return true if permission is granted, false otherwise
     */
    public boolean verifyPermission(String permission) {
        return ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;

//        return PermissionChecker.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    /**
     * @param permissions Permissions to request
     * @param callback    @RequestListener to provide callback for request
     */
    public void requestPermissions(String[] permissions, RequestListener callback) {
        this.mRequestCallback = callback;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            requestPermissions(permissions, PERMISSIONS_REQUEST_CODE);
//        } else {
            ActivityCompat.requestPermissions(this, permissions, PERMISSIONS_REQUEST_CODE);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    mRequestCallback.onRequestCallback(grantResults, false);

                } else {
                    boolean neverAskAgainSelected = false;
                    for (int i = 0; i < grantResults.length; i++) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            //check if user select "never ask again" when denying any permission
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                if (!shouldShowRequestPermissionRationale(permissions[i])) {
                                    neverAskAgainSelected = true;
                                }
                            }
                        }
                    }

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    mRequestCallback.onRequestCallback(grantResults, neverAskAgainSelected);
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public interface RequestListener {
        void onRequestCallback(int[] grantResults, boolean neverAskAgainSelected);
    }
}
