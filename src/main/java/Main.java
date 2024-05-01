import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class One {
    int a, b;

    public One(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void print() {

        System.out.println(a + b);
    }
}

class Two extends One {

    int po = 3;

    public Two(int i) {
        super(i, i + 1);
    }

    public void print() {

        System.out.println(po * po);
    }
}

public class Main {

    public static void main(String[] args) {
        One one = new Two(10);
        one.print();
    }
}
