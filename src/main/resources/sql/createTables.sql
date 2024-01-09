CREATE TABLE IF NOT EXISTS Currencies (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	Code TEXT NOT NULL UNIQUE,
	FullName TEXT NOT NULL,
	Sign TEXT NOT NULL
)

PRAGMA foreign_keys;

PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS ExchangeRates (
	ID INTEGER PRIMARY KEY AUTOINCREMENT,
	BaseCurrencyId INTEGER NOT NULL,
	TargetCurrencyId INTEGER NOT NULL,
	Rate REAL NOT NULL,
	UNIQUE (BaseCurrencyId, TargetCurrencyId),
	FOREIGN KEY (BaseCurrencyId)
       REFERENCES Currencies (ID),
    FOREIGN KEY (TargetCurrencyId)
       REFERENCES Currencies (ID)
)