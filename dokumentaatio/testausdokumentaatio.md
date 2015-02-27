# Testausdokumentaatio

Stackallax sisältää hyvin vähän testejä, sillä suurimmalla osalla metodeista on erittäin näkyvä vaikutus pelin kulkuun ja mahdolliset virheet ovat näin oten todella helppoja huomata.

Manuaalinen testaus on hoitunut helposti yksinkertaisesti pelaamalla peliä.

Testit:
* TestEntity
	* testGetMovement
	* testSetXAndSetY
* TestPlayer
	* testConstructor
	* testGetMovement
	* testSetXAndSetY
* TestBackground
	* testSetX
	* testSetY
* TestBackGroundManager
	* testInit
	* testMovement
	* testMovementOutOfScreen
	* testScrollingSpeed
	* testGetBackgrounds
* TestCollisionDetector
	* playerIsOnGroundLevel
	* playerIsFalling
* TestObstacleManager
	* [poistettu, reworkin aikaan]
* TestScoreManager
	* testIncrease
	* testSetScore
* TestVector2
	* testConstructor
	* testAdd
	* testMultiply
	* testSetXAndSetY
	
Alueita jotka saattavat vaatia testaamista:
* CollisionDetector.update()
	* metodi sisältää suuren if-monsterin
* ObstacleManager.runSpawner()
	* (hankala testata satunnaisuuden vuoksi)

Tunnettu heikko koodauksen taso:
* BackgroundManager täynnä copypastaa
	
Tunnetut bugit:
* Ylhäältä putoava esteen sivulle osuvaa pelaaja ei rekisteröidä häviöksi
	* CollisionDetector:50