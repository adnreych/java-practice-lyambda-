import java.util.ArrayList;
import java.util.List;

/**
 Задание 1. Анонимный класс в лямбду.
 Дано 2 анонимных класса. Выполнить рядом аналогичную запись, но в стиле лямбда-выражения.
 Вывод:
 [api, java, lambda, stream]
 [api, java]
 */
public class Task01AnonymousClass {

    public static void main(String[] args) {
		solution();
        // List<String> words = new ArrayList<>(List.of("lambda", "java", "stream", "api"));

        // words.sort(new Comparator<String>() {
        //     @Override
        //     public int compare(String a, String b) {
        //         return a.length() - b.length();
        //     }
        // });
        // System.out.println(words);

        // words.removeIf(new Predicate<String>() {
        //     @Override
        //     public boolean test(String s) {
        //         return s.length() > 5;
        //     }
        // });
        // System.out.println(words);
    }

	public static void solution() {
		List<String> words = new ArrayList<>(List.of("lambda", "java", "stream", "api"));

		words.sort((a, b) -> a.length() - b.length());
		System.out.println(words);

		words.removeIf(s -> s.length() > 5);
		System.out.println(words);
	}
}
