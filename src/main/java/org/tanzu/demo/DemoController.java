package org.tanzu.demo;

import org.tanzu.demo.model.Sensor;
import org.tanzu.demo.model.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Controller
public class DemoController {

    @Autowired
    JdbcTemplate _jdbcTemplate;

    @Autowired
    SensorRepository _sensorRepository;

    @Autowired
    ConfigurableEnvironment _configurableEnvironment;

    @RequestMapping("/")
    public String home(Model model) throws Exception {
        Connection connection = _jdbcTemplate.getDataSource().getConnection();
        model.addAttribute("sensorDB", "Sensor DB: " + connection.getMetaData().getURL());
        connection.close();
        return "index";
    }

    @RequestMapping("/write")
    public @ResponseBody
    Map<String, Object> write() {
        _sensorRepository.save(new Sensor(new Random().nextInt(120) + 170, new Random().nextInt(25000) + 15000));
        return new HashMap<>();
    }

    @RequestMapping("/refresh")
    public @ResponseBody
    Iterable<Sensor> refresh() {
        return _sensorRepository.findAll();
    }
}

