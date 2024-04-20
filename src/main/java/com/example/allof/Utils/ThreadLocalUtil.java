package com.example.allof.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal 工具类
 */
@SuppressWarnings("all")
public class ThreadLocalUtil {
    // 声明一个静态的ThreadLocal变量。这个变量会为每个线程维护一个独立的变量副本。
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    // 提供一个泛型方法，用于从ThreadLocal中获取当前线程的变量值。返回类型为泛型T。
    public static <T> T get(){
        return (T) THREAD_LOCAL.get(); // 返回当前线程所存储的对象，需要进行类型转换。
    }

    // 接受一个对象并将其作为当前线程的局部变量存储在ThreadLocal中。
    public static void set(Object value){
        THREAD_LOCAL.set(value); // 将传入的value值设置为当前线程的局部变量。
    }

    // 清除ThreadLocal中存储的当前线程的局部变量。
    public static void remove(){
        THREAD_LOCAL.remove(); // 移除当前线程的局部变量，这是一个重要步骤，用于防止内存泄漏。
    }
}
