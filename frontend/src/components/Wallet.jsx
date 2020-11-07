import * as React from "react";
import { Card } from "react-bootstrap";
import WalletService from "../service/WalletService";

class Wallet extends React.Component {
  deleteWallet = () => {
    WalletService.deleteWallet(this.props.walletProps.id).then(
      window.location.reload(false)
    );
  };

  render() {
    return (
      <div>
        <Card className="mt-2">
          <Card.Body className="blockquote text-center">
            Name: {this.props.walletProps.name} <br />
            Balance: {this.props.walletProps.balance} <br />
          </Card.Body>

          <div className="">
            <button
              type="button"
              className="btn btn-outline-danger btn-sm float-right"
              onClick={this.deleteWallet}
            >
              Delete
            </button>
          </div>
        </Card>
      </div>
    );
  }
}

export default Wallet;
