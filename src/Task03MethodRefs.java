import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

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
        Function<String, Integer> f1 = s -> s.length();
        Supplier<List<String>> s1 = () -> new ArrayList<>();
        Function<String, Integer> f2 = s -> Integer.parseInt(s);
        BiPredicate<String, String> p1 = (a, b) -> a.equals(b);
        UnaryOperator<String> u1 = s -> s.toUpperCase();
        Consumer<Object> c1 = x -> System.out.println(x);
        Comparator<String> cmp = (a, b) -> b.compareTo(a);

        List<String> list = s1.get();
        list.add("b");
        list.add("a");
        list.sort(cmp);
        System.out.println(f1.apply("java") + " " + f2.apply("42") + " " + p1.test("x", "x")
                + " " + u1.apply("ok") + " " + list);
        c1.accept("готово");
        System.out.println(list.getClass().getName());
    }
}
