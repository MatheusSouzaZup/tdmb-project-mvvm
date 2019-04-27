package br.com.bluedot.moviemvp.view.search;

import br.com.bluedot.moviemvp.R;
import br.com.bluedot.moviemvp.databinding.FragmentSearchBinding;
import br.com.bluedot.moviemvp.view.BaseFragment;
import br.com.bluedot.moviemvp.viewmodel.SearchViewModel;

public class SearchFragment extends BaseFragment<FragmentSearchBinding, SearchViewModel> {

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_search;
    }

    @Override
    protected Class<SearchViewModel> getViewModelClass() {
        return SearchViewModel.class;
    }

    @Override
    public void initBinding() {

    }
}
