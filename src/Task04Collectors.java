import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
		Map<String, Long> cntByService = LOG.stream()
			.collect(Collectors.groupingBy(LogLine::service, Collectors.counting()));
		
		System.out.println("записей по сервисам" + cntByService);

		Map<String, Integer> sumByService = LOG.stream()
			.collect(Collectors.groupingBy(LogLine::service, Collectors.summingInt(LogLine::ms)));
		System.out.println("сумма мс по сервисам" + sumByService);

		Map<Boolean, List<LogLine>> slowFast = LOG.stream()
			.collect(Collectors.groupingBy(l -> l.ms() > 500));
		System.out.println("медленных " + slowFast.get(true).size() + ", быстрых " + slowFast.get(false).size());

		Map<String, Integer> maxByService = LOG.stream()
			.collect(Collectors.groupingBy(LogLine::service, Collectors.mapping(LogLine::ms, Collectors.reducing(0, Integer::max))));
		System.out.println("максимум мс по сервисам " + maxByService);

		String errorServices = LOG.stream()
			.filter(l -> "ERROR".equals(l.level()))
			.map(LogLine::service)
			.distinct()
			.sorted()
			.collect(Collectors.joining(" | "));
		System.out.println(errorServices);

		Map<String, List<Integer>> msByService = LOG.stream()
			.collect(Collectors.groupingBy(LogLine::service, Collectors.mapping(LogLine::ms, Collectors.toList())));
		System.out.println("замеры по сервисам " + msByService);

		int totalMs = LOG.stream()
			.mapToInt(LogLine::ms).sum();
		System.out.println("всего мс/записей " + totalMs + "/" + LOG.size());
    }
}
