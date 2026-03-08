package com.example.user.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public ModelMapper modeMapper(){
        ModelMapper modelMapper = new ModelMapper();
       /* modelMapper.addMappings(new PropertyMap<Object, User>() {
            @Override
            protected void configure() {
                skip(destination.getUid());
            }
        });*/

        return modelMapper;
    }



}
