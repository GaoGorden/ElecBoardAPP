package com.smile.calendar.format;

import android.support.annotation.NonNull;

import org.joda.time.LocalDate;

public interface Formatter {

    String getDayName(@NonNull LocalDate date);
    String getHeaderText(int type, @NonNull LocalDate from, @NonNull LocalDate to, @NonNull LocalDate selected);

}
