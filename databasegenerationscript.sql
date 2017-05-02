drop database Industree;

CREATE DATABASE if not exists Industree;

use Industree;


CREATE TABLE `UserRole_tbl` (
  `userRoleId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userRoleId`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;


CREATE TABLE `User_tbl` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userRoleId` int(11) DEFAULT NULL,
  `firstName` varchar(100) NOT NULL,
  `middleName` varchar(100) DEFAULT NULL,
  `lastName` varchar(100) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `dateOfBirth` datetime NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `emailAddress` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  KEY `userRoleId` (`userRoleId`),
  CONSTRAINT `user_tbl_ibfk_1` FOREIGN KEY (`userRoleId`) REFERENCES `UserRole_tbl` (`userRoleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Employee_tbl` (
  `employeeId` varchar(100) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `designation` varchar(100) NOT NULL,
  `department` varchar(100) NOT NULL,
  `dateOfJoining` datetime NOT NULL,
  `workContact` varchar(50) NOT NULL,
  `managerId` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`employeeId`),
  KEY `userId` (`userId`),
  CONSTRAINT `employee_tbl_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `User_tbl` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `Notification_tbl` (
  `notificationId` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(1000) DEFAULT NULL,
  `employeeId` varchar(100) NOT NULL,
  `senderId` varchar(100) DEFAULT NULL,
  `dateSent` datetime DEFAULT NULL,
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;



CREATE TABLE `ClaimStatus_tbl` (
  `claimStatusId` int(11) NOT NULL AUTO_INCREMENT,
  `claimStatus` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`claimStatusId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `EmployeeLeave_tbl` (
  `employeeLeaveId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeId` varchar(100) DEFAULT NULL,
  `startDate` varchar(1000) DEFAULT NULL,
  `endDate` varchar(1000) DEFAULT NULL,
  `appliedDate` varchar(1000) DEFAULT NULL,
  `approvedDate` varchar(1000) DEFAULT NULL,
  `leaveStatusId` int(11) DEFAULT NULL,
  `leavecomment` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`employeeLeaveId`),
  CONSTRAINT `employeeleavestatus_tbl_ibfk_1` FOREIGN KEY (`leaveStatusId`) REFERENCES `ClaimStatus_tbl` (`claimStatusId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


CREATE TABLE `EmployeeClaim_tbl` (
  `employeeClaimId` int(11) NOT NULL AUTO_INCREMENT,
  `employeeId` varchar(100) DEFAULT NULL,
  `claimItemType` varchar(100) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `purchaseDate` varchar(1000) DEFAULT NULL,
  `appliedDate` varchar(1000) DEFAULT NULL,
  `approvedDate` varchar(1000) DEFAULT NULL,
  `claimStatusId` int(11) DEFAULT NULL,
  `claimComment` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`employeeClaimId`),
  CONSTRAINT `EmployeeClaim_tbl_ibfk_1` FOREIGN KEY (`claimStatusId`) REFERENCES `ClaimStatus_tbl` (`claimStatusId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


create table MachineType_tbl
(
	machineTypeId int  not null auto_increment,
    machineTypeName varchar(100),
    primary key(machineTypeId)
    );


create table MachineLineStatus_tbl(

machineLineStatusId int auto_increment,
machinelineStatus varchar(100),
primary key (MachineLineStatusId)
);
 

CREATE TABLE `WorkingMachineLineStatus_tbl` (
  `workingMachineLineStatusId` int(11) NOT NULL AUTO_INCREMENT,
  `lineId` int(11) DEFAULT NULL,
  `startPosition` int(11) DEFAULT NULL,
  `endPosition` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `machineType` varchar(100) DEFAULT NULL,
  `employeeId` varchar(100) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`workingMachineLineStatusId`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


INSERT INTO USERROLE_TBL(name) values('FACTORYEMPLOYEE');
INSERT INTO USERROLE_TBL(name) values('FACTORYMANAGER');
INSERT INTO USERROLE_TBL(name) values('SALESMANAGER');
INSERT INTO USERROLE_TBL(name) values('HRMANAGER');
INSERT INTO USERROLE_TBL(name) values('ADMIN');



insert into user_tbl(userRoleId, firstName, lastName, address, dateOfBirth, password, username, emailAddress)
values(4, 'James', 'Marsden', 'Colorado', '1994-1-1 00:00:00.00', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 'HRJM2903@riomhaire.com','HRJM2903@riomhaire.com');

insert into user_tbl(userRoleId, firstName, lastName, address, dateOfBirth, password, username, emailAddress)
values(5, 'Tamara', 'Shurtz', 'Colorado', '1994-1-1 00:00:00.00', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8',  'ADTS2903@riomhaire.com','ADTS2903@riomhaire.com');


insert into user_tbl(userRoleId, firstName, lastName, address, dateOfBirth, password, username, emailAddress)
values(2, 'Shawn', 'Mendes', 'Colorado', '1992-1-1 00:00:00.00', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','FMSM8903@riomhaire.com','FMSM8903@riomhaire.com');


insert into user_tbl(userRoleId, firstName, lastName, address, dateOfBirth, password, username, emailAddress)
values(1, 'Steve', 'Carley', 'Colorado', '1994-1-1 00:00:00.00', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8','FESC3403@riomhaire.com' ,'FESC3403@riomhaire.com' );	



insert into Employee_tbl(employeeId,userId, designation,department,dateOfJoining, workContact )
values('HRJM2903', 1, 'HRManager', 'HR', '2015-09-09 00:00:00.00', 1234);


insert into Employee_tbl(employeeId,userId, designation,department,dateOfJoining, workContact )
values('ADTS2903', 2, 'Admin', 'HR', '2015-09-09 00:00:00.00', 1234);


insert into Employee_tbl(employeeId,userId, designation,department,dateOfJoining, workContact )
values('FMSM8903', 3, 'FactoryManager', 'MANUFACTURING', '2015-09-09 00:00:00.00', 1234);


insert into Employee_tbl(employeeId,userId, designation,department,dateOfJoining, workContact )
values('FESC3403', 4, 'FactoryEmployee', 'MANUFACTURING', '2015-09-09 00:00:00.00', 1234);
<<<<<<< HEAD
=======

>>>>>>> eff5f984161851fd7260e7d96956b8d6060bfb79


insert into MachineLineStatus_tbl(machinelineStatus)
values('Working');

insert into MachineLineStatus_tbl(machinelineStatus)
values('Malfunction');

insert into MachineLineStatus_tbl(machinelineStatus)
values('Low');

insert into MachineLineStatus_tbl(machinelineStatus)
values('Off');




insert into MachineType_tbl(machineTypeName)
values('Electronics');

insert into MachineType_tbl(machineTypeName)
values('Screen');

insert into MachineType_tbl(machineTypeName)
values('Battery');

insert into MachineType_tbl(machineTypeName)
values('Casing');


insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FESC3403', 100, 122, 220, 'Working', 'Electronics');
insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FESC3403', 122, 139, 90, 'Malfunction', 'Casing');
insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FESC3403', 20, 40, 92, 'Stock Low', 'Screen');
insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FESC3403', 100, 231, 23, 'Working', 'Battery');

insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FMSM8903', 100, 122, 220, 'Working', 'Electronics');
insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FMSM8903', 122, 139, 90, 'Malfunction', 'Casing');
insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FMSM8903', 20, 40, 92, 'Stock Low', 'Screen');
insert into WorkingMachineLineStatus_tbl(lineId, employeeId, startPosition,endPosition, stock,  status, machineType)
values(2, 'FMSM8903', 100, 231, 23, 'Working', 'Battery');


insert into ClaimStatus_tbl(claimStatus)
values('APPLIED');
insert into ClaimStatus_tbl(claimStatus)
values('PENDING');
insert into ClaimStatus_tbl(claimStatus)
values('APPROVED');

