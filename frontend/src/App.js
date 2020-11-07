import React from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

import Navigation from "./components/Navigation";
import AllInfoPage from "./pages/AllInfoPage";
import AllWalletsPage from "./pages/AllWalletsPage";

function App() {
  return (
    <Router>
      <Navigation />
      <div className="container">
        <Switch>
          <Route path="/allInfo" component={AllInfoPage} />
          <Route path="/allWallets" component={AllWalletsPage} />>
        </Switch>
      </div>
    </Router>
  );
}

export default App;
