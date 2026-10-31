class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalFull=0;
        int consume=0;
        for(int a:gas){
            totalFull=totalFull+a;
        }
        for(int a:cost){
            consume=consume+a;
        }
        if(consume>totalFull){
            return -1;
        }
        int idx=0;
        int total=0;
        for(int i=0; i<gas.length;i++){
            total=total+gas[i]-cost[i];
            if(total<0){
                idx=i+1;
                total=0;
            }
        }
        return idx;
    }
}