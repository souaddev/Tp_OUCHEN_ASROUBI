
-- Exercice 01

SET SERVEROUTPUT ON
DECLARE  
    a NUMBER := 4 ;
    b NUMBER := 5 ;
    perm NUMBER ;
BEGIN
DBMS_OUTPUT.PUT_LINE ( a ||' ' ||  b ) ;
    perm := a;
    a :=b ;
    b :=perm ; 
DBMS_OUTPUT.PUT_LINE ( a ||' ' || b ) ;
End;

-- Exercice 02

SET SERVEROUTPUT ON
DECLARE 
    a number  := 10 ;
    f number  := 1 ;
    
BEGIN 

    for i IN 1..a loop 
        f := f * i;
    end loop;
DBMS_OUTPUT.PUT_LINE (f);
END ;
/

-- Exercice 03

DECLARE
 v_dept DEPARTMENTS.department_id%type;
BEGIN
    select max(department_id) 
    into v_dept
    from DEPARTMENTS ;
INSERT INTO DEPARTMENTS values ( v_dept+10 , 'Administration' , 145 , 1700) ;
END;
/

-- Exercice 04

DECLARE
 v_dept DEPARTMENTS.department_id%type;
BEGIN
    select max(department_id) 
    into v_dept
    from DEPARTMENTS ;
    
    DBMS_OUTPUT.PUT_LINE ('le plus grand numéro de service est : ' || v_dept);
END;
/

-- Exercice 05

DECLARE
    CURSOR dept_cursor IS
        select *
        from departments 
        where department_id = (select max(department_id) from departments ) ;
    dept_record dept_cursor%ROWTYPE;
begin
    
   FOR dept_record IN dept_cursor LOOP
        IF dept_cursor%notfound then
            DBMS_OUTPUT.PUT_LINE (dept_record.department_id || '  ' || dept_record.department_name || '  ' || dept_record.manager_id || '  ' || dept_record.location_id );
        END IF;
    END LOOP;
end; 
/

-- Exercice 06

DECLARE
 v_dept DEPARTMENTS.department_id%type;
 v_count number;
BEGIN
    select max(department_id) 
    into v_dept
    from DEPARTMENTS ;
    
    UPDATE departments
    SET location_id = 2500
    WHERE department_id= v_dept;
    
    DBMS_OUTPUT.PUT_LINE('Le nombre de lignes affectées : ' || SQL%ROWCOUNT);
END;
/

-- Exercice 07

DECLARE
    v_last_name employees.last_name%type := 'Kochhar' ;
    v_mng employees.manager_id%type;
    v_name_mng employees.last_name%type;
BEGIN
    select manager_id
    into v_mng
    from EMPLOYEES 
    WHERE last_name = v_last_name;
    
    select last_name
    into v_name_mng
    from EMPLOYEES 
    WHERE employee_id = v_mng;
    
    DBMS_OUTPUT.PUT_LINE('Le manager de '|| v_last_name || ' est : ' || v_name_mng);
END;
/

-- Exercice 08

DECLARE
 CURSOR emp_cursor IS 
    SELECT *
    FROM employees
    ORDER BY hire_date DESC;
emp_record employees%ROWTYPE;
BEGIN
    FOR emp_record IN emp_cursor LOOP
        IF emp_cursor%rowcount <=10 THEN
            DBMS_OUTPUT.PUT_LINE(emp_record.last_name || ' ' || emp_record.hire_date);
        END IF;
    END LOOP;
END;
/

-- Exercice 09

DECLARE
    v_count number;
BEGIN
    SELECT count(*)
    into v_count
    from employees
    where department_id = 30;
    
    DBMS_OUTPUT.PUT_LINE('Le nombre de personnes travaillant dans le service 30 : ' || v_count);

END;
/

-- Exercice 10

DECLARE 
    v_salary number ;
    v_name employees.first_name%type;
BEGIN 
    select first_name , salary
    into v_name , v_salary
    from employees
    where salary = v_salary ;

-- Exercice 11
--1

--a
SELECT NomS, Horaire
FROM Salle
WHERE Titre='Les misérables' ;
--b
SELECT acteur
FROM Film
GROUP BY acteur
HAVING COUNT(Titre)=(SELECT COUNT(*)FROM Film)
--c
SELECT spectateur
FROM Vu
GROUP BY spectateur
HAVING COUNT(Titre)=(SELECT COUNT(Titre)
                     FROM Aime
                    GROUP BY Amateur)

--2
DECLARE
    CURSOR real_cursor IS
        select  realisateur ,count(Film) 
        from Film 
        GROUP BY realisateur
    real_record real_cursor%ROWTYPE;
begin

   FOR real_record IN real_cursor LOOP
        IF real_cursor%notfound then
            DBMS_OUTPUT.PUT_LINE ('  Pas de films disponibles !! ');
        ELSE 
              DBMS_OUTPUT.PUT_LINE (' Le réalisateur : ' || real_record.realisateur || ' à réalisé ' || real_record.Titre  );

        END IF;
    END LOOP;
end; 
/


