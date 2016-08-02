package com.thoughtworks.ketsu.web.jersey;

import com.thoughtworks.ketsu.domain.Product.Product;
import com.thoughtworks.ketsu.domain.User.User;

import javax.ws.rs.core.UriInfo;
import java.net.URI;

public class Routes {

    private String baseUri;

    public Routes(UriInfo uriInfo) {
        baseUri = uriInfo.getBaseUri().toASCIIString();
    }

}
