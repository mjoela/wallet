package mj.wallet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;

@SpringBootTest
class WalletApiTest{

    @Autowired
    WalletApi walletApi;

    @Test
    void contextLoads(){
        assertNotNull( walletApi );
    }

}
