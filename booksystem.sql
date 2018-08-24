/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : booksystem

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-22 08:54:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '书本编号',
  `book_name` varchar(100) NOT NULL COMMENT '书名',
  `book_author` varchar(50) NOT NULL COMMENT '作者',
  `book_number` int(11) NOT NULL COMMENT '剩余数量',
  `book_record` varchar(50) NOT NULL COMMENT '上架时间',
  `book_shelfid` int(11) NOT NULL COMMENT '书本位于书架的编号',
  PRIMARY KEY (`book_id`),
  KEY `book_shelfid` (`book_shelfid`),
  KEY `book_id` (`book_id`,`book_shelfid`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bookshelf
-- ----------------------------
DROP TABLE IF EXISTS `bookshelf`;
CREATE TABLE `bookshelf` (
  `bookshelf_id` int(11) NOT NULL AUTO_INCREMENT,
  `bookshelf_type` varchar(20) NOT NULL,
  PRIMARY KEY (`bookshelf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for borrow
-- ----------------------------
DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `borrow_date` varchar(50) NOT NULL,
  `borrow_managerid` int(11) NOT NULL,
  `return_dateup` varchar(50) NOT NULL,
  `return_date` varchar(50) DEFAULT NULL,
  `return_managerid` int(11) DEFAULT NULL,
  PRIMARY KEY (`borrow_id`),
  KEY `stduent_id` (`student_id`),
  KEY `borrow_managerid` (`borrow_managerid`),
  KEY `book_id` (`book_id`),
  KEY `return_managerid` (`return_managerid`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) NOT NULL,
  `manager_password` varchar(20) NOT NULL,
  PRIMARY KEY (`manager_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `student_id` int(11) NOT NULL,
  `student_name` varchar(50) NOT NULL,
  `student_class` varchar(10) NOT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
