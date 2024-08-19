import java.util.*;

class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameLocationCount = 0;
        List<Double> angles = new ArrayList<>();
        int x0 = location.get(0), y0 = location.get(1);
        
        // Calculate angles
        for (List<Integer> point : points) {
            int x = point.get(0), y = point.get(1);
            if (x == x0 && y == y0) {
                sameLocationCount++;
            } else {
                double theta = Math.toDegrees(Math.atan2(y - y0, x - x0));
                if (theta < 0) {
                    theta += 360;
                }
                angles.add(theta);
            }
        }
        
        // Sort the angles
        Collections.sort(angles);
        
        // Duplicate the angles to handle the wrap-around case
        int size = angles.size();
        for (int i = 0; i < size; i++) {
            angles.add(angles.get(i) + 360);
        }
        
         int maxVisiblePoints = 0;
        int j = 0;
        for (int i = 0; i < size; i++) {
            while (j < angles.size() && angles.get(j) <= angles.get(i) + angle) {
                j++;
            }
            maxVisiblePoints = Math.max(maxVisiblePoints, j - i);
        }
        
        return maxVisiblePoints + sameLocationCount;
    }
}
