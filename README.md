How to install and run this project:

git clone https://github.com/jkurian49/LusterCode.git

mvn clean install

Set up mysql database:
as root user:
GRANT ALL PRIVELEGES ON *.* TO main@localhost IDENTIFIED BY Lusterman;
as user 'main':
CREATE DATABASE Lustercode;

Run target/LusterCode-1.0-SNAPSHORT.jar with Maven
View in browser: http://localhost:63342/LusterCode/web/index.html
(Works best in Safari with Local-File Restrictions and Cross-Orign Restrictions Disabled)
