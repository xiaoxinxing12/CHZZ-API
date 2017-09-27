package org.chzz.api.controller;

import com.jfinal.core.Controller;
import org.chzz.api.common.RouterMapping;
import org.chzz.api.common.RouterNotAllowConvert;
import org.chzz.api.service.MainService;
import org.chzz.core.app.Chzz;
import org.chzz.core.net.CHZZClient;
import org.chzz.core.net.callback.Success;

import java.util.HashMap;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
 * IndexController
 */
public class LoginController extends Controller {
    static MainService service = new MainService();
    public void index() {

//        CHZZClient.builder()
//                .url("router/system/user/getTenantList")
//                .success(new Success() {
//            @Override
//            public void onSuccess(Object entity) {
//
//                System.out.println("After invoking " + entity);
//            }
//        }).build().get();
       // service.save();
        render("login.html");
    }
}



