package com.udacity.gradle.builditbigger.backend;

import com.glaserproject.joketeller.Teller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /** A simple default endpoint method that takes a name and says Hi back */
    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        response.setData("Hi, " + name);

        return response;
    }

    //method that returns joke from jokeTeller library
    @ApiMethod(name = "getJoke")
    public MyBean getJoke(){
        MyBean response = new MyBean();
        //get joke from joke Teller
        response.setData(new Teller().tellJoke());
        return response;

    }

}
