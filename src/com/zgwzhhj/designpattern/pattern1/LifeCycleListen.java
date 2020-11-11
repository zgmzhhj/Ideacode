package com.zgwzhhj.designpattern.pattern1;

/**
 * 监听者接口
 */
public interface LifeCycleListen {
    //监听方法，监听RunnableEvent对象
    void onEvent(ObservableRunnable.RunnableEvent event);
}
