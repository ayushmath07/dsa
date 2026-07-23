class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
            if(intervals.length==0)
                return new int[][]{newInterval};
            List<int[]> list = new ArrayList<>(); 
            boolean flag = false;
            int i =0;
            while(i<intervals.length){
                if(intervals[i][0]> newInterval[0] && flag==false){
                    list.add(new int[]{newInterval[0],newInterval[1]});
                    flag = true;
                }
                else{
                    list.add(new int[]{intervals[i][0],intervals[i][1]});
                    i++;
                }
            }
            if(!flag)
            list.add(newInterval);
            List<int[]> res = new ArrayList<>(); 
            int start1=list.get(0)[0];
            int end1=list.get(0)[1];
            for(i=1;i<list.size();i++){
                int start2=list.get(i)[0];
                int end2=list.get(i)[1];
                if(end1>=start2){
                    //merge
                    end1= Math.max(end1,end2);
                    continue;
                }
                res.add(new int[]{start1,end1});
                start1=start2;
                end1=end2;
            }
            res.add(new int[]{start1,end1});
            return(res.toArray(new int[0][]));

    }
}