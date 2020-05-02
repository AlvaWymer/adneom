package com.adneom;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
//@RunWith(SpringRunner.class)
@Transactional
@TestPropertySource(
    locations = "classpath:application-dev.yml")
public abstract class AbstractTest {
    // TODO
//    @BeforeEach
//    protected void init() {
//        Account account = new Account();
//        account.setId("ROOT");
//        User.setAccount(account);
//
//        Mockito.when(emailRepository.findAll(any())).thenReturn(Collections.singletonList("yangnaihua@gmail.com"));
//    }
}
