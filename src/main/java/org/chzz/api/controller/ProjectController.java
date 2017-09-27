package org.chzz.api.controller;

import com.jfinal.core.Controller;

public class ProjectController extends Controller {
    public void index() {
        render("project.html");
    }
}