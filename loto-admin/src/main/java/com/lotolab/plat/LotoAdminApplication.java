package com.lotolab.plat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = { DataSourceAutoConfiguration.class },
        scanBasePackages = {"com.lotolab.plat"}
)
public class LotoAdminApplication {
    public static void main(String[] args) {

        SpringApplication.run(LotoAdminApplication.class, args);

        System.out.println("(♥◠‿◠)ﾉﾞ  乐通平台启动成功   ლ(´ڡ`ლ)ﾞ  \n"+
                "                    .--.             \n"+
                "  ☹      **========/ ★ \\           \n"+
                " `|`;            \"-=4==6==-.        \n"+
                "_/ \\_          (O_o_o_o_o_o_O)      \n"
        );
    }

}