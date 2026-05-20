# Gym Management System 
[![BUILT WITH](https://img.shields.io/badge/BUILT%20WITH-Netbeans-blue)](https://netbeans.apache.org/) 
[![License](https://img.shields.io/github/license/your-username/your-repository-name?style=plastic)](LICENSE)

The GMS (Gym Management System) project is a software application that tracks, maintains, and manages all member and staff data. It is entirely constructed at the administrative level, where only the administrator has access. The project is developed using Java Programming with NetBeans IDE, JFrame (Swing), and MySQL Database. This system assists gym managers in efficiently managing customers and staff records.

- Front-end: Friendly user-interface developed using Java Swing  
- Back-end: Handled by SQL database via JDBC API to communicate with MySQL  
- Administrative level: provided username and password {admin, admin}  
- Record Management: Member, Payment, and Trainer Management  

## System Requirements
To execute the project, you will need the following:

- MySQL Community Server  
- MySQL JDBC Connector  
- Java JDK 8 or above  
- NetBeans IDE  

## Screenshots

### Log In 
- The user will be an admin by default, and the username and password will be {admin, admin}

![Login Page](https://github.com/shabnam7213/Gym-Management-System-admin-panel-/blob/main/Gym-Management-System-master/screenshots/login.png)

---

### Homepage
- The admin menu consists of Add Member, Manage Member, Trainers, Members List, Payments, and Log out

![Home Page](https://github.com/your-username/your-repository-name/blob/main/screenshots/home.png)

---

### Add Member page
- To add a member, click on the option "Add Members" from admin menu

![Add Member page](https://github.com/your-username/your-repository-name/blob/main/screenshots/addmemberpage.png)

---

### Manage Member page
- To manage members, click on the option "Manage Members" from admin menu

![Manage Member page](https://github.com/your-username/your-repository-name/blob/main/screenshots/managememberpage.png)

---

### Trainers page
- To add or manage trainers, click on the option "Trainers" from admin menu

![Trainers page](https://github.com/your-username/your-repository-name/blob/main/screenshots/trainerpage.png)

---

### Members List page
- To view members, click on the option "Members List" from admin menu

![Members List page](https://github.com/your-username/your-repository-name/blob/main/screenshots/memberlist.png)

---

### Payments page
- To manage payments, click on the option "Payments" from admin menu

![Payments page](https://github.com/your-username/your-repository-name/blob/main/screenshots/paymentpage.png)

---

## Getting Started

- First, create a database in MySQL.
- Then place the `gmsdb_dump.sql` file into your MySQL Server 8.0/bin directory.
- Open Command Prompt and execute the following commands:

cd Program Files/MySQL/MySQL Server 8.0/bin
mysql -u root -p database_name < gmsdb_dump.sql

This will successfully import the database into your system.

---

## Contributor
- Your Name <shabnamsingh728@gmail.com>

---

## License & Copyright
Licensed under the Apache License.
