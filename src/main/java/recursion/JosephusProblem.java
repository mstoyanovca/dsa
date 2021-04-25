package recursion;

public class JosephusProblem {
    public int josephus(int persons, int killed) {
        if (persons == 1) return 1;
        return (josephus(persons - 1, killed) + killed - 1) % persons + 1;
    }

    public static void main(String[] args) {
        int persons = 5;
        int killed = 3;

        System.out.println(new JosephusProblem().josephus(persons, killed));  // 4
    }
}
