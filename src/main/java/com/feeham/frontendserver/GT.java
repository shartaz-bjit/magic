package com.feeham.frontendserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class GT {
    @GetMapping("/T")
    public String T(){
        try {
            //English to IGBO
            System.out.println(GoogleTranslate.translate("ig", "how are you"));

            //English to GREEK
            System.out.println(GoogleTranslate.translate("el", "how are you"));

            //English to HAUSA
            System.out.println(GoogleTranslate.translate("ha", "how are you"));

            //English to Yoruba
            return GoogleTranslate.translate("bn", "how are you");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "done";
    }
}
