/**
 * 
 * Copyright (C)2016 LianTuoTianJi Co.,Ltd. All rights reserved.
 *
 */

package com.threads.utils;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

/**
 * @author tom
 * 
 */
public class DefaultVelocityConfigurer extends VelocityConfigurer {

    public void setResourceLoaderPath(String resourceLoaderPath) {
        String str = resourceLoaderPath;
        int index = str.indexOf("${project.root}");
        int len = "${project.root}".length();
        if (index != -1) {
            str = str.substring(index + len);
        }
        super.setResourceLoaderPath(str);
    }

    public void setConfigLocation(Resource configLocation) {
        try {
            int len = "${project.root}".length();
            Resource resourse = null;
            File file = configLocation.getFile();
            String path = file.getPath();
            if (path.indexOf("${project.root}") != -1) {//
                int index = path.indexOf("${project.root}");
                resourse = new FileSystemResource(path.substring(0, index) + path.substring(index + len));
                super.setConfigLocation(resourse);
            } else {
                super.setConfigLocation(configLocation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
