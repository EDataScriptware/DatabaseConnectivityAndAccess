/* NAME: Edward Riley */
/* PROFESSOR: Stephen Zilora */ 
/* ASSIGNMENT: PE01 */
/* DATE: 1/21/2020 */

/* Q1 */
SELECT * FROM passenger INNER JOIN zips ON passenger.zip = zips.zip ORDER BY lname;

/* Q2 */
SELECT tripnum, departuretime, departureloccode FROM trip_directory inner JOIN tripcodes ON trip_directory.triptype = tripcodes.triptype WHERE typename = "Bus";

/* Q3 */
SELECT CONCAT(FName, ' ', LName) as "Passengers" FROM trip_people LEFT JOIN passenger ON trip_people.PassengerID = passenger.PassengerID WHERE MONTH(Date) = 10;

/* Q4 */
SELECT Location, COUNT(DepartureLocCode) AS 'Number of Departures' FROM locations INNER JOIN trip_directory ON locations.LocationCode = trip_directory.DepartureLocCode GROUP BY DepartureLocCode ORDER BY Location ASC;

/* Q5 */ 
SELECT DISTINCT Name from staff INNER JOIN trip ON staff.tripnum = trip.tripnum WHERE DepartureLocCode = "BOS";

/* Q6 */
SELECT tripnum, CONCAT(fname, " ", lname) as "People from Frankfort" FROM trip_people INNER JOIN passenger ON trip_people.passengerID = passenger.passengerID INNER JOIN zips ON passenger.zip = zips.zip where zips.city = "Frankfort";

/* Q7 - RESOLVED */
SELECT FName, LName FROM zips INNER JOIN passenger ON zips.zip = passenger.zip INNER JOIN trip_people ON passenger.passengerid = trip_people.passengerid INNER JOIN trip ON trip_people.tripnum = trip.tripnum INNER JOIN trip_directory ON trip.tripnum = trip_directory.tripnum INNER JOIN tripcodes ON trip_directory.triptype = tripcodes.triptype WHERE tripcodes.typename = "Bus" AND zips.city = "Rochester";

/* Q8 */
SELECT equipmentdescription from passenger INNER JOIN trip_people ON passenger.passengerID = trip_people.passengerID INNER JOIN trip ON trip_people.TripNum = trip.tripnum INNER JOIN equipment ON trip.EquipID = equipment.equipid WHERE CONCAT(FName, LName) = "CurtisBrown";

/* Q9 */
UPDATE equipment SET EquipmentDescription = "Mid-Range" WHERE EquipmentName = "Boeing 767";

/* Q10 */
SELECT equipment.equipID, equipmentName, COUNT(trip.equipID) AS NumTrips from equipment LEFT JOIN trip on equipment.equipid = trip.equipid GROUP BY trip.equipID;