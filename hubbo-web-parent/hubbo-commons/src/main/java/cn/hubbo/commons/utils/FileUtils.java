/*
 * @formatter:off
 * Copyright (c) 张晓华
 * @author 张晓华
 * 创建时间: 2025.4.27.10.53
 * 更新时间: 2025/4/15 23:00
 * 限定类名: cn.hubbo.commons.utils.FileUtils
 * 适度编码益脑，沉迷编码伤身，合理安排时间，享受快乐生活。
 * @formatter:on
 */

package cn.hubbo.commons.utils;

import java.io.File;
import java.nio.file.Paths;

public interface FileUtils {

    /**
     * 通过类加载器获取当前工作目录的根目录 如 当前的类加载路径是 E:\coding\workspace\java\web-template\hubbo-web-parent\target\classes
     * 可以得到E:\coding\workspace\java\web-template\hubbo-web-parent源码根目录
     * 
     * @return 路径
     */
    static String getModuleParentPath() {
        var path =
            Paths.get(new File(ClassLoader.getSystemResource("./").getPath()).getParent()).getParent().getParent();
        return path.toString();
    }

}
