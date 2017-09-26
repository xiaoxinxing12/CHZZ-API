package org.chzz.api.main;

import com.jfinal.core.Controller;

public class MainController extends Controller {
    public void index() {
        render("/html/main.html");
    }
}