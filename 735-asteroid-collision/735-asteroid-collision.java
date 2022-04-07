class Solution {
    public int[] asteroidCollision(int[] asteroids) {
    LinkedList<Integer> res = new LinkedList<>();
        for(int i = 0; i < asteroids.length; i++){
            if(asteroids[i] > 0 || res.isEmpty() || res.getLast() < 0){
                res.add(asteroids[i]);
            }
           else  if(res.getLast() <= -asteroids[i]){
                if(res.pollLast() < -asteroids[i])i--;
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
}