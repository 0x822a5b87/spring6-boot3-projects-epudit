package com.linkedbear.spring.lifecycle.d_prototype;

import com.linkedbear.spring.lifecycle.d_prototype.bean.Pen;
import com.linkedbear.spring.lifecycle.d_prototype.config.PrototypeLifecycleConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PrototypeLifecycleAnnoWithoutGetApplication {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
                PrototypeLifecycleConfiguration.class);
        System.out.println("IOC容器初始化完成。。。");
        Pen pen = ctx.getBean(Pen.class);
        ctx.getBeanFactory().destroyBean(pen);
        ctx.close();
        System.out.println("IOC容器销毁完成。。。");

    }
}
