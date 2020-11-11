package com.zgwzhhj.designpattern.pattern1;

/**
 * Listen模式
 */
public class ObservableRunnable implements Runnable {
    //监听器
    protected LifeCycleListen listener;

    public ObservableRunnable(final LifeCycleListen lifeCycleListen) {
        this.listener = lifeCycleListen;
    }

    //通知修改
    protected void notifyChange(RunnableEvent event) {
        listener.onEvent(event);
    }

    //枚举线程状态
    public enum RunnableState {
        RUNNING, ERROR, DONE;
    }

    @Override
    public void run() {

    }

    /**
     * 这是监听事件的事件源，用来实现事件对象
     */
    public static class RunnableEvent {
        //线程运行状态
        private final RunnableState state;
        //线程
        private final Thread thread;
        //失败原因
        private final Throwable cause;

        //事件的构造方法，提供线程的状态，标志，失败原因
        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        //获取当前线程状态
        public RunnableState getState() {
            return state;
        }

        //获取当前线程标志
        public Thread getThread() {
            return thread;
        }

        //获取失败原因
        public Throwable getCause() {
            return cause;
        }
    }
}
