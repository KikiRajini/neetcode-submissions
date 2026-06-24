/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals.sort((a,b)-> Integer.compare(a.end,b.end));
        int prev = Integer.MIN_VALUE;
        for(Interval interval: intervals){
            if( interval.start < prev){return false;}
            else{
                prev = interval.end;
            }
        }
        return true;

    }
}
