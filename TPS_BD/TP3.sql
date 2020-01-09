
--1
SELECT * FROM AirPlane WHERE Capacity > 350 ;
--2
SELECT NumAP, NameAP FROM AirPlane WHERE Localisation = 'Nice' ;
--3
SELECT NumP, Dep_T FROM Flight;
--4
SELECT * FROM Pilot;
--5
SELECT NamePFROM Pilot WHERE Address = 'Paris' AND Salary > 15000
--6
SELECT NumAP, NameAP FROM AirPlane WHERE Localisation = 'Nice' ORCapacity < 350;
--7
SELECT * FROM Flight WHERE Dep_T = ’Nice’ AND Arr_T = 'Paris' ANDArr_H > '18:00:00';
--8
SELECT NumP FROM Pilot WHERE NumP NOT IN (SELECT NumP FROM Flight);
--9
SELECT NumF, Dep_T FROM Flight WHERE NumP = 100 OR NumP = 204 ;




--1

SELECT Personne
FROM Emprunt WHERE Livre = 'Recueil Examens BD'

--2

SELECT Personne FROM Emprunt
WHERE Personne NOT IN
(SELECT Personne FROM Retard)

--3

SELECT t.Personne FROM Emprunt t
WHERE NOT EXISTS ( SELECT * FROM Emprunt u 
	WHERE NOT EXISTS 
      ( SELECT * FROM Emprunt v
        WHERE v.Personne=t.Personne AND v.Livre=u.Livre )

--4

SELECT t.Livre FROM Emprunt t
WHERE NOT EXISTS  ( SELECT * FROM Emprunt u
WHERE NOT EXISTS ( SELECT * FROM Emprunt v
WHERE u.Livre=t.Livre AND v.Personne=u.Personne )

--5

SELECT t.Personne FROM Emprunt t
WHERE NOT EXISTS  (SELECT * FROM Emprunt u              
WHERE u.Personne=t.Personne AND NOT EXISTS (SELECT * FROM Retard v 
WHERE v.Personne=u.Personne AND v.Livre=u.Livre )