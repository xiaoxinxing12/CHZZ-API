package org.chzz.core.net.callback;

import org.chzz.core.app.Chzz;
import org.chzz.core.util.GSONTools;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by copy on 2017/8/6.
 * Description:
 * User: copy
 * Date: 2017-08-06
 * Time: 下午3:30
 */
public class RequestCallback implements Callback<String> {

    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;


    public RequestCallback(IRequest request, ISuccess success, IFailure failure, IError error) {
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;

    }


    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    try {
                        if (null == SUCCESS.getEntity()) {
                            SUCCESS.onSuccess(response.body());
                        } else {
                            SUCCESS.onSuccess(GSONTools.jsonToBean(response.body(), SUCCESS.getEntity().getClass()));
                        }
                    } catch (Exception e) {

                    }

                } else {

                }

            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd(response.code(), response.message());
        }

    }

    @Override
    public void onFailure(Call<String> call, Throwable t) {

        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd(-200, t.getLocalizedMessage());
        }
    }

}
