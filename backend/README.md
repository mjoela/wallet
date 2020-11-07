
# e-Wallet REST API

# Running locally
```
  ./gradlew bootRun
```

# API documentation
```
  localhost:8080
```

# DB admin
```
  H2 console: http://localhost:8080/h2-console
  JDBC URL: ./data/wallet
  user: sa
  pwd: sa
```

# Testing and commit
Run both Unit and Integration test before commit
```
  ./gradlew test
  ./gradlew integTest
```

# Code formatting
Code formatting rules:
* IntelliJ IDEA
	* Key map: File > Settings > Editor > Code Style > Scheme > Import Scheme > IntelliJ IDEA code style XML
	* Path: /cfg/intelliJ-code-style.xml
