CREATE TABLE CLIENT (code_client number(5) primary key,nom_client varchar2(10),prenom_client varchar2(10),email varchar2(50),
                      password varchar2(20),
                      code_panier number(5),
                       constraint fk_panier foreign key (code_panier) references PANIER(code_panier));

CREATE TABLE PANIER (code_panier number(5) primary key,
code_client number(5)
);

alter TABLE panier add constraint fk_client foreign key (code_client) references CLIENT(code_client);

CREATE TABLE CATEGORIE (code_categorie number(5) primary key,
libelle_categorie varchar2(10));

CREATE TABLE PRODUIT (code_produit number(10) primary key,
code_categorie number(5),
libelle_produit varchar2(25),
stock_produit number(5),
constraint fk_categorie foreign key (code_categorie) references CATEGORIE(code_categorie));

CREATE TABLE COMMANDE (code_produit number(10),
                       code_panier number(5),
                       quantite number(5),
                       constraint pk_commande primary key (code_produit,code_panier),
                       constraint fk_produit foreign key (code_produit) references PRODUIT(code_produit),
                       constraint fk_panier2 foreign key (code_panier) references PANIER (code_panier));



CREATE SEQUENCE client_seq 
minvalue 1
start with 1
increment by 1
cache 20;


CREATE SEQUENCE categorie_seq 
minvalue 1
start with 1
increment by 1
cache 20;

CREATE SEQUENCE produit_seq 
minvalue 1
start with 1
increment by 1
cache 20;

CREATE SEQUENCE panier_seq 
minvalue 1
start with 1
increment by 1
cache 20;