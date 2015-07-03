set serveroutput on;
begin
goto second_output;
dbms_output.put_line('This line will never execute.');
<<second_output>>
dbms_output.put_line('We are here!');
end;