package cn.truthseeker.web;

import cn.truthseeker.service.DayService;
import cn.truthseeker.template.Day;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @author: qiang.fang
 * @email: lowping@163.com
 * @date: Created by on 19/4/29
 */
@RestController
public class First {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DayService dayService;

    @RequestMapping("/day/{id}")
    public String first(@PathVariable(name = "id") String id) {
        LOG.info("get {}", id);
        return Day.render(dayService.getDay(id));
    }
}
