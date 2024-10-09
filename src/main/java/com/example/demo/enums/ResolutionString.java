package com.example.demo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResolutionString {

    TICK_1("1T"),
    TICK_5("5T"),
    TICK_100("100T"),
    SECOND_1("1S"),
    MINUTE_1("1"),
    HOUR_60("60"),
    DAY_1("1D"),
    WEEK_1("1W"),
    MONTH_1("1M"),
    YEAR_12_MONTHS("12M");

    private final String value;

}
