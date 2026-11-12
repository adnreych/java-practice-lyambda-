import java.util.List;

/**
 Задание 4. Collectors и логи сервиса.
 Есть лог из 12 записей. Собрать сводку через
 {@link  java.util.stream.Collectors}:
 количество записей по сервисам
 суммарное время по сервисам
 разделение на медленные (больше 500 мс) и быстрые
 максимальное время по сервису
 список сервисов с ошибками одной строкой
 все замеры по сервисам.
 Ожидаемый вывод:
 записей по сервисам: {search=2, auth=4, pay=3, orders=3}
 сумма мс по сервисам: {search=120, auth=1100, pay=1650, orders=2400}
 медленных 3, быстрых 9
 максимум мс по сервисам: {search=75, auth=480, pay=1500, orders=1200}
 сервисы с ошибками: auth | orders | pay
 замеры по сервисам: {search=[45, 75], auth=[120, 300, 480, 200], pay=[90, 60, 1500], orders=[800, 1200, 400]}
 всего мс/записей: 5270/12
 */
public class Task04Collectors {

    record LogLine(String level, String service, int ms) {}

    static final List<LogLine> LOG = List.of(
            new LogLine("INFO", "auth", 120),
            new LogLine("INFO", "auth", 300),
            new LogLine("ERROR", "auth", 480),
            new LogLine("WARN", "auth", 200),
            new LogLine("INFO", "orders", 800),
            new LogLine("INFO", "orders", 1200),
            new LogLine("ERROR", "orders", 400),
            new LogLine("INFO", "pay", 90),
            new LogLine("WARN", "pay", 60),
            new LogLine("ERROR", "pay", 1500),
            new LogLine("INFO", "search", 45),
            new LogLine("INFO", "search", 75));

    public static void main(String[] args) {

    }
}
