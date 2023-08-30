package dp;

import java.util.Map;

public class gridTraveller {

    int count = 0;
    public long gridTraveller(int m, int n, Map<String, Long> map){
        String key = String.valueOf(m + ',' + n);
        if(map.containsKey(key)) return map.get(key);
        if(m == 0 || n == 0) return 0;
        if(m == 1 || n == 1) return 1;
        map.put(key, gridTraveller(m-1, n, map) + gridTraveller(m, n-1, map));
        count++;
        return map.get(key);
    }
}
