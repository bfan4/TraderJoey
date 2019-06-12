create database traderjoey;
use traderjoey;
create table user(
   ID   INT              NOT NULL AUTO_INCREMENT,
   NAME VARCHAR (20)     NOT NULL,
   PASSWORD VARCHAR (20)     NOT NULL,
   BALANCE  DOUBLE              NOT NULL,  
   PRIMARY KEY (ID)
);
