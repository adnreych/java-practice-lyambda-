import java.util.Optional;

/**
 Задание 6. Optional 
 Реализуйте два метода в классе SmartHomePractice, 
 используя только API класса Optional (без if, тернарного оператора и .get()):
 1. isOverheated(Room room) — возвращает true, если у комнаты есть датчик, 
 у датчика есть температура и она строго больше 25.0. В остальных случаях возвращает false.
 2. getTemperatureDisplay(Room room) — возвращает строку формата 
 "<температура> °C" (например, "21.0 °C"). 
 Если комната, датчик или температура отсутствуют, возвращает "Датчик не в сети".
 Ожидаемый вывод:
 true
 false
 false
 false
 21.0 °C
 Датчик не в сети
 */
public class Task06Optional {

    public static void main(String[] args) {
        Room kitchen = new Room("Кухня", new Sensor(27.5));
        Room bedroom = new Room("Спальня", new Sensor(21.0));
        Room brokenSensorRoom = new Room("Балкон", new Sensor(null));
        Room emptyRoom = new Room("Кладовка", null);

        System.out.println(isOverheated(kitchen));
        System.out.println(isOverheated(bedroom));
        System.out.println(isOverheated(brokenSensorRoom));
        System.out.println(isOverheated(null));

        System.out.println(getTemperatureDisplay(bedroom));
        System.out.println(getTemperatureDisplay(emptyRoom));
    }

    static class Room {
        private String room;
        private Sensor sensor;

        public Room(String room, Sensor sensor) {
            this.room = room;
            this.sensor = sensor;
        }

        public Optional<Sensor> getSensor() {
            return Optional.ofNullable(sensor);
        }
    }

    static class Sensor {
        private Double temperature;

        public Sensor(Double temperature) {
            this.temperature = temperature;
        }

        public Optional<Double> getTemperature() {
            return Optional.ofNullable(temperature);
        }
    }

    public static boolean isOverheated(Room room) {
        // TODO: реализовать
        return false;
    }

    public static String getTemperatureDisplay(Room room) {
        // TODO: реализовать
        return "";
    }
}