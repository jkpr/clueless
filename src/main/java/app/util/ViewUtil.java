package app.util;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.Map;

/**
 * Created by james on 11/25/16.
 */
public class ViewUtil {
    private static FreeMarkerEngine freeMarkerEngine;

    public static void initializeFreeMarker() {
        freeMarkerEngine = new FreeMarkerEngine();
        Configuration cfg = new Configuration();
        cfg.setDefaultEncoding("UTF-8");
        ClassTemplateLoader ctl = new ClassTemplateLoader(ViewUtil.class, Path.Template.DIR);
        cfg.setTemplateLoader(ctl);
        freeMarkerEngine.setConfiguration(cfg);
    }

    private static FreeMarkerEngine getFreeMarkerEngine() {
        if (freeMarkerEngine == null) {
            initializeFreeMarker();
        }
        return freeMarkerEngine;
    }

    public static String render(Map<String, Object> model, String templatePath) {
        FreeMarkerEngine engine = getFreeMarkerEngine();
        ModelAndView mav = new ModelAndView(model, templatePath);
        return engine.render(mav);
    }
}
