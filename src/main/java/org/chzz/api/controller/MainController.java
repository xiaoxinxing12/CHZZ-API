package org.chzz.api.controller;

import com.jfinal.core.Controller;
import org.chzz.api.service.MainService;

public class MainController extends Controller {
    static MainService service = new MainService();

    public void index() {

        setAttr("projectPage", service.paginate(getParaToInt(0, 1), 10));
        render("main.html");
    }
}