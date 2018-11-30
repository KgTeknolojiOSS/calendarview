package com.ptrstovka.calendarview2.decorators;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;

import com.ptrstovka.calendarview2.CalendarDay;
import com.ptrstovka.calendarview2.DayViewDecorator;
import com.ptrstovka.calendarview2.DayViewFacade;

import java.util.Calendar;

public class WeekendsDecorator extends DayViewDecorator {
    private final Calendar calendar = Calendar.getInstance();
    private final Drawable highlightDrawable;
    private static final int color = Color.parseColor("#9c9da2");

    public WeekendsDecorator() {
        highlightDrawable = new ColorDrawable(color);
    }

    @Override
    public boolean shouldDecorate(CalendarDay day) {
        day.copyTo(calendar);
        int weekDay = calendar.get(Calendar.DAY_OF_WEEK);
        return weekDay == Calendar.SATURDAY || weekDay == Calendar.SUNDAY;
    }

    @Override
    public void decorate(DayViewFacade view) {
        TextPaint orange = new TextPaint();
        orange.setColor(color);
        view.addSpan(new ForegroundColorSpan(color));
        view.addSpan(orange);
    }
}
