package com.thoughtworks.ketsu.web;

import com.thoughtworks.ketsu.domain.Product.Product;
import com.thoughtworks.ketsu.infrastructure.repositories.ProductRepository;
import com.thoughtworks.ketsu.support.ApiSupport;
import com.thoughtworks.ketsu.support.ApiTestRunner;
import com.thoughtworks.ketsu.support.TestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * Created by zyongliu on 16/7/28.
 */
@RunWith(ApiTestRunner.class)
public class ProductApiTest extends ApiSupport{
    @Inject
    ProductRepository productRepository;

    @Test
    public void return_201_when_POST_products_with_parameters() {
        Response post = post("/products", TestHelper.productMap());
        assertThat(post.getStatus(), is(201));
    }

    @Test
    public void return_400_when_POST_fails() {
        Response post = post("/products", TestHelper.productfailMap());
        assertThat(post.getStatus(), is(400));
    }

    @Test
    public void return_product_when_GET_product_by_productid() {
        Map<String,Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        int productid = TestHelper.obj2int(productinfo.get("id"));
        Response get = get("/products/"+productid);
        Map product = get.readEntity(Map.class);
        assertThat(product.get("name"),is("food"));
    }

    @Test
    public void return_404_when_GET_product_by_productid_fails() {
        Response get = get("/products/a");
        assertThat(get.getStatus(),is(404));
    }

    @Test
    public void return_products_when_GET_products() {
        Map<String,Object> productinfo = TestHelper.productMap();
        productRepository.createProduct(productinfo);
        Response get = get("/products");
        List<Map> productList = get.readEntity(List.class);
        assertThat(productList.get(0).get("name"), is("food"));
    }
}
