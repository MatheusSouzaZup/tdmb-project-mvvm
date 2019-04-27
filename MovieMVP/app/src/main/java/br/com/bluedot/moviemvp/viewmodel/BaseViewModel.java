package br.com.bluedot.moviemvp.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.util.Log;


public class BaseViewModel<N> extends ViewModel {

    public ObservableBoolean showLoading = new ObservableBoolean(false);

    private N mNavigator;

    public N getNavigator() {
        if (mNavigator == null)
            Log.e("VM_NAVIGATOR_ERROR", "You need to set the navigator first!");
        return mNavigator;
    }

    public void setNavigator(N mNavigator) {
        this.mNavigator = mNavigator;
    }

    public void showLoading() {
        showLoading.set(true);
    }

    public void hideLoading() {
        showLoading.set(false);
    }
}
