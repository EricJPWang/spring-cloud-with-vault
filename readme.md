#  Spring Config Server with Vault

## Initialize
Die folgenden Schritte sind notwendig, um einen *Vault* zu initialisieren

1. export VAULT_ADDR="http://127.0.0.1:8200" (Nur wenn SSH nicht verfügbar ist, ansonsten wurde die Adresse https://127.0.0.1:8200 als Standard eingestellt)

2. Vault operator init

3. Unseal vault + login

4. Engine anlegen

5. Policy anpassen

6. User Token anlegen

## Depolyenviroment

Vault unterstüzt auch Deployment-Umgebung. Zum Beispiel bei myapp kann ein Secret unter myapp,dev abgelegt werden.
Dann werden die Werte gelesen, wenn die Umgebung des Clients *dev* ist
