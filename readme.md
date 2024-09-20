
# GooseGame

### realiser
Le jeu fonctionne parfaitement dans la plupart de ses aspects, cependant, il existe un comportement que je n'ai pas réussi à résoudre. En effet, lorsque le joueur se déplace trop loin,
soit après la fin du plateau, et qu'il revient en arrière sur une case de téléportation, par exemple sur le ClassicalBoard à la case 58, au lieu d'être téléporté à la case 1,
il sera téléporté à une case plus éloignée en raison de la manière dont le calcul de la case d'arrivée du joueur est effectué. 
Je n'ai donc pas résolu le problème, mais l'une de mes idées de réponse aurait été de recréer totalement la manière de déplacer un joueur sur le plateau.
De plus les tests de la class n'a pas été realiser etant donné qu'il n'y a rien a tester.


## Commande

### commande de compilation des fichiers

```bash
  javac -sourcepath src src/goosegame/board/*.java -d classes 
```
```bash
  javac -sourcepath src src/goosegame/cell/*.java -d classes
```
```bash
  javac -sourcepath src src/goosegame/*.java -d classes
```


### commande d'exectuion du main
```bash
  java -classpath classes goosegame.MainGame  
```


### commande de compilation et d'exectuion du jar

```bash
 jar cvfe MainGame.jar goosegame.MainGame 
```
```bash
 java -jar MainGame.jar
```
Le jeu est fait pour etre jouer a une infinité de joueur mais on se bloque avec seulement  2/3/4 joueur si les parametre sont omis ou il y en a plus de 4 alors la partie se joura a 3
exemple de commande de compilation :
```bash
 java -jar MainGame.jar eric ramzi
```
```bash
 java -jar MainGame.jar eric ramzi jamel
```
```bash
 java -jar MainGame.jar eric ramzi jamel louis
```

### commande de compilation et d'exectuion des tests
```bash
javac -classpath junit-console.jar:classes test/goosegame/board/*.java 

```
```bash
javac -classpath junit-console.jar:classes test/goosegame/cell/*.java 

```
```bash
javac -classpath junit-console.jar:classes test/goosegame/*.java 

```

```bash
 java -jar junit-console.jar -classpath test:classes -scan-classpath
```
### commande de generation des docs
```bash
 javadoc -sourcepath src -subpackages goosegame -d docs
```
