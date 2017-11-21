# MyBatis
Test Java project.

# Example
You should create user "mybatis" and his password.
You should create schema "mybatis" in the database.
When will starting project then will creating tables.

-Start project
 - GET http://localhost:8181/hello
 
<p align="center">
  <img width="460" height="300" src="https://raw.githubusercontent.com/VitRocket/MyBatis/master/demo_01.png">
</p>

 - GET http://localhost:8181/get_document/?email=demo@gmail.com&doc_format=xls&filter=2017-10-25
 without Autorization
 
 <p align="center">
  <img width="460" height="300" src="https://raw.githubusercontent.com/VitRocket/MyBatis/master/demo_02.png">
</p>

- GET http://localhost:8181/get_document/?email=demo@gmail.com&doc_format=xls&filter=2017-10-25
 with Autorization, username - user, password - pass
 
 <p align="center">
  <img width="460" height="300" src="https://raw.githubusercontent.com/VitRocket/MyBatis/master/demo_03.png">
</p>
