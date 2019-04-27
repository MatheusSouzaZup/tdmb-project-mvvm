package br.com.bluedot.moviemvp.view;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import javax.inject.Inject;

import br.com.bluedot.moviemvp.viewmodel.BaseViewModel;
import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel> extends Fragment {

    private T mViewDataBinding;
    private V mViewModel;
    private V mActViewModel;
    private V mPFragViewModel;

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    protected abstract int getFragmentLayout();

    protected abstract Class<V> getViewModelClass();

    public abstract void initBinding();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mViewDataBinding = DataBindingUtil.inflate(inflater, getFragmentLayout(), container, false);

        if (getViewModelClass() != null) {
            mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(getViewModelClass());

            if (getActivity() != null) {
                mActViewModel = ViewModelProviders.of(getActivity(), mViewModelFactory).get(getViewModelClass());
            }

            if (getParentFragment() != null) {
                mPFragViewModel = ViewModelProviders.of(getParentFragment(), mViewModelFactory).get(getViewModelClass());
            }
        }
        initBinding();
        return mViewDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    /**
     * @return A instance of ViewDataBinding with type of given {@link T} inflated with {@link #getFragmentLayout()}
     */
    public T getBinding() {
        return mViewDataBinding;
    }

    protected V getViewModel() {
        return mViewModel;
    }

    protected V getActViewModel() {
        return mActViewModel;
    }

    protected V getParentFragmentViewModel() {
        return mPFragViewModel;
    }
}
