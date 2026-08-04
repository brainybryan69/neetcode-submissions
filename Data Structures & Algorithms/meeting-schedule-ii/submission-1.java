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
    public int minMeetingRooms(List<Interval> intervals) {
        ArrayList<Integer> start = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        for (Interval interval : intervals) {
            start.add(interval.start);
            end.add(interval.end);
        }
        Collections.sort(start);
        Collections.sort(end);
        int s = 0, e = 0;
        int count = 0, max = 0;
        while (s < intervals.size() && e < intervals.size()) {
            while (s < intervals.size() && start.get(s) < end.get(e)) {  
                s++;
                count++;
            }
            max = Math.max(max, count);
            e++;
            count--;
        }
        return max;
    }
}
