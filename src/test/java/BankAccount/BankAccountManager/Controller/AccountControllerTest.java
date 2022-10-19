package BankAccount.BankAccountManager.Controller;

import BankAccount.BankAccountManager.controller.AccountController;
import BankAccount.BankAccountManager.service.AccountService;
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
public class AccountControllerTest {
    private static final String API_ACCOUNT_DEPOSIT = "/account/deposit";
    private static final String API_ACCOUNT_WITHDRAW = "/account/withDraw";
    @MockBean
    private AccountService accountService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_ok_status_when_successful_deposit () throws Exception {
        String operationRequest = "{\"accountId\": \"\", \"amount\": 100}";
        mockMvc.perform(MockMvcRequestBuilders.post(API_ACCOUNT_DEPOSIT)
                .content(operationRequest)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void should_return_ok_status_when_successful_withDraw () throws Exception {
        String operationRequest = "{\"accountId\": \"\", \"amount\": 100}";;
        mockMvc.perform(MockMvcRequestBuilders.post(API_ACCOUNT_WITHDRAW)
                        .content(operationRequest)
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
