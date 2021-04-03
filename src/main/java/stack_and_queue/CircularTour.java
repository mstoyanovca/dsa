package stack_and_queue;

public class CircularTour {
    public int tour(int[] petrol, int[] distance) {
        int start = 0;
        int end = 1;
        int currentPetrol = petrol[start] - distance[start];

        while (start != end || currentPetrol < 0) {
            while (start != end && currentPetrol < 0) {
                currentPetrol -= petrol[start] - distance[start];
                start++;
                if (start == petrol.length) return -1;
            }
            currentPetrol += petrol[end] - distance[end];
            end++;
            if (end == petrol.length) end = 0;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] petrol = {55, 33, 77, 40};
        int[] distance = {52, 100, 61, 69};

        System.out.println(new CircularTour().tour(petrol, distance));  // -1
    }
}
