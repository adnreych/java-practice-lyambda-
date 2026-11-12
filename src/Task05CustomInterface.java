import java.util.List;

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

    public static void main(String[] args) {
        List<String> logins = List.of("anna", "a", "ivan_2024", "petr", "ekaterina99", "max_1");
    }
}
