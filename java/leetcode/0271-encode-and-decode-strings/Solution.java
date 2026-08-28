class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();

        for(String str : strs)
            res.append(Integer.toString(str.length()))
                .append("_")
                .append(str);

        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;

        while(i < str.length()){
            int delimeter = str.indexOf('_', i);

            int length = Integer.parseInt(
                str.substring(i, delimeter)
            );

            int start = delimeter + 1;
            int end = start + length;

            res.add(str.substring(start, end));

            i = end;
        }

        return res;
    }
}
