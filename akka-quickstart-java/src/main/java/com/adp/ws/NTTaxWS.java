package com.adp.ws;

import oracle.jdbc.proxy.annotation.Post;
import org.springframework.stereotype.Component;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;

@Path("/fileimport")
@Component("taxfilenotificationws")
public class NTTaxWS {

    @Path("/v1/notify")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public String noitification(String payload) {
        return "success";
    }
}
