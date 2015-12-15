set serveroutput on;
declare
boolean_true boolean := true;
boolean_false boolean := false;
boolean_null boolean;
function boolean_to_varchar2 (flag in boolean) return varchar2 is
begin
return
case flag
when true then 'True'
when false then 'False'
else 'NULL'
end;
end;
begin
DBMS_OUTPUT.PUT_LINE(boolean_to_varchar2(boolean_true));
DBMS_OUTPUT.PUT_LINE(boolean_to_varchar2(boolean_false));
DBMS_OUTPUT.PUT_LINE(boolean_to_varchar2(boolean_null));
end;