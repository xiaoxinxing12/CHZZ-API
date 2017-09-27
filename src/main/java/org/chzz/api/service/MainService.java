package org.chzz.api.service;


import com.jfinal.plugin.activerecord.Page;
import org.chzz.api.model.ProjectEntity;

public class MainService {

    private static final ProjectEntity dao = new ProjectEntity().dao();

    public Page<ProjectEntity> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from eo_project order by projectID asc");
    }


    public boolean save() {

        return new ProjectEntity().set("projectName", "test").set("projectType",0).save();
    }

}
