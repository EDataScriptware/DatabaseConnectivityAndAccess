drop procedure if exists addPass;
delimiter //
create procedure addPass(
	In newID int(11),
    In newFname varchar(50),
    In newLname varchar(50),
	In newStreet varchar(50),
    In newCity varchar(100),
    In newState char(2),
    In newZip varchar(5),
    In newPhoneNum varchar(15),
    In newPhoneType varchar(50)
)
begin

INSERT INTO passenger VALUES(newID, newFname, newLname, newStreet, newZip);

INSERT INTO zips VALUES(newZip, newCity, newState);

INSERT INTO phones VALUES(newID, newPhoneNum, NewPhoneType);

end
//
delimiter ;

show create procedure addPass;

call addPass(11, "Amina", "Mahmood", "6000 Reynold", "Rochester", "NY", "14620", "347-698-5357", "Cell");