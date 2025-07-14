package leetcode.string_array;

import java.util.*;
public class RandomizedSet {
    private final Map<Integer,Integer> idx = new HashMap<>();
    private final List<Integer> vals = new ArrayList<>();
    private final Random rand = new Random();

    public boolean insert(int val) {
        if (idx.containsKey(val)) return false;
        idx.put(val, vals.size());
        vals.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!idx.containsKey(val)) return false;
        int last = vals.get(vals.size() - 1), i = idx.get(val);
        vals.set(i, last);
        idx.put(last, i);
        vals.remove(vals.size() - 1);
        idx.remove(val);
        return true;
    }
    /*
    Time: O(1) amortized
    Space: O(n)
    * */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(1));
        System.out.println(rs.remove(2));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
        System.out.println(rs.remove(1));
        System.out.println(rs.insert(2));
        System.out.println(rs.getRandom());
    }
}