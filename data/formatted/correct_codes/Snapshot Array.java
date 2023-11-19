class SnapshotArray {

    TreeMap<Integer, Integer>[] snapshotArray;
    int currSnapId;

    public SnapshotArray(int length) {
        snapshotArray = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            snapshotArray[i] = new TreeMap();
        }
        currSnapId = 0;
    }

    public void set(int index, int val) {
        snapshotArray[index].put(currSnapId, val);
    }

    public int snap() {
        return currSnapId++;
    }

    public int get(int index, int snap_id) {
        Integer lowerKey = snapshotArray[index].floorKey(snap_id);

        if (lowerKey != null) {
            return snapshotArray[index].get(lowerKey);
        }
        return 0;
    }
}
