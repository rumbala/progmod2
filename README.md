# Parking API

Az API feladata, az információ szolgáltatás egy multinacionális cég parkolóházairól.

## GET requests

### getAllParkolo
Az elérhet összes parkolót adja vissza JSONObjectként.

### Szabadhely/{id}
A megadott ID alapján, visszaadja a parkolóban elérhető szabad helyek számát.
## POST request
A webfejlesztői eszközben próbáltam POST kérést küldeni, viszont többszöri próbálkozásra is 415-ös híbát kaptam. Így ezt egyelőre nem sikerült megcsinálni.
### vehicleEnterParkolo
Amikor a parkolóba beérkezik egy új jármű, azt a rendszernek jelzi és egyel kevesebb szabad hely lesz.
### vehicleLeaveParkolo
Amikor elhagyja a parkolót egy jármű, azt a rendszernek jelzi és egyel több szabad hely lesz.