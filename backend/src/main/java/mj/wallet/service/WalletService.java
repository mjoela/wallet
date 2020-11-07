package mj.wallet.service;
import lombok.extern.slf4j.Slf4j;
import mj.wallet.domain.WalletEntity;
import mj.wallet.exception.NotFoundException;
import mj.wallet.exception.ServiceException;
import mj.wallet.model.WalletBody;
import mj.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class WalletService{

    @Autowired
    WalletRepository walletRepository;

    public WalletEntity createWallet( WalletBody walletBody ){
        WalletEntity walletEntity = new WalletEntity( walletBody.getName(), walletBody.getBalance() );
        walletRepository.save( walletEntity );
        return walletEntity;
    }

    public List<WalletEntity> listWallets(){
        return walletRepository.findAll();
    }

    public Optional<WalletEntity> getWallet( Integer id ){
        Optional<WalletEntity> wallet = walletRepository.findById( id );
        if( !wallet.isPresent() )
            throw new NotFoundException( "Wallet with id: " + id + " not found" );

        return wallet;
    }

    public WalletEntity topUpWallet( Integer id, float sum ){
        if( sum <= 0 )
            throw new ServiceException( "Top-up sum must be greater than 0" );

        Optional<WalletEntity> wallet = walletRepository.findById( id );
        if( !wallet.isPresent() )
            throw new NotFoundException( "Wallet with id. " + id + " not found" );

        WalletEntity walletEntity = wallet.get();
        walletEntity.setBalance( walletEntity.getBalance() + sum );
        walletRepository.save( walletEntity );

        return walletEntity;
    }

    public WalletEntity withdrawWallet( Integer id, float sum ){
        if( sum <= 0 )
            throw new ServiceException( "Withdraw sum must be greater than 0" );

        Optional<WalletEntity> wallet = walletRepository.findById( id );
        if( !wallet.isPresent() )
            throw new NotFoundException( "Wallet with id. " + id + " not found" );

        WalletEntity walletEntity = wallet.get();
        if( walletEntity.getBalance() - sum < 0 )
            throw new ServiceException( "Not enough funds to withdraw account" );

        walletEntity.setBalance( walletEntity.getBalance() - sum );
        walletRepository.save( walletEntity );

        return walletEntity;
    }

    public WalletEntity deleteWallet( Integer id ){
        Optional<WalletEntity> wallet = walletRepository.findById( id );
        if( !wallet.isPresent() )
            throw new NotFoundException( "Wallet with id. " + id + " not found" );

        WalletEntity walletEntity = wallet.get();
        walletRepository.deleteById( id );
        return walletEntity;
    }

}
