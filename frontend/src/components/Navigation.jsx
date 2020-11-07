import * as React from "react";
import { Link } from "react-router-dom";
import {
  Navbar,
  Nav,
} from "react-bootstrap";

class Navigation extends React.Component {
  render() {
    return (
      <div>
        <Navbar bg="light" expand="lg">
          <Navbar.Brand href="/">Wallet</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="mr-auto">
              <Nav.Item className="mr-3">
                <Link to="/allWallets">AllWallets</Link>
              </Nav.Item>
            </Nav>
          </Navbar.Collapse>
        </Navbar>
      </div>
    );
  }
}

export default Navigation;
