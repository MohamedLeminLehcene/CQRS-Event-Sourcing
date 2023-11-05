<h2>Compte rendu pour réaliser une application qui permet de gérer des comptes respectant les patterns CQRS et Event Sourcing avec les Framework AXON et Spring Boot :</h2>
<h3>Captures </h3>

<ul>

<li>Créer un compte avec Postman</li>
<br>
<img src="./IMG/img00.png"/>
<hr/>

<li>Voici Base Données qui créer persistance par FrameWork Axone avec Tableau : domain_evnt_entry contient tous les évenement qui ont réaliser par l'applications.</li>
<br>
<img src="./IMG/img01.png"/>
<hr/>
<li>Voici le contenu du tableau account qui contient listes des comptes qui sont réaliser depuis Postman</li>
<img src="./IMG/img02.png"/>
<hr/>

<li>Voici les contenu du tableau domain_event_entry qui conient l'ensemble des évenement qui sont réaliser sur la compte l'un Created et la secomde Activated.</li>
<img src="./IMG/img04.png"/>

<hr/>
<li>Voici le contenu du payload qui contient des informations sur l'évenement AccountCreatedEvent.</li>
<img src="./IMG/img22.png"/>

<hr/>
<li>Voici le contenu du payload qui contient des informations sur l'évenement AccountActivatedEvent.</li>
<img src="./IMG/img000.png"/>

<hr/>
<li>Contenu du event Strore</li>
<br>
<img src="./IMG/img07.png"/>
<hr/>
<li>Pour effectuer les operations du modifications sur base de données comme : update,delete</li>
<br>
<img src="./IMG/img08.png"/>
<hr/>
<li>Pour efectuer opérations crédit sur compte, mais la valeur du l'attribut amount doit ne doit pas étre un  valeur négative.</li>
<br>
<img src="./IMG/img09.png"/>
<hr/><li>Crédit un  compte est effectuent</li>
<img src="./IMG/img10.png"/>
<hr/>
<li>La valeur de l'attribut amount avent Crédit égale 9000 MD.</li>
<img src="./IMG/img11.png"/>
<br>
<hr/>
<li>Voci aprés Crédit du compte à partir du Postman la valeur du amount pour compte devient 1000 MD.</li>
<br>
<img src="./IMG/img12.png"/>
<hr/>
<li>L'operation du type Crédit qu'on a effecute sur le compte par son ID.</li>
<img src="./IMG/img13.png"/>
<hr/>
<li>Voici contenu de ventStore.</li>
<img src="./IMG/img16.png"/>
<hr/>
<li>On essye de faire l'opération Crédit sur un compte mais la valeur d'amount n'est pas suffisant</li>
<br>
<img src="./IMG/img19.png"/>
<hr/>
<li>On essye de faire l'opération Crédit sur un compte mais la valeur d'amount ne doit pas étre négative</li>
<img src="./IMG/img20.png"/>
<hr/>
<li>Liste des comptes avec leur opérations</li>
<img src="./IMG/img21.png"/>
<hr/>
</ul>









