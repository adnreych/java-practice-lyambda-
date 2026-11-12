import java.util.List;

/**
 Задание 2. Pipeline и правила работы со стримом.
 Собрать pipeline: оставить строки длиннее четырёх символов,
 перевести в верхний регистр, отсортировать, вывести в виде строки, склеив через ","
 Ожидаемый вывод:
 FUNCTIONAL, KOTLIN, LAMBDA, STREAM
 */
public class Task02Pipeline {

    public static void main(String[] args) {
        List<String> words = List.of("java", "kotlin", "api", "stream", "lambda",
                "Go", "c", "functional", "map", "SQL");
    }
}
