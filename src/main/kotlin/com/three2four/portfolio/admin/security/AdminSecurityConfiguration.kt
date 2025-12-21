package com.three2four.portfolio.admin.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter

@Configuration
class AdminSecurityConfiguration {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun filterChain(httpSecurity: HttpSecurity):SecurityFilterChain{
        return httpSecurity
                .authorizeHttpRequests {authorizeHttpRequest->
                    authorizeHttpRequest
                            .requestMatchers("/admin/**").authenticated()
                            .anyRequest().permitAll()
                }.csrf{csrf->csrf.disable()}
                .headers{headers->headers.addHeaderWriter(XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN
                ))}
                .formLogin{formLogin->
                    formLogin.defaultSuccessUrl("/admin")
                }.logout{logout->
                    logout.logoutUrl("/admin/logout")
                            .logoutSuccessUrl("/")
                }.build()
    }

}
