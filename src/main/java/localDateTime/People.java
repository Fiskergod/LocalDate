package localDateTime;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter

public class People {
    private String name;
    private LocalDate regDate;
    private LocalTime regTime;

    public People(String name, LocalDate regDate, LocalTime regTime) {
        this.setName(name);
        this.setRegDate(regDate);
        this.setRegTime(regTime);
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Incorrect data!");
        }
        this.name = name;
    }

    public LocalDate setRegDate(LocalDate regDate) {
        if (regDate == null) {
            throw new IllegalArgumentException("Incorrect data!");
        }
        this.regDate = regDate;
        return regDate;
    }

    public LocalTime setRegTime(LocalTime regTime) {
        if (regTime == null) {
            throw new IllegalArgumentException("Incorrect data!");
        }
        this.regTime = regTime;
        return regTime;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Дата регистрации: " + regDate + ", Время регистрации: " + regTime;
    }
}