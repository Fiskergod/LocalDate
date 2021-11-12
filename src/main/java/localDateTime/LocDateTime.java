package localDateTime;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* ТЗ:
 1) Создать класс People c полями: Имя, localTime, localDate.
 2) В Main создаем список людей и выводим их.
 3) Создаем меню для пользователя: 1 - изменить дату, 2 - изменить время, 3 - выйти из программы.
    Если 1: предлагаем выбрать имя, меняем дату.
    Если 2: предлагаем выбрать имя, меняем время.
 4) Если 3: выход и вывод списка людей с измененной инфо о регистрации. */

public class LocDateTime {
    private static final Logger logger = LogManager.getLogger();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        People person1 = new People("Коля",
                LocalDate.of(2020, 10, 24),
                LocalTime.of(22, 35, 10));
        People person2 = new People("Анна",
                LocalDate.of(2021, 11, 14),
                LocalTime.of(12, 45, 15));
        People person3 = new People("Толя",
                LocalDate.of(2019, 5, 1),
                LocalTime.of(10, 15, 1));

        List<People> peopleList = new ArrayList<>(List.of(person1, person2, person3));
        Utils.printInfo(peopleList);

        while (true) {
            System.out.println("\nВведите число соответствующее пункту меню: " +
                    "\n1) Изменить дату регистрации." +
                    "\n2) Изменить время регистрации." +
                    "\n3) Выйти из меню.");

            int firstUserNumber = getUserNumber(1, 3);

            if (firstUserNumber == 3) {
                break;
            }

            while (true) {
                if (firstUserNumber == 1) {
                    System.out.println("\nИзменение даты регистрации для: " +
                            "\n1) " + peopleList.get(0).getName() +
                            "\n2) " + peopleList.get(1).getName() +
                            "\n3) " + peopleList.get(2).getName());

                    int secondUserNumber = getUserNumber(1, 3);

                    System.out.println("Введите дату в формате: год, месяц, число (YYYY, MM, DD).");
                    int year = getUserNumber(0, 2050);
                    int month = getUserNumber(0, 2050);
                    int day = getUserNumber(0, 2050);
                    LocalDate newLocalDate = LocalDate.of(year, month, day);

                    switch (secondUserNumber) {
                        case 1: {
                            person1.setRegDate(newLocalDate);
                            System.out.println("Дата регистрации для " + person1.getName() +
                                    " изменена на: " + person1.getRegDate());
                            logger.info("Дата о регистрации 1-ого пользователя изменена.");
                            break;
                        }

                        case 2: {
                            person2.setRegDate(newLocalDate);
                            System.out.println("Дата регистрации для " + person2.getName() +
                                    " изменена на: " + person2.getRegDate());
                            logger.info("Дата о регистрации 2-ого пользователя изменена.");
                        }
                        break;
                        case 3: {
                            person3.setRegDate(newLocalDate);
                            System.out.println("Дата регистрации для " + person3.getName() +
                                    " изменена на: " + person3.getRegDate());
                            logger.info("Дата о регистрации 3-ого пользователя изменена.");
                            break;
                        }
                    }
                    break;
                }

                if (firstUserNumber == 2) {
                    System.out.println("\nИзменение времени регистрации для: " +
                            "\n1) " + peopleList.get(0).getName() +
                            "\n2) " + peopleList.get(1).getName() +
                            "\n3) " + peopleList.get(2).getName());

                    int secondUserNumber = getUserNumber(1, 3);

                    System.out.println("Введите время в 24-х часовом формате: часы, минуты, секунды (hh, mm, ss).");
                    int hour = getUserNumber(0, 2050);
                    int minute = getUserNumber(0, 2050);
                    int second = getUserNumber(0, 2050);
                    LocalTime newLocalTime = LocalTime.of(hour, minute, second);

                    switch (secondUserNumber) {
                        case 1: {
                            person1.setRegTime(newLocalTime);
                            System.out.println("Время регистрации для " + person1.getName() +
                                    " изменено на: " + person1.getRegTime());
                            logger.info("Время о регистрации 1-ого пользователя изменено.");
                            break;
                        }

                        case 2: {
                            person2.setRegTime(newLocalTime);
                            System.out.println("Время регистрации для " + person2.getName() +
                                    " изменено на: " + person2.getRegTime());
                            logger.info("Время о регистрации 2-ого пользователя изменено.");
                            break;
                        }

                        case 3: {
                            person3.setRegTime(newLocalTime);
                            System.out.println("Время регистрации для " + person3.getName() +
                                    " изменено на: " + person3.getRegTime());
                            logger.info("Время о регистрации 3-ого пользователя изменено.");
                            break;
                        }
                    }
                    break;
                }
            }
        }
        System.out.println("Вы закончили работу!");
        Utils.printInfo(peopleList);
    }

    /**
     * Метод проверяет введенное число на правильность ввода.
     * @param leftBorder  Левая граница числа.
     * @param rightBorder Правая граница числа.
     * @return Возвращает введенное число.
     */
    public static int getUserNumber(int leftBorder, int rightBorder) {
        String userNum = SCANNER.next();
        while (!checkUserNumber(userNum, leftBorder, rightBorder)) {
            System.out.println("Incorrect input value, try again!");
            userNum = SCANNER.next();
        }
        return Integer.parseInt(userNum);
    }

    /**
     * Метод проверяет введенное число на парс и границы ввода.
     * @param userString Введенное пользователем число.
     * @return Возвращает число, если True, иначе возвращает False.
     */
    public static boolean checkUserNumber(String userString, int leftBorder, int rightBorder) {
        try {
            int number = Integer.parseInt(userString);
            if (number >= leftBorder && number <= rightBorder) {
                logger.info("Число удачно запарсилось.");
                return true;
            }
        } catch (NumberFormatException ex) {
            logger.error("Ошибка при парсе.");
        }
        return false;
    }
}