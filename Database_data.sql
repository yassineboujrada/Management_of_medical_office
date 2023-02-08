--------------------------- Creation of Tables  ---------------------------

create table clients(
    id number(20),
    version number(11),
    titre VARCHAR2(5),
    nom VARCHAR2(30),
    prenom VARCHAR2(30)
);
create table medecins(
    id number(20),
    version number(11),
    titre VARCHAR2(5),
    nom VARCHAR2(30),
    prenom VARCHAR2(30)
);

create table creneaux(
    id number(20),
    version number(11),
    hedebut number(11),
    mdebut number(11),
    hfin number(11),
    mfin number(11),
    med number(20)
);

create table rv(
    id number(20),
    jour Date DEFAULT SYSDATE,
    client number(20),
    crenaux number(20)
);

--------------------------- Adding Necessairy Constraints of Tables  ---------------------------

alter table clients add constraint cl_pk primary key(id);
alter table medecins add constraint med_pk primary key(id);

alter table creneaux add constraint cre_pk primary key(id);
alter table creneaux add constraint cre_fk FOREIGN KEY(med) REFERENCES medecins(id) ON DELETE CASCADE;

alter table rv add constraint rv_pk primary key(id);
alter table rv add constraint rv_fk FOREIGN KEY(client) REFERENCES clients(id) ON DELETE CASCADE;
alter table rv add constraint rv2_fk FOREIGN KEY(crenaux) REFERENCES creneaux(id) ON DELETE CASCADE;

----------------------------       Insert Our Data       ----------------------------------------

-- Client :
insert into clients (id, version, titre, nom, prenom) values (1, 1, 'Mr', 'Manolo', 'Toffts');
insert into clients (id, version, titre, nom, prenom) values (2, 2, 'Mr', 'Barry', 'Dunbleton');
insert into clients (id, version, titre, nom, prenom) values (3, 3, 'Rev', 'Magdalena', 'Stacy');
insert into clients (id, version, titre, nom, prenom) values (4, 4, 'Ms', 'Glad', 'Pearson');
insert into clients (id, version, titre, nom, prenom) values (5, 5, 'Mr', 'Freddie', 'Borel');
insert into clients (id, version, titre, nom, prenom) values (6, 6, 'Ms', 'Nikolaus', 'Sodeau');
insert into clients (id, version, titre, nom, prenom) values (7, 7, 'Mr', 'Jobye', 'Kovacs');
insert into clients (id, version, titre, nom, prenom) values (8, 8, 'Ms', 'Grissel', 'Knifton');
insert into clients (id, version, titre, nom, prenom) values (9, 9, 'Mr', 'Josiah', 'Burghill');
insert into clients (id, version, titre, nom, prenom) values (10, 10, 'Mr', 'Auria', 'Varsey');
insert into clients (id, version, titre, nom, prenom) values (11, 11, 'Rev', 'Kaela', 'Caulier');
insert into clients (id, version, titre, nom, prenom) values (12, 12, 'Rev', 'Ellerey', 'Balstone');
insert into clients (id, version, titre, nom, prenom) values (13, 13, 'Mr', 'Marice', 'Dudley');
insert into clients (id, version, titre, nom, prenom) values (14, 14, 'Mr', 'Vivian', 'McGrowther');
insert into clients (id, version, titre, nom, prenom) values (15, 15, 'Ms', 'Godiva', 'Newitt');
insert into clients (id, version, titre, nom, prenom) values (16, 16, 'Mr', 'Leonhard', 'Lowers');
insert into clients (id, version, titre, nom, prenom) values (17, 17, 'Mr', 'Lynnett', 'Chafney');
insert into clients (id, version, titre, nom, prenom) values (18, 18, 'Mr', 'Prinz', 'Duetsche');
insert into clients (id, version, titre, nom, prenom) values (19, 19, 'Mr', 'Milt', 'Cockrell');
insert into clients (id, version, titre, nom, prenom) values (20, 20, 'Rev', 'Elberta', 'Paull');

-- Medcins :
insert into medecins (id, version, titre, nom, prenom) values (1, 1, 'Dr', 'Pepi', 'Warricker');
insert into medecins (id, version, titre, nom, prenom) values (2, 2, 'Mr', 'Darb', 'Dimitrescu');
insert into medecins (id, version, titre, nom, prenom) values (3, 3, 'Dr', 'Niki', 'Bragger');
insert into medecins (id, version, titre, nom, prenom) values (4, 4, 'Dr', 'Osbourne', 'Fenners');
insert into medecins (id, version, titre, nom, prenom) values (5, 5, 'Dr', 'Chaim', 'Bloore');
insert into medecins (id, version, titre, nom, prenom) values (6, 6, 'Dr', 'Rutter', 'Gainseford');
insert into medecins (id, version, titre, nom, prenom) values (7, 7, 'Dr', 'Tony', 'Plaxton');
insert into medecins (id, version, titre, nom, prenom) values (8, 8, 'Dr', 'Shannen', 'Garioch');
insert into medecins (id, version, titre, nom, prenom) values (9, 9, 'Dr', 'Orton', 'Askin');
insert into medecins (id, version, titre, nom, prenom) values (10, 10, 'Dr', 'Gayla', 'Ginity');
insert into medecins (id, version, titre, nom, prenom) values (11, 11, 'Dr', 'Elinore', 'Nisco');
insert into medecins (id, version, titre, nom, prenom) values (12, 12, 'Mr', 'Ringo', 'Drews');
insert into medecins (id, version, titre, nom, prenom) values (13, 13, 'Dr', 'Lindon', 'McGonagle');
insert into medecins (id, version, titre, nom, prenom) values (14, 14, 'Dr', 'Lorelle', 'Grunson');
insert into medecins (id, version, titre, nom, prenom) values (15, 15, 'Dr', 'Hobey', 'Kirrens');
insert into medecins (id, version, titre, nom, prenom) values (16, 16, 'Dr', 'Lynnette', 'Martinovsky');
insert into medecins (id, version, titre, nom, prenom) values (17, 17, 'Dr', 'Tansy', 'Macak');
insert into medecins (id, version, titre, nom, prenom) values (18, 18, 'Dr', 'Alfreda', 'Armfield');
insert into medecins (id, version, titre, nom, prenom) values (19, 19, 'Dr', 'Riobard', 'Fulop');
insert into medecins (id, version, titre, nom, prenom) values (20, 20, 'Dr', 'Ban', 'Backes');
commit;