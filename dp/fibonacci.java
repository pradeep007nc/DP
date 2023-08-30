package dp;

import java.util.Map;

public class fibonacci {
    public long fib(long n, Map<Long, Long> map){
        if(map.containsKey(n)) return map.get(n);
        if(n <= 2) return 1;
        map.put(n, fib(n-1, map)+fib(n-2, map));
        return map.get(n);
    }

}
