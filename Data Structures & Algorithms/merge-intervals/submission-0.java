class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n==1) return intervals;   
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));     
        List<int[]> res = new ArrayList<>();

        int startTime = intervals[0][0];
        int endTime = intervals[0][1];
        for(int i=1;i<n;i++){
            int curStart = intervals[i][0];
            int curEnd = intervals[i][1];

            if(curStart <= endTime){
                startTime = Math.min(startTime,curStart);
                endTime = Math.max(endTime,curEnd);
            }
            else{
                res.add(new int[]{startTime,endTime});
                startTime = curStart;
                endTime = curEnd;
            }

        }
        res.add(new int[]{startTime,endTime});

        return res.toArray(new int[res.size()][]);
        



    }
}
