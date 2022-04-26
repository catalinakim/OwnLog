package com.catalina.ownlog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    //글쓰기 페이지
    @GetMapping("/write")
    public String post() {
        return "write.html";
//        return "write";
//        return "redirect:studentNg";
    }

    //글보기 페이지
    @GetMapping("/viewPost")
//    public String viewPost(@PathVariable Long id) {  // /viewPost/2 안되서 아래로 함
    public String viewPost(@RequestParam Long id) {
        return "board.html?id="+id;
//        model.addAttribute("id", id);
//        return "board";
//        html에서 타임리프th
    }

    //글수정 페이지
    @GetMapping("/edit")
    public String edit(@RequestParam Long id) {
        return "edit.html?id="+id;
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/signup")
    public String signup() {
        return "signup.html";
    }
}

