package com.db.design_patterns.deligate;

import lombok.Data;
import lombok.experimental.Delegate;


@Data
public class RadioAlarm implements Radio, Alarm {

    @Delegate(excludes = AlarmExcusions.class)
    private Alarm alarm;
    @Delegate
    private Radio radio;

    public RadioAlarm(Alarm alarm, Radio radio) {
        this.alarm = alarm;
        this.radio = radio;
    }

    @Override
    public void stopAlarm() {

    }
}
