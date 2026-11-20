import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 Задание 3. Ссылки на метод.
 Дано шесть лямбд и один компаратор. Заменить все шесть
 лямбд ссылками на метод, а компаратор - готовым компаратором из JDK.
 Вывод программы:
 4 42 true OK [b, a]
 готово
 java.util.ArrayList
 */
public class Task03MethodRefs {

    public static void main(String[] args) {
        List<String> list = s1();
        list.add("b");
        list.add("a");
        list.sort(Comparator.reverseOrder());
        System.out.println(f1("java") + " " + f2("42") + " " + p1("x", "x") + " " + u1("ok") + " " + list);

        c1("готово");
        System.out.println(list.getClass().getName());
    }

    private static Integer f1(String s) {
        return s.length();
    }

    private static ArrayList<String> s1() {
        return new ArrayList<>();
    }

    private static Integer f2(String s) {
        return Integer.parseInt(s);
    }

    private static Boolean p1(String s1, String s2) {
        return s1.equals(s2);
    }

    private static String u1(String s) {
        return s.toUpperCase();
    }

    private static void c1(String s) {
        System.out.println(s);
    }
}
