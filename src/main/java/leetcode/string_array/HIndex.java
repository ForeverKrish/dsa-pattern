package leetcode.string_array;

import java.util.Arrays;
public class HIndex {
    public int hIndex (int[] citations) {

        int totalResearchPapers = citations.length;
        // number sort : sort papers based on the number of citations
        int[] citationFrequency = new int[totalResearchPapers+1]; //length + 1 since current index citations are also considered in calculation

        int citationIndex = 0;
        while (citationIndex < citations.length){
            int currCitationCount = citations[citationIndex];
            if(currCitationCount >  totalResearchPapers){
                citationFrequency[totalResearchPapers] = citationFrequency[totalResearchPapers]+1; //don't use ++ here
            }else {
                citationFrequency[citations[citationIndex]] = citationFrequency[citations[citationIndex]]+1; //don't use ++ here
            }
            citationIndex++;
        }

        //traverse from back to find max: where papers i.e. index >= citation for the papers who's index precedes it
        int endIndex = totalResearchPapers;
        int totalCitations = 0;
        while (endIndex >= 0){
            //critera: H is number of a researcher's publications that have been cited at least that many times
            totalCitations =  totalCitations + citationFrequency[endIndex];
            if( totalCitations >= endIndex ) {
                return endIndex;
            }
            endIndex--;
        }
        return endIndex;


    }

    public int hIndexMinimal (int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        HIndex sol = new HIndex();

        System.out.println(sol.hIndex(new int[]{3,0,6,7,8,5}));
        System.out.println(sol.hIndex(new int[]{3,0,6,1,5}));
        System.out.println(sol.hIndex(new int[]{1,3,1}));
        System.out.println(sol.hIndex(new int[]{3,1,2,3,2}));



        System.out.println(sol.hIndexMinimal(new int[]{3,0,6,7,8,5}));
        System.out.println(sol.hIndexMinimal(new int[]{3,0,6,1,5}));
        System.out.println(sol.hIndexMinimal(new int[]{1,3,1}));
        System.out.println(sol.hIndex(new int[]{3,1,2,3,2}));
    }
}