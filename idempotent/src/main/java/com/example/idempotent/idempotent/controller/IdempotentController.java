package com.example.idempotent.idempotent.controller;

import com.example.idempotent.idempotent.annotation.PreventDuplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/web")
public class IdempotentController {

    @PostMapping("/sayNoDuplication")
    @PreventDuplication(expireSeconds = 8)
    public String sayNoDuplication(@RequestParam("requestNum") String requestNum) {
        log.info("sayNoDuplicatin requestNum：{}", requestNum);
        return "sayNoDuplicatin".concat(requestNum);
    }

}
