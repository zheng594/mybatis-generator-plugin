package com.mybatis.generator.plugins;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * 生成dao类
 * Created by zheng on 2020/5/12.
 */
public class MapperPlugin extends PluginAdapter {
    private Properties systemPro;

    private String currentDateStr;

    public MapperPlugin() {
        super();
        this.currentDateStr = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
        this.systemPro = System.getProperties();
    }


    @Override
    public boolean validate(List<String> warnings) {
        return true;
    }

    @Override
    public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
        //添加注释
        topLevelClass.addAnnotation("/**");
        StringBuilder sb = new StringBuilder();
        sb.append(" * Created by ");
        sb.append(systemPro.getProperty("user.name"));
        sb.append(" ");
        sb.append(currentDateStr);
        topLevelClass.addAnnotation(sb.toString());
        topLevelClass.addAnnotation(" */");

        if (introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            interfaze.addImportedType(new FullyQualifiedJavaType("org.apache.ibatis.annotations.Mapper"));
            interfaze.addAnnotation("@Mapper");
        }

        return true;
    }
}
