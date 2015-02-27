# Rakennekuvaus

Peli rakentuu suurilta osin Game luokan ympärille. Game luo framen ja käynnistää pelin sekä sisältää pelin pääloopin.
Peli päivittyy 60 kertaa sekunnissa. Jokaisella päivityksellä ensin hoidetaan ohjelmalogiikka, sitten lisätään viivettä jos jäi aikaa jäljelle, ja lopuksi piirretään.

Suurimman osan pelilogiikasta hoitaa stackallax.handlers paketin sisällä olevat luokat. Obstacle ja Player luokat mallintavat interaktiivisia peliobjekteja ja sisältävät omaan liikkumiseensa liittyviä toimintoja.
Ohjelmalogiikan päivitysjärjestys:
* BackgroundManager pitää huolen taustojen luonnista ja liikkumisesta
* Player päivittää pelaajan sijainnin
* ObstacleManager luo uusia Obstacleja, pitää niistä luvun ja käskee niitä päivittymään
	* Obstaclet siirtyvät ObstacleManagerin pyynnöstä
* CollisionDetector valvoo pelaajan interaktiota objektejen ja ympäristön (maa ja painovoima) kanssa
* ScoreManager laskee pelaajan pisteitä ja hoitaa niiden I/O:n pelin päätyttyä