```java
import java.util.*;

class MovieRentingSystem {

    Map<Integer, Map<Integer, Pair>> map = new HashMap<>();

    TreeSet<Pair> rented = new TreeSet<>(new rcomp());

    public MovieRentingSystem(int n, int[][] entries) {
        for (int entry[] : entries) {
            Map<Integer, Pair> map2 = map.getOrDefault(entry[1], new HashMap<>());
            Pair p = new Pair(entry[0], entry[1], entry[2]);
            map2.put(entry[0], p);
            map.put(entry[1], map2);
        }
    }

    public List<Integer> search(int movie) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(new scomp());

        Map<Integer, Pair> map1 = map.getOrDefault(movie, new HashMap<>());

        for (Pair p : map1.values()) {
            if (p.rent == true) {
                continue;
            }
            if (pq.size() < 5) {
                pq.add(p);
            } else {
                if (pq.peek().price > p.price) {
                    pq.poll();
                    pq.add(p);
                } else if (pq.peek().price == p.price && pq.peek().shop > p.shop) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (! pq.isEmpty()) {

            Pair p = pq.poll();
            ans.add(0, p.shop);
        }

        return ans;


    }

    public void rent(int shop, int movie) {

        Pair p = map.get(movie).get(shop);
        p.rent = true;
        rented.add(p);
    }

    public void drop(int shop, int movie) {
        Pair p = map.get(movie).get(shop);
        p.rent = false;
        rented.remove(p);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> ans = new ArrayList<>();

        for (Pair p : rented) {
            List<Integer> t = new ArrayList<>();
            t.add(p.shop);
            t.add(p.movie);
            ans.add(t);
            if (ans.size() == 5) {
                break;
            }
        }

        return ans;
    }
}

class scomp implements Comparator<Pair> {

    public int compare(Pair a, Pair b) {
        if (a.price == b.price) {
            return b.shop - a.shop;
        }
        return b.price - a.price;
