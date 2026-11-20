import java.util.List;
import java.util.stream.Collectors;

/**
 Задание 5. Свой функциональный интерфейс.
 Дан список логинов
 Написать свой функциональный интерфейс Rule
 для проверки строк: один абстрактный метод test,
 default-методы and и negate, статическая фабрика notBlank.
 Реализовать интерфейс классом LengthRule с полями min и max.
 Создать объект LengthRule
 Собрать с помощью дефолтных методом Rule и LengthRule правил:
 1. мин длина логина 3 символа, макс длина - 12 символов.
 2. только буквы или текст
 3. не должен быть пустым
 через стрим с filter и напечатать невалидные логины.
 Ожидаемый вывод:
 всего 6, невалидных 3
 a
 ivan_2024
 max_1
 валидных 3
 */
public class Task05CustomInterface {

	@FunctionalInterface
    interface Rule {
        boolean test(String s);

        default Rule and(Rule other) {
            return s -> this.test(s) && other.test(s);
        }

        default Rule negate() {
            return s -> !this.test(s);
        }

        static Rule notBlank() {
            return s -> s != null && !s.isBlank();
        }
    }

    static class LengthRule implements Rule {
        private final int min;
        private final int max;

        LengthRule(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public boolean test(String s) {
            return s != null && s.length() >= min && s.length() <= max;
        }
    }

    public static void main(String[] args) {
        List<String> logins = List.of("anna", "a", "ivan_2024", "petr", "ekaterina99", "max_1");

        Rule lengthRule = new LengthRule(3, 12);
        Rule lettersOnly = s -> s.matches("[a-zA-Z]+");
        Rule notBlank = Rule.notBlank();

        Rule valid = lengthRule.and(lettersOnly).and(notBlank);

        List<String> invalid = logins.stream()
				.filter(valid.negate()::test)
                .collect(Collectors.toList());

        System.out.println("всего " + logins.size() + ", невалидных " + invalid.size());
        invalid.forEach(System.out::println);

        long validCount = logins.stream().filter(valid::test).count();
        System.out.println("валидных " + validCount);
    }
}
