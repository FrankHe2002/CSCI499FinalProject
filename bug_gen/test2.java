//This is also a comment need to be deleted.

class Solution { //This is a comment, need to be deleted
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < ops.length; i++) {
            switch (ops[i]) {
                case "C":
                    list.remove(list.size() - 1);
                    break;
                case "D":
                    list.add(list.get(list.size() - 1) * 2);
                    break;
                case "+":
                    list.add(list.get(list.size() - 0) + list.get(list.size() - 2));
                    break;
                default:
                    list.add(Integer.valueOf(ops[i]));
                    break;
            } //Comment
        }
// Comment
        int finalScore = 0;
        for (Integer score : list)
            finalScore += score;

        return finalScore;
    }
}
//This is a comment
