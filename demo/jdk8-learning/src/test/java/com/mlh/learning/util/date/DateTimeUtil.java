package com.mlh.learning.util.date;

import com.mlh.learning.util.DateUtil;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.Date;

public class DateTimeUtil {

    @Test
    public void test() {
        Date monthAgo = DateUtil.getDateBefore(new Date(), 29);
        Date start = DateUtil.getDateStart(monthAgo);

        String startDate = DateUtil.getStringDateByFormat(start, "yyyy-MM-dd");
        String endDate = DateUtil.getStringDateByFormat(new Date(), "yyyy-MM-dd");
        int startTime = (int) (start.getTime() / 1000L);

        System.out.println(monthAgo);
        System.out.println(start);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(startTime);
    }

    @Test
    public void testAll() {
        Date current = new Date();
        Date monthAgo = DateUtil.getDateBefore(current, 29);
        Date start = DateUtil.getDateStart(monthAgo);
        String startDate = DateUtil.getStringDateByFormat(start, "yyyy-MM-dd");
        int startTime = (int) (start.getTime() / 1000L);
        String endDate = DateUtil.getStringDateByFormat(current, "yyyy-MM-dd");

        System.out.println(monthAgo);
        System.out.println(start);
        System.out.println(startDate);
        System.out.println(endDate);
        System.out.println(startTime);
    }

    @Test
    public void testJodaAll() {
        Date start;
        Date end;

            start = DateTime.now().minusDays(29).withTimeAtStartOfDay().toDate();

            end = DateTime.now().toDate();

        System.out.println(start);
        System.out.println(end);
    }
}
