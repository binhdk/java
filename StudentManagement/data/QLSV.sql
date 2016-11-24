use master
create database QLSV
use QLSV
create table SV
(
   MASV char(3),
   TENSV varchar(30),
   TENLP varchar(30),
   NGAY date,
   DIACHI varchar(30),
   primary key (MASV)
)
set dateformat dmy
drop table SV;
insert SV values ('S01','Nguyen Van Binh','KM14B','17/09/1996','DAK NONG')
insert SV values ('S02','Tran Trong Dao','KM14','23/05/1996','QUANG TRI')
insert SV values ('S03','Pham Quang Tho','CN14B','02/02/1996','QUANG TRI')
insert SV values ('S04','Nguyen Duy Thien','KM14B','27/06/1996','BINH DINH')
insert SV values ('S05','Bui Hoang Duc','KM14B','06/10/1996','DONG NAI')
insert SV values ('S10','Bui Hoang Duc','KM14B','06/10/1996','DONG NAI')
select * from SV
----------------=====================--------------------------
create table BANGDIEM
(
   MASV char(3),
   MALP varchar(3),
   MAMH char(3),
   DIEM int,
   primary key (MASV,MAMH)
)
drop table BANGDIEM;
insert BANGDIEM values ('S01','L01','M01',9)
insert BANGDIEM values ('S01','L01','M02',8)
insert BANGDIEM values ('S01','L01','M03',8)
insert BANGDIEM values ('S02','L02','M01',7)
insert BANGDIEM values ('S02','L02','M02',8)
insert BANGDIEM values ('S02','L02','M03',8)
insert BANGDIEM values ('S03','L01','M01',8)
insert BANGDIEM values ('S03','L01','M02',7)
insert BANGDIEM values ('S03','L01','M03',8)
insert BANGDIEM values ('S04','L02','M01',5)
insert BANGDIEM values ('S04','L02','M02',8)
insert BANGDIEM values ('S04','L02','M03',8)
insert BANGDIEM values ('S05','L01','M01',6)
insert BANGDIEM values ('S05','L01','M02',8)
insert BANGDIEM values ('S05','L01','M03',8)
insert BANGDIEM values ('S10','L01','M01',6)
insert BANGDIEM values ('S10','L01','M02',9)
insert BANGDIEM values ('S10','L01','M03',8)


select * from BANGDIEM WHERE MASV='S04'
UPDATE BANGDIEM  SET DIEM= 5 WHERE MASV='S04'AND MAMH='M01'
select * from BANGDIEM WHERE MASV='S10'
---------------===================------------------
create table MONHOC
(
   MAMH char(3),
   TENMH varchar(30),
   SOTC int,
   primary key (MAMH)
)
drop table MONHOC;
insert MONHOC values ('M01','Lap trinh java',3)
insert MONHOC values ('M02','Lap trinh android',2)
insert MONHOC values ('M03','Lap trinh web',2)
----------------------==================--------------------
create table LOP
(
   MALP char(3),
   TENLP varchar(30),
   primary key (MALP)
)
drop table LOP
insert LOP values ('M01','KM14B')
insert LOP values ('M02','CN14B')
insert LOP values ('M03','KM14')


select *
from BANGDIEM
where DIEMMON1=6


select *
from LOP

ALTER TABLE SV
ADD [Nguyen Van A] varchar(30)
