package time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Date;

/**
 * @author zhenghao
 */
public class TimeUtils {

    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(localDateTimeTransform(getEndTimeOfDay(-1)));
        System.out.println(getEndTimeOfDay(-1));
    }

    /**
     * Date转换为LocalDateTime
     */
    public static LocalDateTime dateTransform(Date date){
        return date.toInstant().atOffset(OffsetDateTime.now().getOffset()).toLocalDateTime();
    }

    /**
     * LocalDateTime转换为Date
     */
    public static Date localDateTimeTransform(LocalDateTime localDateTime){
        // 获得 Instant
        Instant instant = Instant.ofEpochSecond(localDateTime.toEpochSecond(OffsetDateTime.now().getOffset()));
        // 获得 Date
        return Date.from(instant);
    }

    /**
     * 获取当天起始时间
     * @param plusDays 增加减少的天数
     * @return
     */
    public static LocalDateTime getBeginTimeOfDay(Integer plusDays){
        return LocalDateTime.of(LocalDate.now().plusDays(plusDays), LocalTime.MIN);
    }

    /**
     * 获取当天结束时间
     * @param plusDays 增加减少的天数
     * @return
     */
    public static LocalDateTime getEndTimeOfDay(Integer plusDays){
        return LocalDateTime.of(LocalDate.now().plusDays(plusDays), LocalTime.MAX);
    }


}
