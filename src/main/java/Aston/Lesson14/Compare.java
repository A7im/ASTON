package Aston.Lesson14;

public class Compare {
    public String compare(int a, int b) {
        if (a > b)
            return a + ">" + b;
        if (a < b)
            return a + "<" + b;
        return a + "=" + b;
    }
}
