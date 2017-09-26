package org.chzz.api.main;

import com.jfinal.core.Controller;

public class ProfileController extends Controller {
    public void index() {
        render("/html/profile.html");
    }
}