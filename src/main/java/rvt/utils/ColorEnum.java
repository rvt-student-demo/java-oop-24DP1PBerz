package rvt.utils;

public enum ColorEnum {
    RESET("\u001B[0m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    BLUE("\u001B[34m"),
    YELLOW("\u001B[33m"),
    PURPLE("\u001B[35m"),
    WHITE("\u001B[37m"),
    BLACK("\u001B[30m");

    public final String colorCode;
    ColorEnum(String colorCode) {
        this.colorCode = colorCode;
    }
}
