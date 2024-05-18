package base.generics;

public class MainGenerics {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();
        integerBox.set(10);
        System.out.println(integerBox.get());

        Pair<Integer, String> pair1 = new Pair<>(1, "apple");
        Pair<Integer, String> pair2 = new Pair<>(2, "pear");
        boolean same = Util.compare(pair1, pair2);
        System.out.println(same);
    }
}
