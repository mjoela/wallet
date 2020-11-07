import API from "../util/ApiUtil";

class WalletService {

  static getAllWallets = () =>
    API.get(`/wallets`).then((response) => response.data.reverse());

  static addWallet = (wallet) =>
    API.post(`/wallet`, wallet).then((response) => response.data);

  static deleteWallet = (walletId) =>
    API.delete(`/wallet/${walletId}`).then((response) => response.data);
}

export default WalletService;
