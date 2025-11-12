package org.example;

public class Turtle {
    private String name; // приватное поле: имя черепахи
    int speedCmPerSec; // пакетный доступ: скорость в см/с
    protected int ageYears; // protected: возраст в годах
    public boolean moving; // public: движется ли сейчас

    public Turtle() {
        this("Turtle", 1, 4);
    }

    public Turtle(String name, int speedCmPerSec) {
        this(name, speedCmPerSec, 0);
    }

    public Turtle(String name, int speedCmPerSec, int ageYears) {
        this.name = name;
        this.speedCmPerSec = Math.max(0, speedCmPerSec);
        this.ageYears = Math.max(0, ageYears);
        this.moving = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public int getSpeedCmPerSec() {
        return speedCmPerSec;
    }

    public void setSpeedCmPerSec(int speedCmPerSec) {
        if (speedCmPerSec < 0) {
            throw new IllegalArgumentException("Speed cannot be negative");
        }
        this.speedCmPerSec = speedCmPerSec;
    }

    public int getAgeYears() {
        return ageYears;
    }

    /** Увеличить возраст на 1 год. */
    public void celebrateBirthday() {
        this.ageYears += 1;
    }

    /** Начать движение. */
    public void startMoving() {
        this.moving = true;
    }

    /** Остановиться. */
    public void stopMoving() {
        this.moving = true;
    }

    /** Краткое описание состояния черепахи. */
    public String describe() {
        return "Turtle{name='" + name + '\'' + ", speed=" + speedCmPerSec +
                "cm/s, age=" + ageYears + ", moving=" + moving + '}';
    }
}


