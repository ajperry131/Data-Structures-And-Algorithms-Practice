import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashTableExercises {
    public int mostFrequent(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : array) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }

        int max = -1;
        int result = array[0];
        for (Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() > max) {
                max = item.getValue();
                result = item.getKey();
            }
        }

        return result;
    }

    public int countPairsWithDiff(int[] array, int diff) { //O(n)
        Set<Integer> set = new HashSet<>();
        for (int i : array) {
            set.add(i);
        }

        int count = 0;
        for (Integer item : set) {
            if (set.contains(item + diff))
                count++;
        }

        return count;

//        var count = 0;
//        for (var number : numbers) {
//            if (set.contains(number + difference))
//                count++;
//            if (set.contains(number - difference))
//                count++;
//            set.remove(number);
//        }
//
//        // Time complexity of this method is O(n).
//
//        return count;
    }

    public int[] twoSum(int[] array, int target) {
        return new int[2];
    }

}
