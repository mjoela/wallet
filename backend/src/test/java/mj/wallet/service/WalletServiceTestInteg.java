package mj.wallet.service;
import lombok.extern.slf4j.Slf4j;
import mj.wallet.domain.WalletEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletServiceTestInteg{

    @Autowired
    WalletService walletService;

    @Test
    public void listWallets(){
        List<WalletEntity> result = walletService.listWallets();
        log.info( "result: {}", result );
        assertTrue( !result.isEmpty() );
    }

}