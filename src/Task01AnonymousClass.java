import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 Задание 1. Анонимный класс в лямбду.
 Дано 2 анонимных класса. Выполнить рядом аналогичную запись, но в стиле лямбда-выражения.
 Вывод:
 [api, java, lambda, stream]
 [api, java]
 */
public class Task01AnonymousClass {

    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("lambda", "java", "stream", "api"));

        words.sort(Comparator.comparingInt(String::length));

        System.out.println(words);

        words.removeIf((s) -> s.length() > 5);

        System.out.println(words);
    }
}
