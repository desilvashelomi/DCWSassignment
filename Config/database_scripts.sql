
CREATE DATABASE /*!32312 IF NOT EXISTS*/`DoctorSystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `DoctorSystem`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`uid`,`uname`,`password`) values (1,'shelomi','123456');


CREATE TABLE `hospital_apointments` (
  `apoId` bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor` timestamp NULL DEFAULT NULL,
  `charge` double NOT NULL,
  `hospital` varchar(255) NOT NULL,
  `dateTime` datetime DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`apo_id`)
)

CREATE TABLE `hospital_book_apointments` (
  `bookId` bigint(20) NOT NULL AUTO_INCREMENT,
  `charge` double NOT NULL,
  `created_date` datetime NOT NULL,
  `modify_date` datetime DEFAULT NULL,
  `paymentMethods` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `user` varchar(255) NOT NULL,
  PRIMARY KEY (`bookId`)
)


CREATE TABLE `hospital_doctor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `speciality` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) 
