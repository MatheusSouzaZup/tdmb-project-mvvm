package br.com.bluedot.moviemvp.viewmodel;

import javax.inject.Inject;

public class MainViewModel extends BaseViewModel<MainViewModel.Navigator> {

    @Inject
    public MainViewModel() {
    }


    interface Navigator {

    }
}
