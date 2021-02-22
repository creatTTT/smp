package com.tu.demo_s_mp.test;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2020/8/11 0011.
 */
public class A {
    /**自定义注解*/
    @Documented
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface MyTestAnnotation {
    }

    /**父类标注自定义注解*/
    @MyTestAnnotation
    public class Father {
    }

    /**子类*/
    public class Son extends Father {
    }

    /**测试子类获取父类自定义注解*/
    public static void main(String[] args){

        //获取Son的class对象
        Class<Son> sonClass = Son.class;
        // 获取Son类上的注解MyTestAnnotation可以执行成功
        MyTestAnnotation annotation = sonClass.getAnnotation(MyTestAnnotation.class);
        System.out.println(annotation);

    }
}
