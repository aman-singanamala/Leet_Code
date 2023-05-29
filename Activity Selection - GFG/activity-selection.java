//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends



class Solution {
    // Function to find the maximum number of activities that can
    // be performed by a single person.
    public static int activitySelection(int start[], int end[], int n) {
        // Create a list of activities
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], end[i]));
        }

        // Sort activities based on the end day using a custom comparator
        activities.sort(Comparator.comparingInt(a -> a.end));

        int count = 1;
        int currentEnd = activities.get(0).end;

        for (int i = 1; i < n; i++) {
            if (activities.get(i).start > currentEnd) {
                count++;
                currentEnd = activities.get(i).end;
            }
        }

        return count;
    }
}

class Activity {
    int start;
    int end;

    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}