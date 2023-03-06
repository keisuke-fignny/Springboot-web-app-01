package com.example.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    //@Autowired
    //private JdbcTemplate jdbc;

    @GetMapping("")
    public String index(){

        /* データ抽出テスト
        String query = "select * from user";
        List<Map<String, Object>> users = jdbc.queryForList(query);

        for(var a : users){
            System.out.println(a.get("name"));
        }*/

        return "home/index";
    }


}
