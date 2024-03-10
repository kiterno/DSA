package cses.bitmasking;

public class AddRemoveSet {
    public static void main(String[] args) {
        int set = 15;

        display(set);
        set = add(set, 7);
        display(set);
        set = remove(set, 4);
        display(set);
    }

    static int add(int set, int x) {
        return set ^ (1<<(x-1));
    }

    static int remove(int set, int x) {
        return set ^ (1<<(x-1));
    }

    static void display(int set) {
        for (int i = 0; i < 32; i++) {
            if ((set & (1<<i)) != 0) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
    }
}
