
package dataController;

import data.Color;
import data.Country;
import data.Person;
import exceptions.IncorrectValueException;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.Scanner;

/**
 * A class that implements working with a collection via a terminal
 */
public class ConsoleController {
    DataController dataController;
    public ConsoleController(DataController dataController) {
        this.dataController = dataController;
    }

    private boolean isEnterRepeated(final Scanner scanner) {
        String input;
        System.out.println("Хотите повторить ввод данных? Ответ предоставьте в формате ДА/НЕТ: ");
        input = scanner.nextLine();
        if (input.toUpperCase().equals("ДА"))
            return true;
        else if(input.toUpperCase().equals("НЕТ"))
            return false;
        else {
            System.out.println("Пользователь дурак, вводите \"ДА\" или \"НЕТ\"");
            return isEnterRepeated(scanner);
        }
    }
    // если всё плохо вернётся null
    public Person createPerson() {
        System.out.println("Создание нового человека...");
        Person person = new Person();
        String input;
        Scanner scanner = new Scanner(System.in);
        try {
            person.setId(Person.generateUniqueId(dataController.getTreeMap()));

            System.out.print("Введите имя человека: ");
            input = scanner.nextLine();
            person.setName(input);

            System.out.println("Заполнение координат местоположения человека...");
            System.out.print("Введите координату x, большую -645: ");
            input = scanner.nextLine();
            try {
                person.getCoordinates().setX(Float.parseFloat(input));
            } catch (NumberFormatException e) {
                throw new IncorrectValueException("x должно быть числом с плавающей точкой");
            }
            System.out.print("Введите координату y, меньшую 727: ");
            input = scanner.nextLine();
            try {
                person.getCoordinates().setY(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                throw new IncorrectValueException("y должно быть целочисленным числом");
            }

            person.setCreationDate(Date.from(Instant.now()));

            System.out.print("Введите положительное значение роста человека: ");
            input = scanner.nextLine();
            try {
                person.setHeight(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                throw new IncorrectValueException("значение поля роста человека должно быть целочисленным");
            }

            System.out.print("Введите цвет глаз человека из предложенных: ");
            for (Color i: Color.values())
                System.out.print(i.toString()+" ");
            System.out.println();
            input = scanner.nextLine();
            person.setEyeColor(input);
            if (person.getEyeColor() == null)
                System.out.println("Некорректный ввод. Поле цвета глаз было пропущено.");

            System.out.print("Введите цвет волос человека из предложенных: ");
            for (Color i: Color.values())
                System.out.print(i.toString()+" ");
            System.out.println();
            input = scanner.nextLine();
            person.setHairColor(input);
            if (person.getHairColor() == null)
                System.out.println("Некорректный ввод. Поле цвета волос было пропущено.");

            System.out.print("Введите национальность человека из предложенных: ");
            for (Country i: Country.values())
                System.out.print(i.toString()+" ");
            System.out.println();
            input = scanner.nextLine();
            person.setNationality(input);
            if (person.getNationality() == null)
                System.out.println("Некорректный ввод. Поле национальности было пропущено.");

            System.out.println("Заполнение координат локации местоположения человека...");
            System.out.print("Введите координату x: ");
            input = scanner.nextLine();
            try {
                person.getLocation().setX(Integer.parseInt(input));
            } catch (NumberFormatException e) {
                throw new IncorrectValueException("x должно быть целочисленным числом");
            }
            System.out.print("Введите координату y: ");
            input = scanner.nextLine();
            try {
                person.getLocation().setY(Float.parseFloat(input));
            } catch (NumberFormatException e) {
                throw new IncorrectValueException("y должно быть числом с плавающей точкой");
            }
            System.out.print("Введите координату z: ");
            input = scanner.nextLine();
            try {
                person.getLocation().setZ(Long.parseLong(input));
            } catch (NumberFormatException e) {
                throw new IncorrectValueException("z должно быть целочисленным числом");
            }

        } catch (IncorrectValueException e) {
            System.out.println("Ошибка пользовательского ввода: "+e.getMessage()+".");

            if (isEnterRepeated(scanner)) {
                return createPerson();
            }
            person = null;
        }
        return person;
    }

    public Person updatePerson(final Person oldPerson) {
        Person person = new Person(oldPerson);
        System.out.println("Обновление человека с id "+person.getId());
        System.out.println("Если какие-то значения обновлять не нужно, оставьте поле пустым нажав enter.");
        Scanner scanner = new Scanner(System.in);
        String input;
        try {
            System.out.println("Введите имя:");
            input = scanner.nextLine();
            if (!input.equals(""))
                person.setName(input);
            else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException e) {
            System.out.println("Некорректное имя, поле осталось прежним.");
        }
        try {
            System.out.println("Введите координату X местоположения человека, большую -645: ");
            input = scanner.nextLine();
            if (!input.equals(""))
                person.getCoordinates().setX(Float.parseFloat(input));
            else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException | NumberFormatException e) {
            System.out.println("Некорректно введена координата X, поле осталось прежним.");
        }
        try {
            System.out.println("Введите координату Y местоположения человека, меньшую 728: ");
            input = scanner.nextLine();
            if (!input.equals(""))
                person.getCoordinates().setY(Integer.parseInt(input));
            else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException | NumberFormatException e) {
            System.out.println("Некорректно введена координата Y, поле осталось прежним.");
        }
        System.out.println("Поле creationDate не подлежит редактированию.");
        try {
            System.out.println("Введите положительный рост человека");
            input = scanner.nextLine();
            if (!input.equals(""))
                person.setHeight(Integer.parseInt(input));
            else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException | NumberFormatException e) {
            System.out.println("Некорректно введён рост человека, поле осталось прежним.");
        }
        try {
            System.out.print("Введите значение цвета глаз человека: ");
            for (Color i: Color.values())
                System.out.print(i.name()+" ");
            System.out.println();
            input = scanner.nextLine();
            if (!input.equals("")) {
                Color eyeColor = person.getEyeColor();
                person.setEyeColor(input);
                if (person.getEyeColor() == null) {
                    person.setEyeColor(eyeColor);
                    throw new IncorrectValueException("");
                }
            } else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException e) {
            System.out.println("Цвет глаз остался прежним из-за некорректного значения");
        }
        try {
            System.out.print("Введите значение цвета волос человека: ");
            for (Color i: Color.values())
                System.out.print(i.name()+" ");
            System.out.println();
            input = scanner.nextLine();
            if (!input.equals("")) {
                Color hairColor = person.getHairColor();
                person.setHairColor(input);
                if (person.getHairColor() == null) {
                    person.setHairColor(hairColor);
                    throw new IncorrectValueException("");
                }
            } else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException e) {
            System.out.println("Цвет волос остался прежним из-за некорректного значения");
        }
        try {
            System.out.print("Введите национальность человека: ");
            for (Country i: Country.values())
                System.out.print(i.name()+" ");
            System.out.println();
            input = scanner.nextLine();
            if (!input.equals("")) {
                Country nationality = person.getNationality();
                person.setNationality(input);
                if (person.getNationality() == null) {
                    person.setNationality(nationality);
                    throw new IncorrectValueException("");
                }
            } else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException e) {
            System.out.println("Национальность осталась прежней из-за некорректного значения");
        }
        try {
            System.out.println("Введите координату X локации человека: ");
            input = scanner.nextLine();
            if (!input.equals("")) {
                person.getLocation().setX(Integer.parseInt(input));
            } else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException | NumberFormatException e) {
            System.out.println("Некорректно введена координата локации X, поле осталось прежним.");
        }
        try {
            System.out.println("Введите координату Y локации человека: ");
            input = scanner.nextLine();
            if (!input.equals("")) {
                person.getLocation().setY(Float.parseFloat(input));
            } else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException | NumberFormatException e) {
            System.out.println("Некорректно введена координата локации Y, поле осталось прежним.");
        }
        try {
            System.out.println("Введите координату Z локации человека: ");
            input = scanner.nextLine();
            if (!input.equals("")) {
                person.getLocation().setZ(Long.parseLong(input));
            } else System.out.println("Поле не было изменено");
        } catch (IncorrectValueException | NumberFormatException e) {
            System.out.println("Некорректно введена координата локации Z, поле осталось прежним.");
        }
        System.out.println("Обновление параметров человека завершено");
        return person;

    }
}