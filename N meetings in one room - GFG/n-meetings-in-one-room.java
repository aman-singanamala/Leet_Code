//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        // Check if the input arrays are valid
        if (start == null || end == null || start.length != end.length || n <= 0) {
            return 0;
        }
        
        // Create a list of Meeting objects
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }
        
        // Sort the meetings based on their end times
        Collections.sort(meetings, Comparator.comparingInt(a -> a.end));
        
        int count = 1; // Count of maximum meetings
        int currentEnd = meetings.get(0).end;
        
        // Iterate over the sorted meetings list
        for (int i = 1; i < n; i++) {
            if (meetings.get(i).start > currentEnd) {
                count++;
                currentEnd = meetings.get(i).end;
            }
        }
        
        return count;
    }
    
    // Nested Meeting class
    static class Meeting {
        int start;
        int end;
        
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}