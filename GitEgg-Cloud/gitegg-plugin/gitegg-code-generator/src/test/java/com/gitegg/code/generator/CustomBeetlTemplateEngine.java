package com.gitegg.code.generator;

import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine;
import com.baomidou.mybatisplus.generator.engine.BeetlTemplateEngine;
import com.baomidou.mybatisplus.generator.util.FileUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * @Desc: Beetl模版引擎 自定义模版生成引擎
 * @Author sxy
 * @Date 2022/2/28
 **/
public class CustomBeetlTemplateEngine {


    public void outputCustomFile(File file,  Map<String, Object> objectMap, String templatePath){
        try {
            // 全局判断【默认】
            boolean exist = file.exists();
            if (!exist) {
                File parentFile = file.getParentFile();
                FileUtils.forceMkdir(parentFile);
            }
            writer(objectMap, templatePath, file);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void writer( Map<String, Object> objectMap,  String templatePath, File outputFile) throws Exception {
        // Template template = (Template) method.invoke(groupTemplate, templatePath);
        ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("/");
        Configuration cfg = Configuration.defaultConfiguration();
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template template = gt.getTemplate(templatePath);
        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            template.binding(objectMap);
            template.renderTo(fileOutputStream);
        }
    }

    // /**
    //  * @Author sxy
    //  * @Description 自定义输出自定义模板文件
    //  * @Param [customFile 自定义模板文件，key为文件名称，value为模板路径,
    //  *          tableInfo 表信息,
    //  *          objectMap 渲染数据]
    //  * @return void
    //  * @Date 2022/2/28 16:17
    //  **/
    // @Override
    // protected void outputCustomFile(Map<String, String> customFile, TableInfo tableInfo, Map<String, Object> objectMap) {
    //
    //     Map<String, String> customFilePath = (Map<String, String>)objectMap.get("customFilePathMap");
    //     customFile.forEach((key, value) -> {
    //         String otherPath = customFilePath.get(key);
    //         String fileName = String.format((otherPath + File.separator + "%s"), key);
    //         outputFile(new File(fileName), objectMap, value);
    //     });
    // }
}
