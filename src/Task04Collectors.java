import java.util.Comparator;
import java.util.HashMap;
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
        HashMap<String, Integer> recordsByServices = new HashMap<>();
        List<LogLine> authData = LOG.stream().filter(log -> "auth".equals(log.service())).toList();
        List<LogLine> searchData = LOG.stream().filter(log -> "search".equals(log.service())).toList();
        List<LogLine> payData = LOG.stream().filter(log -> "pay".equals(log.service())).toList();
        List<LogLine> ordersData = LOG.stream().filter(log -> "orders".equals(log.service())).toList();

        recordsByServices.put("auth", authData.size());
        recordsByServices.put("search", searchData.size());
        recordsByServices.put("pay", payData.size());
        recordsByServices.put("orders", ordersData.size());

        HashMap<String, Integer> msSumByServices = new HashMap<>();
        Integer totalMsSum = 0;
        Integer msSum = 0;
        for (LogLine a : authData) {
            msSum += a.ms();
            totalMsSum += a.ms();
        }

        msSumByServices.put("auth", msSum);
        msSum = 0;

        for (LogLine a : searchData) {
            msSum += a.ms();
            totalMsSum += a.ms();
        }

        msSumByServices.put("search", msSum);
        msSum = 0;

        for (LogLine a : payData) {
            msSum += a.ms();
            totalMsSum += a.ms();
        }

        msSumByServices.put("pay", msSum);
        msSum = 0;

        for (LogLine a : ordersData) {
            msSum += a.ms();
            totalMsSum += a.ms();
        }

        msSumByServices.put("orders", msSum);
        msSum = 0;

        Long numberOfSlowLogs = LOG.stream().filter(logLine -> logLine.ms() > 500).count();
        Long numberOfFastLogs = LOG.size() - numberOfSlowLogs;

        HashMap<String, Integer> maxMsByService = new HashMap<>();
        maxMsByService.put("auth", authData.stream().map(log -> log.ms()).max(Comparator.naturalOrder()).get());
        maxMsByService.put("search", searchData.stream().map(log -> log.ms()).max(Comparator.naturalOrder()).get());
        maxMsByService.put("pay", payData.stream().map(log -> log.ms()).max(Comparator.naturalOrder()).get());
        maxMsByService.put("orders", ordersData.stream().map(log -> log.ms()).max(Comparator.naturalOrder()).get());

        List<String> servicesWithErrors = LOG.stream()
                .filter(log -> "ERROR".equals(log.level()))
                .map(LogLine::service)
                .distinct()
                .toList();

        System.out.println("Записей по сервисам: " + recordsByServices);

        List<Integer> authRecordsData = authData.stream().map(LogLine::ms).toList();
        List<Integer> searchRecordsData = searchData.stream().map(LogLine::ms).toList();
        List<Integer> payRecordsData = searchData.stream().map(LogLine::ms).toList();
        List<Integer> ordersRecordsData = ordersData.stream().map(LogLine::ms).toList();



        System.out.println(recordsByServices);
        System.out.println(msSumByServices);
        System.out.println("медленных " + numberOfSlowLogs + ", быстрых " + numberOfFastLogs);
        System.out.println(maxMsByService);
        System.out.println("сервисы с ошибками: " + String.join(" | ", servicesWithErrors));
        System.out.println("замеры по сервисам: " + "{auth=" + authRecordsData + ", search=" + searchRecordsData +
                ", pay=" + payRecordsData + ", orders=" + ordersRecordsData + "}");
        System.out.println("всего мс/записей " + totalMsSum + "/" + LOG.size());
    }
}
