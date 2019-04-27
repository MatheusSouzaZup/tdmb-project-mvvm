package br.com.bluedot.moviemvp.service;


import java.io.IOException;

import br.com.bluedot.moviemvp.MyApplication;
import br.com.bluedot.moviemvp.R;


class NoConnectionException extends IOException {

    @Override
    public String getMessage() {
        return MyApplication.getInstance().getString(R.string.app_name); // FIXME
    }
}
