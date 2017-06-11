package DesignPattern.CreatorPattern.Singleton;

/**
 * Created by jdan on 2017/6/11.
 * 主要解决：一个全局使用的类频繁地创建与销毁。
 * 意图：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 如何解决：判断系统是否已经有这个单例，如果有则返回，如果没有则创建。
 * 关键代码：构造函数是私有的。
 * 场景：1.唯一 2.耗时操作
 * 注意事项：getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。
 * 单例模式的几种实现方式:
 * 1、懒汉式，线程不安全
 * 2、懒汉式，线程安全
 * 3、饿汉式
 * 4、双检锁/双重校验锁（DCL，即 double-checked locking）
 * 5、登记式/静态内部类
 * 6、枚举
 */
public class Pattern {
    public static void main(String[] args) {
        SingleObject object = SingleObject.getInstance();
        object.print();
    }
}

class SingleObject {
    private SingleObject() {
    }
    private static SingleObject object = new SingleObject();

    public static SingleObject getInstance() {
        return object;
    }

    public void print() {
        System.out.println("hello world");
    }
}


/*
1、懒汉式，线程不安全
    是否 Lazy 初始化：是
    是否多线程安全：否
    实现难度：易
public class Singleton {
    private static Singleton instance;
    private Singleton (){}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

2、懒汉式，线程安全
    是否 Lazy 初始化：是
        是否多线程安全：是
        实现难度：易

public class Singleton {
    private static Singleton instance;
    private Singleton (){}
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

3、饿汉式
    是否 Lazy 初始化：否
    是否多线程安全：是
    实现难度：易

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton (){}
    public static Singleton getInstance() {
        return instance;
    }
}

4、双检锁/双重校验锁（DCL，即 double-checked locking）
    JDK 版本：JDK1.5 起
    是否 Lazy 初始化：是
    是否多线程安全：是
    实现难度：较复杂

public class Singleton {
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

5、登记式/静态内部类
    是否 Lazy 初始化：是
    是否多线程安全：是
    实现难度：一般
public class Singleton {
    private Singleton(){}
    public static class SingletonHolder {
        private static final Singleton INSTANCE  = new Singleton();
    }
    public Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}*/
