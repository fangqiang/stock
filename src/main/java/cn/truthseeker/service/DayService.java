package cn.truthseeker.service;

import cn.truthseeker.container.safe.Collections2;
import cn.truthseeker.container.safe.Maps;
import cn.truthseeker.container.util.Assert;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: qiang.fang
 * @email: lowping@163.com
 * @date: Created by on 19/4/29
 */
@Service
public class DayService {
    public String getDay(String id){
        try {
            List<String> lines = FileUtils.readLines(new File("data/"+id +".csv"), StandardCharsets.UTF_8);
            List<Map<String,String>> table = linesToTable(lines);
            List<String> scheme = Arrays.asList("date", "open", "close", "lowest", "highest");
            List<List<String>> collect = table.stream()
                    .map(m -> Collections2.map(m::get, scheme))
                    .collect(Collectors.toList());

            return collect.toString();
        } catch (IOException e) {
            throw new RuntimeException("read data error");
        }
    }

    static List<Map<String,String>> linesToTable(List<String> lines){
        Assert.isTrue(lines.size() > 1, "no data");

        List<String> scheme = line2List(lines.get(0));

        return lines.stream()
                .skip(1)
                .map(line -> Maps.zip(scheme, line2List(line)))
                .collect(Collectors.toList());
    }

    static List<String> line2List(String line){
        return Stream.of(line.split(","))
                .map(f -> f != null ? f.trim() : null)
                .collect(Collectors.toList());
    }
}
