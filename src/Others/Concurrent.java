package Others;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Concurrent {

    public static void main(String[] args) {

        Hashtable<Integer, String> hashtable = new Hashtable<>();
        HashMap<Integer,String> hashMap = new HashMap<>();

        ConcurrentHashMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("test1",1);
        concurrentHashMap.put("test2",2);
        concurrentHashMap.put("test3",3);

        Set set = concurrentHashMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            concurrentHashMap.put("下次循环正常执行", 4);
        }
        System.out.println("程序结束");
    }
 }
