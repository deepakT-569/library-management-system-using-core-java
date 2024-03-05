# library-management-system-using-core-java
Library management System 
#Technology used : 
JAVA (CORE JAVA ,JDBC) , MYSQL.  

#DataBase Tables :
1. member :
member_id int(10),
member_name varchar(100),
DOJ date,

2. books :
isbn_code varchar(50),
book_name varchar(100),
book_desc varchar(1000),
author_name varchar(100),
subject_name varchar(100),
units_available int(5),

3.member_book_record :
rec_id int(18),
member_id int(10),
isbn_code varchar(50),
doi date,
dor date,

#Files :
DB properties file
#Classes :
1.UserMenu,
2.LibUtils,
3.Books,
4.Member,
5.LibFunction,
6.AddBookMenu,
7.AddMemberMenu,
