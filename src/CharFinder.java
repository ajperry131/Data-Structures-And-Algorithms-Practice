import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public Character firstNonRepeatedCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int count  = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }

        for (char c : chars) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return Character.MIN_VALUE;
    }

    public Character firstRepeatedCharacter(String str) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c))
                return c;

            set.add(c);
        }

        return Character.MIN_VALUE;
    }

}
