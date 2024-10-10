package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@RequiredArgsConstructor
public enum ResolutionString {
    TICKS("T", "Tick", "xT"),           // Ticks
    SECONDS("S", "Second", "xS"),       // Seconds
    MINUTES("", "Minute", ""),           // Minutes (không có suffix)
    HOURS(" minutes", "Hour", "x"),     // Hours
    DAYS("D", "Day", "xD"),             // Days
    WEEKS("W", "Week", "xW"),           // Weeks
    MONTHS("M", "Month", "xM"),         // Months
    YEARS("M months", "Year", "xM months"); // Years

    private final String suffix;        // Ký tự bổ sung
    private final String singular;      // Dạng số ít
    private final String format;        // Định dạng

    @JsonValue
    @Override
    public String toString() {
        return name(); // Trả về tên enum
    }

    public String getSymbol() {
        return suffix; // Trả về ký tự bổ sung
    }

    public static String format(int value, ResolutionString resolution) {
        // Thêm ký tự cho các kiểu khác
        return value + resolution.suffix; // Chỉ số cho minutes
    }
    @JsonCreator
    public static ResolutionString fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }

        String trimmedValue = value.toUpperCase();
        String letterPart = trimmedValue.replaceAll("[0-9]", ""); // Lấy phần chữ
        String numberPart = trimmedValue.replaceAll("[^0-9]", ""); // Lấy phần số

        // Kiểm tra xem phần chữ có hợp lệ không
        ResolutionString resolution;
        try {
            resolution = switch (letterPart) {
                case "TICKS", "T" -> TICKS;
                case "SECONDS", "S" -> SECONDS;
                case "MINUTES" -> MINUTES;
                case "HOURS", "H" -> HOURS;
                case "DAYS", "D" -> DAYS;
                case "WEEKS", "W" -> WEEKS;
                case "MONTHS", "M" -> MONTHS;
                case "YEARS", "Y" -> YEARS;
                default -> throw new IllegalArgumentException("Unknown resolution: " + letterPart);
            };
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Unknown resolution: " + letterPart);
        }

        // Nếu có phần số, bạn có thể xử lý ở đây hoặc lưu nó để sử dụng sau này
        int numberValue = numberPart.isEmpty() ? 1 : Integer.parseInt(numberPart);

        // Trả về enum tương ứng
        return resolution;
    }
    public static ResolutionString parse(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        // Tách số và ký tự
        String numberPart = input.replaceAll("[^0-9]", "");
        String letterPart = input.replaceAll("[0-9]", "").toUpperCase();

        // Kiểm tra xem ký tự có hợp lệ không
        ResolutionString resolution = fromString(letterPart);

        // Xử lý số nếu cần (số này có thể dùng trong logic khác)
        int numberValue = numberPart.isEmpty() ? 1 : Integer.parseInt(numberPart);

        // Bạn có thể thêm logic xử lý ở đây nếu cần
        return resolution;
    }
}


