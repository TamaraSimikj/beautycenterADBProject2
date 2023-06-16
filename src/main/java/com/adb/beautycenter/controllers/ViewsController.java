package com.adb.beautycenter.controllers;

import com.adb.beautycenter.model.Appointment;
import com.adb.beautycenter.model.views.ManagerCertificateCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/appointments")
public class ViewsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/free")
    public String freeAppointments(Model model) {
        String sql = "SELECT * FROM free_appointments";
        List<Appointment> appointments = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Appointment.class));
        model.addAttribute("appointments", appointments);
        return "free_appointments";
    }

    @GetMapping("/count")
    public String getManagerCertificateCount(Model model) {
        String sql = "SELECT * FROM \"final\".manager_certificate_count";
        List<ManagerCertificateCount> managerCertificates = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ManagerCertificateCount.class));
        model.addAttribute("managerCertificates", managerCertificates);
        return "manager_certificate";
    }

}