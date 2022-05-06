package qr.program.microservice.upload.controller;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import qr.program.microservice.upload.FileUploadApp;

/**
 * @Author qr
 * @Date 2022/5/6-21:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FileUploadApp.class)
@AutoConfigureMockMvc
public class FileUploadControllerTest {

    /**
     * 可以用于测试 controller
     */
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void greetTest() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/greet/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        Assert.assertEquals(result.getResponse().getContentAsString(), "你好哇");
    }



    @Test
    public void test1() {
        String greet = "你好哇";
        System.out.println(greet);
        Assert.assertEquals(greet, "你好哇");
    }
}
