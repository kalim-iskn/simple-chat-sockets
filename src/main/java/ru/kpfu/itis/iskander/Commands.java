package ru.kpfu.itis.iskander;

public enum Commands {

    EXIT ("<exit>");

    private String name;

    Commands(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
