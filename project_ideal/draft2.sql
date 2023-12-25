--create database draft2
--use draft2

--drop table Renter
--drop table Role
--drop table [User]
--drop table Car
create table Renter(
RenterID int primary key,
--UserID int foreign key references [User](UserID)
RenterName nvarchar(10)
)
--insert into Renter values(1,'Chu xe')
create table Car(
CarID int primary key IDENTITY(1,1),
--UserID int foreign key references [User](UserID),
--RenterID int foreign key references Renter(RenterID),
CarOwner nvarchar(30),
CarBrandID int,
CarName varchar(30),
CarPricePerDay int,
FuelType nvarchar(20),
CarLicense varchar(15)
)

create table [Role](
RoleID int primary key,
RoleName varchar(10)
)
--insert into [Role] values(0,'user')
--insert into [Role] values(1,'admin')

create table [User](
UserID int primary key IDENTITY(1,1),
UserName varchar(30),
[Password] varchar(10),
FullName nvarchar(30),
PhoneNumber varchar(15),
[Address] nvarchar(100),
CitizenId varchar(20),
RoleID int foreign key references [Role](RoleID),
RenterID int foreign key references [Renter](RenterID)
)
--insert into [User](UserName,[Password],FullName,PhoneNumber,[Address],CitizenID,RoleID) values('duong',123,'LE KHAI DUONG',0359166800,'YB','01520100',0)
--insert into [User](UserName,[Password],FullName,PhoneNumber,[Address],CitizenID,RoleID) values('hung',123,'NGO NGOC HUNG',0969696969,'PT','0153004',0)

--select * from [User]
--select * from Car
--select * from Renter
--select * from [Role]

