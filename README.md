# wallet
e-Wallet project. 

#Project contains 2 subprojects:
* backend - Spring Boot backend to create, delete, top-up and withdraw wallet objects. Uses H2 file database.
* frontend - React App to view, create and delete wallet objects

#Technical Task

Implement e-wallet with REST API to:
- create it,
- top it up,
- check its balance and
- withdraw funds
using Spring (preferably Spring Boot).
Funds on any wallet should not go below zero.
The project should be built with Maven or Gradle and shipped via public
VCS repository (preferably GitHub).

Key points:
- Implement REST API
- Implement database interaction with the domain model
- Implement React UI with the list of wallets and their balances

Bonus points for any of:
- Wallet to wallet transaction - TBD
- Running within Docker infrastructure (Docker file, Docker-compose) - TBD
- Backend test coverage - OK
- Basic endpoint authorization (1 account for all) - TBD
