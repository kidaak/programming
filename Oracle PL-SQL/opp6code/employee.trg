CREATE OR REPLACE TRIGGER EMPLOYEE_bir
  BEFORE INSERT ON EMPLOYEE
  FOR EACH ROW
DECLARE
BEGIN
   IF :NEW.EMPLOYEE_ID IS NULL
   THEN
      :NEW.EMPLOYEE_ID := EMPLOYEE_CP.next_key;
   END IF;
  :new.CREATED_ON := SYSDATE;
  :new.CREATED_BY := USER;
  :new.CHANGED_ON := SYSDATE;
  :new.CHANGED_BY := USER;
END EMPLOYEE_bir;
/

CREATE OR REPLACE TRIGGER EMPLOYEE_bur
  BEFORE UPDATE ON EMPLOYEE
  FOR EACH ROW
DECLARE
BEGIN
  :new.CHANGED_ON := SYSDATE;
  :new.CHANGED_BY := USER;
END EMPLOYEE_bur;
/