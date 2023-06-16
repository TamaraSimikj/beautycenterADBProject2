package com.adb.beautycenter.controllers;//package com.adb.beautycenter.controllers;
//
//import com.adb.beautycenter.repository.UsersRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.SqlOutParameter;
//import org.springframework.jdbc.core.SqlParameter;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.SqlParameterSource;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.Types;
//import java.util.Map;
//
//@Controller
//@RequestMapping("/register")
//public class UserController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @GetMapping
//    public String showRegistrationForm() {
//        return "register";
//    }
//
//    @Autowired
//    private UsersRepository userRepository;
//
//    @PostMapping("/register")
//    public String registerUser(@RequestParam String username,
//                               @RequestParam String password,
//                               @RequestParam String cName,
//                               @RequestParam String surname,
//                               @RequestParam String email,
//                               @RequestParam String phoneNumber) {
//        Integer userId = userRepository.registerClient(username, password, cName, surname, phoneNumber, email);
//
//        // Process the result and redirect accordingly
//        if (userId != null) {
//            // Registration successful, redirect to the home page or a confirmation page
//            return "redirect:/home";
//        } else {
//            // Registration failed, redirect back to the registration form with an error message
//            return "redirect:/register?error";
//        }
//    }
//
////    @PostMapping
////    public String registerUser(@RequestParam String username,
////                               @RequestParam String password,
////                               @RequestParam String cName,
////                               @RequestParam String surname,
////                               @RequestParam String email,
////                               @RequestParam String phoneNumber) {
////
////        // Call the database function
////        registerClient(username, password, cName, surname, phoneNumber, email);
////        return "home";
////    }
//
////    @PostMapping("/register")
////    public String registerUser(@RequestParam String username,
////                               @RequestParam String password,
////                               @RequestParam String cName,
////                               @RequestParam String surname,
////                               @RequestParam String email,
////                               @RequestParam String phoneNumber) {
////        String sql = "{ ? = call \"final\".RegisterClient(?, ?, ?, ?, ?, ?) }";
////        Object[] params = { username, password, cName, surname, phoneNumber, email };
////
////        try {
////            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
////                    .withFunctionName("\"final\".RegisterClient")
////                    .withReturnValue()
////                    .declareParameters(
////                            new SqlParameter("p_username", Types.VARCHAR),
////                            new SqlParameter("p_password", Types.VARCHAR),
////                            new SqlParameter("p_c_name", Types.VARCHAR),
////                            new SqlParameter("p_surname", Types.VARCHAR),
////                            new SqlParameter("p_phone_number", Types.VARCHAR),
////                            new SqlParameter("p_e_mail", Types.VARCHAR));
////
////            long userId = jdbcCall.executeFunction(Long.class, params);
////            // Registration successful, redirect to the home page or a confirmation page
////            return "redirect:/home";
////        } catch (Exception e) {
////            // Registration failed, redirect back to the registration form with an error message
////            return "redirect:/register?error";
////        }
////    }
//
////    @PostMapping("/register")
////    public String registerUser(@RequestParam String username,
////                               @RequestParam String password,
////                               @RequestParam String cName,
////                               @RequestParam String surname,
////                               @RequestParam String email,
////                               @RequestParam String phoneNumber) {
////        String sql = "SELECT \"final\".RegisterClient(?, ?, ?, ?, ?, ?)";
////        Object[] params = { username, password, cName, surname, phoneNumber, email };
////
////        try {
////            jdbcTemplate.update(sql, params);
////            return "redirect:/home";
////        } catch (Exception e) {
////            // Handle any exceptions
////            return "redirect:/register?error";
////        }
////    }
//
//    private int registerClient(String username, String password, String cName, String surname, String phoneNumber, String email) {
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withFunctionName("RegisterClient")
//                .withoutProcedureColumnMetaDataAccess()
//                .declareParameters(
//                        new SqlParameter("p_username", Types.VARCHAR),
//                        new SqlParameter("p_password", Types.VARCHAR),
//                        new SqlParameter("p_c_name", Types.VARCHAR),
//                        new SqlParameter("p_surname", Types.VARCHAR),
//                        new SqlParameter("p_phone_number", Types.VARCHAR),
//                        new SqlParameter("p_e_mail", Types.VARCHAR),
//                        new SqlOutParameter("RETURN_VALUE", Types.INTEGER));
//
//        SqlParameterSource inParams = new MapSqlParameterSource()
//                .addValue("p_username", username)
//                .addValue("p_password", password)
//                .addValue("p_c_name", cName)
//                .addValue("p_surname", surname)
//                .addValue("p_phone_number", phoneNumber)
//                .addValue("p_e_mail", email);
//
//        Map<String, Object> result = jdbcCall.execute(inParams);
//
//        return (int) result.get("RETURN_VALUE");
//    }
//
//}

import com.adb.beautycenter.model.Client;
import com.adb.beautycenter.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Types;
import java.util.Map;

//@Controller
//@RequestMapping("/register")
//public class UserController {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @GetMapping
//    public String showRegistrationForm() {
//        return "register";
//    }
//
//    @PostMapping
//    public ModelAndView registerUser(@ModelAttribute Client client) {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("registerClient");
//        modelAndView.addObject("client",client);
//        return modelAndView;
//    }
//
//    private int registerClient(String username, String password, String cName, String surname, String phoneNumber, String email) {
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withFunctionName("RegisterClient")
//                .withoutProcedureColumnMetaDataAccess()
//                .declareParameters(
//                        new SqlParameter("p_username", Types.VARCHAR),
//                        new SqlParameter("p_password", Types.VARCHAR),
//                        new SqlParameter("p_c_name", Types.VARCHAR),
//                        new SqlParameter("p_surname", Types.VARCHAR),
//                        new SqlParameter("p_phone_number", Types.VARCHAR),
//                        new SqlParameter("p_e_mail", Types.VARCHAR),
//                        new SqlOutParameter("RETURN_VALUE", Types.INTEGER));
//
//        SqlParameterSource inParams = new MapSqlParameterSource()
//                .addValue("p_username", username)
//                .addValue("p_password", password)
//                .addValue("p_c_name", cName)
//                .addValue("p_surname", surname)
//                .addValue("p_phone_number", phoneNumber)
//                .addValue("p_e_mail", email);
//
//        Map<String, Object> result = jdbcCall.execute(inParams);
//
//        return (int) result.get("RETURN_VALUE");
//    }
//}

@Controller
@RequestMapping("/register")
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping
    public ModelAndView registerUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam("c_name") String cName,
            @RequestParam String surname,
            @RequestParam("phone_number") String phoneNumber,
            @RequestParam("e_mail") String email) {

        String insertUserSql = "INSERT INTO USERS (username, upassword) VALUES (?, ?)";
        String insertClientSql = "INSERT INTO CLIENT (UserID, c_name, surname, phone_number, e_mail, number_of_app) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            // Insert user
            jdbcTemplate.update(insertUserSql, username, password);

            // Retrieve the newly created user's ID
            String getUserIdSql = "SELECT lastval()";
            int userId = jdbcTemplate.queryForObject(getUserIdSql, Integer.class);

            // Insert client
            jdbcTemplate.update(insertClientSql, userId, cName, surname, phoneNumber, email, 0);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("registerClient");
            modelAndView.addObject("username", username);
            modelAndView.addObject("cName", cName);
            modelAndView.addObject("surname", surname);
            modelAndView.addObject("phoneNumber", phoneNumber);
            modelAndView.addObject("email", email);
            return modelAndView;
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", "Registration failed");
            return modelAndView;
        }
    }
}