package com.zgwzhhj.designpattern.pattern1;

import java.util.List;

/**
 * 监听者具体实现
 */
public class ThreadLifeCycleObserver implements LifeCycleListen {
    //定义一个锁
    private static final Object LOCK = new Object();

    //同步监听方法
    public void concurrentQuery(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        //为list每一个元素创建一个线程查询
        list.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    //设置事件状态，通知listener监听
                    notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                    System.out.println("Query for the id " + id);
                    Thread.sleep(1000);
                    //工作完成并设置事件状态
                    notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                } catch (Exception e) {
                    notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), null));
                }
            }
        }, id).start());

    }

    //监听RunnableEvent对象是否改变
    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK) {
            System.out.println("the Runnable [" + event.getThread().getName() + "] data change and state is :" + event.getState());
            if (event.getCause() != null) {
                System.out.println("the runnable [" + event.getThread().getName() + "] process failed");
                event.getCause().printStackTrace();
            }
        }
    }
}
