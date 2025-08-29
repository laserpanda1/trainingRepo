package com.laserpanda1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

import java.util.List;

@Data
@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "app.sbip.ct")
public class AppProperties {

    private final String name;

    private final String ip;

    private final int port;

    private final Security security;

    @Override
    public String toString() {
        return "AppProperties{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", security=" + security +
                '}';
    }


    @Data
    @AllArgsConstructor
    @Getter
    public static class Security {
        private boolean enabled;

        private final String token;

        private final List<String> roles;

        @Override
        public String toString() {
            return "Security{" +
                    " enabled=" + enabled +
                    " token=" + token +
                    " roles" + roles + '}';
        }
    }
}
