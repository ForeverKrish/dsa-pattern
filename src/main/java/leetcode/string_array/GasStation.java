package leetcode.string_array;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0, totalCost = 0;
        for(int i =0; i < gas.length ; i++){
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if(totalCost > totalGas){
            return -1; //trip is not possible
        }

        //now we know that trip exist. We just need to find out from which node I can start so that I reach the last index with positive fuel
        int currentGasLeft = 0;
        int startGasStationIndex = 0;

        //Greedy Approach
        for(int start = 0; start < gas.length; start++){
            currentGasLeft = currentGasLeft + gas[start];
            int requiredGas = cost[start];

            if(requiredGas <= currentGasLeft){
                currentGasLeft = currentGasLeft - requiredGas;
            }else{
                startGasStationIndex = start+1;
                currentGasLeft = 0;
            }
            start ++;
        }

        if(currentGasLeft >= 0){
            return  startGasStationIndex;
        }else return -1;

    }
    public int canCompleteCircuitMinimal(int[] gas, int[] cost) {

        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        GasStation sol = new GasStation();
        System.out.println(sol.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(sol.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));

        System.out.println(sol.canCompleteCircuitMinimal(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(sol.canCompleteCircuitMinimal(new int[]{2,3,4}, new int[]{3,4,3}));
    }
    /*
    Time: O(n)
    Space: O(1)
    * */
}