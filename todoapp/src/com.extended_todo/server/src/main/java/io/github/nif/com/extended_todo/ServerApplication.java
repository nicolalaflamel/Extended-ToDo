package io.github.nif.com.extended_todo;

import com.canoo.platform.remoting.server.spring.DolphinPlatformRemotingApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@DolphinPlatformRemotingApplication
public class ServerApplication extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class[]{ServerApplication.class}, args);
    }
}

