//package com.guobaoru.design.proxy.dynamic;
//
//import javax.tools.JavaCompiler;
//import javax.tools.StandardJavaFileManager;
//import javax.tools.ToolProvider;
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//import java.net.URL;
//import java.net.URLClassLoader;
//
///**
// * @author Created by guobaoru.
// * @create on 2018/9/19.
// */
//public class GbrFutureTask {
//    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        String rt = "\r\n";
//        String proxy =
//                "package com.guobaoru.design.proxy.dynamic;" + rt +
//
//                        "public class TimeProxy implements Moveable {" + rt +
//
//                        "    Moveable moveable;" + rt +
//
//                        "    public TimeProxy(Moveable moveable) {" + rt +
//                        "        this.moveable = moveable;" + rt +
//                        "    }" + rt +
//
//                        "    @Override" + rt +
//                        "    public void move() {" + rt +
//                        "        long startTime = System.currentTimeMillis();" + rt +
//                        "        System.out.println(\"startTime:\" + startTime);" + rt +
//                        "        moveable.move();" + rt +
//                        "        System.out.println(\"runTime:\" + (System.currentTimeMillis() - startTime));" + rt +
//                        "    }" + rt +
//                        "}";
//        System.out.println("当前项目目录："+System.getProperty("user.dir"));
//        // 项目根路径 + 当前目录
//        String fileName = System.getProperty("user.dir") + "/src/other/java/com/guobaoru/design/proxy/dynamic/TimeProxy.java";
//        File file = new File(fileName);
//        FileWriter fw = new FileWriter(file);
//        fw.write(proxy);
//        fw.flush();
//        fw.close();
//
//        // 获取java编译器
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        System.out.println("java编译器："+compiler.getClass().getName());
//
//        /**
//         * 编译上述生成文件，JDK1.6 提供的API不是很直观，具体操作如下（此教程采用的是jdk1.6做的demo，其他版本没有调研）
//         * 1、获取一个文件管理者
//         * 2、获取一个迭代器
//         * 3、获取一个执行任务器
//         */
//        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
//
//        Iterable units = fileManager.getJavaFileObjects(fileName);
//
//        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, units);
//
//        /**
//         * 编译执行 - compile
//         */
//        task.call();
//        fileManager.close();
//
//        /**
//         * 加载内存并创建实例 - load into memory and create an instance
//         * 这个URL中直接写到src，后面loadClass时为other.java.com.guobaoru.design.proxy.dynamic.TimeProxy,报错ClassNotFoundException
//         * 上面的问题留有疑问
//         */
//        URL[] urls = new URL[]{new URL("file:/" + System.getProperty("user.dir") + "/src/other/java")};
//        URLClassLoader ucl = new URLClassLoader(urls);
//        Class c = ucl.loadClass("com.guobaoru.design.proxy.dynamic.TimeProxy");
//        System.out.println("加载到内存的class：" + c);
//
//        /**
//         * 获取构造器和实例
//         * 运行
//         */
//        Constructor constructor = c.getConstructor(Moveable.class);
//        Moveable moveable = (Moveable) constructor.newInstance(new Tank());
//        moveable.move();
//    }
//}
