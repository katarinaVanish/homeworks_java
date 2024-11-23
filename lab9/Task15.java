package org.knit.lab9;

public class Task15 {
    enum Seasons{
        WINTER("Зима", "Холодно", "Новый год"),
        SPRING("Весна", "Тепло", "Масленица"),
        SUMMER("Лето", "Жарко", "Яблочный спас"),
        AUTUMN("Осень", "Дождливо", "Сбор урожая");

        private final String seasonName;
        private final String weather;
        private final String holiday;

        Seasons(String seasonName, String weather, String holiday) {
            this.seasonName = seasonName;
            this.weather = weather;
            this.holiday = holiday;
        }

        public String getSeasonName() {
            return seasonName;
        }

        public String getWeather() {
            return weather;
        }

        public String getHoliday() {
            return holiday;
        }
    }
    public static void main(String[] args){
        for (Seasons season : Seasons.values()){
            StringBuilder sb = new StringBuilder();
            sb.append(season.seasonName)
                    .append(": ")
                    .append(season.weather)
                    .append(", типичный праздник - ")
                    .append(season.holiday);
            System.out.println(sb);
        }
    }
}
