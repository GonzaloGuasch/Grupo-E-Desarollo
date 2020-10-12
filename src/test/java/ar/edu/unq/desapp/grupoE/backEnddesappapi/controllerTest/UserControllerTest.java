package ar.edu.unq.desapp.grupoE.backEnddesappapi.controllerTest;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import ar.edu.unq.desapp.grupoE.backEnddesappapi.model.User;
import ar.edu.unq.desapp.grupoE.backEnddesappapi.webservice.UserController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        assertThat(this.userController).isNotNull();
    }

    @Test
    public void get_all_user_from_endpoint() throws Exception {
        this.mockMvc.perform(get("/user/all"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void post_new_user() throws Exception {
        String path = "/user/create";
        User user_to_create = new User("prueba", "email@prueba.com", "1234", "prueba");
        ObjectMapper om = new ObjectMapper();
        om.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = om.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(user_to_create);

        this.mockMvc.perform(post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andExpect(status().isOk());
    }

}

