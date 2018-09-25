// Note how tie break works. 
// Author: EPI 14.4 p.221 + kei
// Date  : December 27, 2016 

package whiteboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Lab_whiteboard {

    public static void main(String[] args) {

        
        ArrayList<Event> list = new ArrayList<>();
        
        list.add(new Event(1, 5));
        list.add(new Event(6, 10));
        list.add(new Event(11, 13));
        list.add(new Event(14, 15));
        list.add(new Event(2, 7));
        list.add(new Event(8, 9));
        list.add(new Event(12, 15));
        list.add(new Event(4, 5));
        list.add(new Event(9, 17));
        
        System.out.println(findMaxSimultaneousEvents(list)); // 3 
        
        
        
        
        
        
        
        
        System.out.println();
        System.out.println("done.");
        return;
    } // end main().
    
    
    public static int findMaxSimultaneousEvents(List<Event> list) {
        // Build an array of all endpoints. 
        List<Endpoint> endpoints = new ArrayList<>();
        for (Event event : list) {
            endpoints.add(new Endpoint(event.start, true));
            endpoints.add(new Endpoint(event.finish, false));           
        }
        
        Collections.sort(endpoints);
        
        // Max pattern. 
        int max = 0, cur = 0;
        for (Endpoint endpoint : endpoints) {
            if (endpoint.isStart) {
                cur++;
                max = Math.max(cur, max);
            } else {
                cur--;
            }
        }
        
        return max;     
    }   
    
}


class Event {
    public int start, finish;
    
    public Event(int start, int finish) {
        this.start = start;
        this.finish = finish;       
    }
}

class Endpoint implements Comparable<Endpoint> {
    public int time;
    // Start point or end point. 
    public boolean isStart;
    
    @Override
    public int compareTo(Endpoint e) {
        if (time != e.time) {
            return Integer.compare(time, e.time);
        }
        // Tie break.
        // Start point comes first. 
        return isStart && !e.isStart ? -1 : (!isStart && e.isStart ? 1 : 0);        
    }
    
    public Endpoint(int t, boolean b) {
        time = t;
        isStart = b;
    }
    
}





















