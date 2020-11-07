import * as React from "react";
import Wallet from "../components/Wallet";
import WalletService from "../service/WalletService";

class AllWalletsPage extends React.Component {
  state = {
    allWallets: [],
    name: "",
    balance: "",
  };

  constructor(props) {
    super(props);
    this.state = {
      allWallets: [],
      name: "",
      balance: "",
    };
  }

  componentDidMount() {
    this.getAllWallets();
  }

  getAllWallets = () => {
    WalletService.getAllWallets().then((response) =>
      this.setState({
        allWallets: response,
      })
    );
  };

  resetInputs = () => {
    this.setState({
      name: "",
      balance: "",
    });
  };

  handleKeyUp = (e) => {
    if (e.key === "Enter") {
      this.addNewWallet();
    }
  };

  handleNameChange = (event) => {
    this.setState({
      name: event.currentTarget.value,
    });
    console.log("handleNameChange");
    console.log(this.state.name);
  };

  handleBalanceChange = (event) => {
    this.setState({
      balance: event.currentTarget.value,
    });
    console.log("handleBalanceChange");
    console.log(this.state.balance);
  };

  addWallet = (event) => {
    event.preventDefault();
    WalletService.addWallet({
      name: this.state.name,
      balance: this.state.balance,
    })
      .then(this.resetInputs())
      .then(this.getAllWallets())
      .then(window.location.reload(false));
  };

  render() {
    return (
      <form>
        <input
          id="name-input"
          type="text"
          className="form-control"
          placeholder="Name"
          aria-label="Name"
          aria-describedby="basic-addon1"
          value={this.state.name}
          onChange={this.handleNameChange}
        />
        <input
          id="balance-input"
          type="text"
          className="form-control"
          placeholder="Balance"
          aria-label="Balance"
          aria-describedby="basic-addon1"
          value={this.state.balance}
          onChange={this.handleBalanceChange}
        />
        <button
          type="submit"
          className="btn btn-primary"
          onClick={this.addWallet}
        >
          Add wallet
        </button>

        {this.state.allWallets.map((wallet, key) => (
          <Wallet key={key} walletProps={wallet} />
        ))}
        <br></br>
      </form>
    );
  }
}

export default AllWalletsPage;
