package com.ptrstovka.calendarview2.decorators;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.ptrstovka.calendarview2.CalendarDay;
import com.ptrstovka.calendarview2.CalendarView2;
import com.ptrstovka.calendarview2.DayViewDecorator;
import com.ptrstovka.calendarview2.DayViewFacade;

import java.util.Date;

public class TodayDecorator extends DayViewDecorator {

    private CalendarDay date;

    public TodayDecorator() {
        date = CalendarDay.today();
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        return date != null && day.equals(date);
    }

    @Override
    public void decorate(DayViewFacade view) {
        view.addSpan(new ForegroundColorSpan(Color.RED));
    }

    /**
     * We're changing the internals, so make sure to call {@linkplain CalendarView2#invalidateDecorators()}
     */
    public void setDate(Date date) {
        this.date = CalendarDay.from(date);
    }
}
