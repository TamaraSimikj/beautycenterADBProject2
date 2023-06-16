package com.adb.beautycenter.controllers;

import com.adb.beautycenter.model.Beautycenter;
import com.adb.beautycenter.model.views.ListService;
import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class ServiceController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/services/{id}")
    public String getServicesByBeautyCenter(@PathVariable int id, Model model) {
        String sql = "SELECT id, service_category, \"value\" FROM \"final\".services WHERE bcID = ?";
        List<ListService> services = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<>(ListService.class));
        model.addAttribute("services", services);
        return "services";
    }
    //500 error na templejtot


    @GetMapping("/beautycenters")
    public String getAllBeautyCentres(Model model) {
        String sql = "SELECT * FROM \"final\".beautycenter";
        List<Beautycenter> bc = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Beautycenter.class));
        model.addAttribute("beautyCenters", bc);
        return "beautycenters";
    }
}
