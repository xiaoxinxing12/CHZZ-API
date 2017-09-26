package org.chzz.api.blog;

import com.baidu.aip.face.AipFace;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import org.chzz.api.common.model.Blog;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
 * BlogController
 * 所有 sql 与业务逻辑写在 Model 或 Service 中，不要写在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Before(BlogInterceptor.class)
public class BlogController extends Controller {
    public static final String APP_ID = "10184473";
    public static final String API_KEY = "hNbi1VohBAxfKB2wvi9zizcG";
    public static final String SECRET_KEY = "A2CwkkLQcecZlITsLlfjWV6mFGX6UayL";
    static BlogService service = new BlogService();

    public void index() {
        setAttr("blogPage", service.paginate(getParaToInt(0, 1), 10));
        render("blog.html");
    }

    public void add() {


    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void save() {
        getModel(Blog.class).save();
        redirect("/blog");

    }

    public void edit() {
        setAttr("blog", service.findById(getParaToInt()));
    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 serivce 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void update() {
        getModel(Blog.class).update();
        redirect("/blog");
    }

    public void delete() {
        service.deleteById(getParaToInt());
        redirect("/blog");
    }

    public void testJson() {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        // 调用接口
        String path = "/Users/copy/Desktop/1.png";
        HashMap<String, String> options = new HashMap<String, String>();
        JSONObject res = client.addUser("uid1", "test_user_info", Arrays.asList("group1", "group2"), path, options);
        System.out.println(res.toString(2));
    }

    public void findJson() {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 参数为本地图片路径
        String imagePath1 = "/Users/copy/Desktop/t3.png";
        String imagePath2 = "/Users/copy/Desktop/t4.png";
        ArrayList<String> pathArray = new ArrayList<String>();
        pathArray.add(imagePath1);
        pathArray.add(imagePath2);
        JSONObject response = client.match(pathArray, new HashMap<String, String>());
        System.out.println(response.toString());
        renderJson(response.toString());
    }
}


