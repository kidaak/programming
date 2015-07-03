set serveroutput on;
declare
salary number := 20000;
employee_id number := 36325;
bonus_amount number;
begin
bonus_amount:=
case
when salary >= 10000 and salary <= 20000 then 1500
when salary > 20000 and salary <= 40000 then 1000
when salary > 40000 then 500
else 0
end * 10;
dbms_output.put_line(bonus_amount);
end;