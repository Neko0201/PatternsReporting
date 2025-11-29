package ru.netology.replandelivery;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
//        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        LocalDate currentDate = LocalDate.now();
        LocalDate date = currentDate.plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);

        return formattedDate;
    }

    public static String generateCity() {
        String[] cities = new String[]{"Майкоп", "Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Донецк", "Магас", "Нальчик", "Элиста", "Черкесск",
                "Петрозаводск", "Сыктывкар", "Симферополь", "Луганск", "Йошкар-Ола", "Саранск", "Якутск", "Владикавказ", "Казань", "Кызыл", "Ижевск", "Абакан",
                "Грозный", "Чебоксары", "Барнаул", "Чита", "Петропавловск-Камчатский", "Краснодар", "Пермь", "Владивосток", "Ставрополь", "Хабаровск", "Благовещенск",
                "Архангельск", "Белгород", "Брянск", "Владимир", "Волгоград", "Вологда", "Воронеж", "Запорожье", "Иваново", "Иркутск", "Калининград", "Калуга",
                "Кемерово", "Киров", "Кострома", "Курган", "Курск", "Гатчина", "Липецк", "магадан", "Москва", "Мурманск", "Нижний Новгород", "Великий Новгород", "Новосибирск",
                "Омск", "Оренбург", "Орел", "Пенза", "Псков", "Ростов-на-Дону", "Рязань", "Самара", "Саратов", "Южно-Сахалинск", "Екатеринбург", "Смоленск", "Тамбов", "Тверь",
                "Томск", "Тула", "Тюмень", "Ульяновск", "Херсон", "Челябинск", "Ярославль", "Санкт-Петербург", "Севастополь", "Биробиджан", "Нарьян-Мар", "Ханты-Мансийск",
                "Анадырь", "Салехард"};
        Random random = new Random();
        int randomIndex = random.nextInt(cities.length);

        return cities[randomIndex];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String lastName = faker.name().lastName();
        String firstName = faker.name().firstName();
        String fullName = lastName + " " + firstName;

        return fullName;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}