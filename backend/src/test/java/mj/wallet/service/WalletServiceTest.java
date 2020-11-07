package mj.wallet.service;
import lombok.extern.slf4j.Slf4j;
import mj.wallet.domain.WalletEntity;
import mj.wallet.exception.NotFoundException;
import mj.wallet.exception.ServiceException;
import mj.wallet.repository.WalletRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
public class WalletServiceTest{

    @InjectMocks
    WalletService walletService;

    @Mock
    WalletRepository walletRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks( this );
    }

    @Test
    public void getWalletOk(){
        WalletEntity walletEntity = new WalletEntity( "test", 0 );
        log.info( "walletEntity: " + walletEntity );
        when( walletRepository.findById( 0 ) ).thenReturn( java.util.Optional.of( walletEntity ) );

        Optional<WalletEntity> result = walletService.getWallet( 0 );
        log.info( "result: " + result );
        assertEquals( 0, result.get().getBalance(), 0 );
    }

    @Test
    public void getWalletWithNotFoundException(){
        WalletEntity walletEntity = new WalletEntity( "test", 0 );
        System.out.println( "walletEntity: " + walletEntity );
        when( walletRepository.findById( 0 ) ).thenReturn( java.util.Optional.of( walletEntity ) );

        Exception e = assertThrows( NotFoundException.class, () -> {
            walletService.getWallet( 1 );
        } );

        log.info( "e.getMessage(): " + e.getMessage() );
        assertTrue( e.getMessage().contains( "Wallet with id: 1 not found" ) );
    }

    @Test
    public void topUpWalletOK(){
        WalletEntity walletEntity = new WalletEntity( "test", 0 );
        log.info( "walletEntity: " + walletEntity );
        when( walletRepository.findById( 0 ) ).thenReturn( java.util.Optional.of( walletEntity ) );

        WalletEntity result = walletService.topUpWallet( 0, 1 );
        log.info( "result: " + result );
        assertTrue( result.getBalance() > 0 );
    }

    @Test
    public void topUpWalletWithInvalidSumException(){
        WalletEntity walletEntity = new WalletEntity( "test", 0 );
        System.out.println( "walletEntity: " + walletEntity );
        when( walletRepository.findById( 0 ) ).thenReturn( java.util.Optional.of( walletEntity ) );

        Exception e = assertThrows( ServiceException.class, () -> {
            walletService.topUpWallet( 0, 0 );
        } );

        log.info( "e.getMessage(): " + e.getMessage() );
        assertTrue( e.getMessage().contains( "Top-up sum must be greater than 0" ) );
    }

    @Test
    public void withdrawWalletOk(){
        WalletEntity walletEntity = new WalletEntity( "test", 1 );
        System.out.println( "walletEntity: " + walletEntity );
        when( walletRepository.findById( 0 ) ).thenReturn( java.util.Optional.of( walletEntity ) );

        WalletEntity result = walletService.withdrawWallet( 0, 1 );
        log.info( "result: {}", result );
        assertEquals( 0, result.getBalance(), 0 );
    }

    @Test
    public void withdrawWalletWithInvalidSumException(){
        WalletEntity walletEntity = new WalletEntity( "test", 0 );
        System.out.println( "walletEntity: " + walletEntity );
        when( walletRepository.findById( 0 ) ).thenReturn( java.util.Optional.of( walletEntity ) );

        Exception e = assertThrows( ServiceException.class, () -> {
            walletService.withdrawWallet( 0, 1 );
        } );

        log.info( "e.getMessage(): " + e.getMessage() );
        assertTrue( e.getMessage().contains( "Not enough funds to withdraw account" ) );
    }

}