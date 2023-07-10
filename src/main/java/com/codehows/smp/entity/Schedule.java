package com.codehows.smp.entity;

import com.codehows.smp.constant.Role;
import com.codehows.smp.dto.MemberFormDto;
import com.codehows.smp.dto.ScheduleDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="schedule")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Schedule {

    @Id
    @Column(name="schedule_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Date start;

    private Date end;

    private String backgroundColor;

    private String borderColor;

    private Boolean allDay;

    public static Schedule createSchedule(ScheduleDto scheduleDto) {
        return Schedule.builder()
                .title(scheduleDto.getTitle())
                .start(scheduleDto.getStart())
                .end(scheduleDto.getEnd())
                .backgroundColor(scheduleDto.getBackgroundColor())
                .borderColor(scheduleDto.getBorderColor())
                .allDay(scheduleDto.getAllDay())
                .build();
    }

    @Builder
    public Schedule(String title, Date start, Date end,
                    String backgroundColor, String borderColor, Boolean allDay) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.allDay = allDay;
    }
}
