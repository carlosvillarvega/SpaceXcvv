# SpaceXcvv

Questo progetto consiste in uno programa su java che principalemente faccia tre funzioni:

1-Cercare tutti i tweet che contengono riferimenti a SpaceX

2-Statistica sul numero di tweets con immagini

3-Statistica su le parole più comuni (numeri di volte che compaiono)



### I file java necessari: 

-SpaceXApplication.java

-ApplicationController.java

-ImageStatistics.java

-Tweet.java

-WordStatistics.java

-TweetParser.java

![Diagrama:](https://raw.githubusercontent.com/carlosvillarvega/SpaceXcvv/master/Diagramma.jpg)


(In precedenza realizzata la richiesta dell'API di Twitter su: https://developer.twitter.com/en/docs/tweets/search/api-reference/get-search-tweets )

## FUNZIONAMENTO:

1.Iniziare java 

2.Quando charica tutto su le console, vai a Postman

3.Postman fare la richiesta GET verso la URL: ("/spaceXTweets/stats/images"), aggiuggendo avanti il luogo dove è funzionando il java (http://localhost8080/)

4.Premi il botone SEND di postman che corri e invia il resultato di tweets con la sua data, ID e testo.
(Ha uno limite di novanta tweets)

Tutti sono uguali processi, dovrebbe cambiare solo la URL


#### Diagramma delle sequenze

![Diagrama:](https://raw.githubusercontent.com/carlosvillarvega/SpaceXcvv/master/sequenza.png)


#### Diagrammi degli tre casi d'uso



###### Tweets che contengano SpaceX

![Diagrama:](https://raw.githubusercontent.com/carlosvillarvega/SpaceXcvv/master/utilizocaso1.png)



###### Numero di tweets con immagine

![Diagrama:](https://raw.githubusercontent.com/carlosvillarvega/SpaceXcvv/master/utilizocaso2.png)



###### Statistica su le parole più comune

![Diagrama:](https://raw.githubusercontent.com/carlosvillarvega/SpaceXcvv/master/utilizzo3.png)


