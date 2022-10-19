package BankAccount.BankAccountManager.Controller;

import BankAccount.BankAccountManager.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
    private static final String API_CLIENT_DEPOSIT = "/client/deposit";
    private static final String API_CLIENT_WITHDRAW = "/client/withDraw";
    @MockBean
    private ClientService clientService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_ok_status_when_successful_deposit () throws Exception {
        String operationRequest = "{\"clientId\": \"\", \"amount\": 100}";
        mockMvc.perform(MockMvcRequestBuilders.post(API_CLIENT_DEPOSIT)
                        .content(operationRequest)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_return_ok_status_when_successful_withdraw () throws Exception {
        String operationRequest = "{\"clientId\": \"\", \"amount\": 100}";
        mockMvc.perform(MockMvcRequestBuilders.post(API_CLIENT_WITHDRAW)
                        .content(operationRequest)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
