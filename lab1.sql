#1.1-1select Staff_Name as name, Design_Code as code from staff_master where Hiredate<STR_TO_DATE('Jan-2003','%M-%Y') and Staff_sal between 12000 and 25000;
#1.1-2select Staff_Code, Staff_Name, Dept_Code from staff_master where (year(CURDATE()) - year(Hiredate)) >= 18 order by (year(CURDATE()) - year(Hiredate));
#1.1-3select * from staff_master where Mgr_code is null;
#1.1-4select * from book_master where (STR_TO_DATE(Book_pub_year,'%Y') between 2001 and 2004) and Book_name like '%&%';
select Staff_name where Staff_Name like '%_%';
