# Javalytics

![Javalytics Logo](https://github.com/tomsnews/javalytics/blob/master/Javalytics.png)

A tool that converts raw stats data into human readable statistics.
On many websites entries will be made in order to track visitor's behaviour.
Things like IP adresses, timestamps, referers, page IDs or post IDs will be written in the database.
This tools converts thousands even millions of entries into easy to read statistical values.

![Javalytics Logo](https://github.com/tomsnews/javalytics/blob/master/screenshot.png)

## 1. Single Values

### 1.1 Real-time visitors
Visitors (Distinct IPs currently on your website).

### 1.2 Total Posts
Just a number. The ammount of posts currently existing on your website.

### 1.3 Total Pages
Just a number. The ammount of pages currently existing on your website.

### 1.4 Average Visitors daily
Average visitors based on visitors count of the last 15 days.

### 1.5 Average Visitors monthly
Average Visitors daily multiplied by 30.
Using this method because newly created websites may not have data enties dating back more than 15 days.

### 1.6 Average Visitors yearly
Average Visitors daily multiplied by 365.

### 1.7 Growth Rate (Month)
How much has the ammount of visitors changed compared to last 30 days.
Our system sums visitors from 31-61 days back and compares it (in %) to the sum of visitors from 1-31 days back.
Have to remind at this point than your website might be new and you need early statistical numbers in order to plan your next steps.

### 1.8 iOS Devices
Percentage of users using an iOS device. This value gives you a hint how much time to spent testing on Safari and if you should consider to release an iOS App.

### 1.9 Total Files on the system
Just a number. The total ammount of files on your webserver. This includes all files.

### 1.10 Last Cron Execution
Just a date. It is always useful to know if your server's Cron Jobs have been executed as expected.

## 2. Lists

### 2.1 Visitors by Country
A list of top 10 countries with the higher visitor counts of all-time.
In this list total count and percentage is being displayed.

### 2.2 Visitors per day
Total of Visitors (Distinct IPs) that have visited your website the last 10 days.
Presented for each day in a distinct row starting from today (Descenting).

### 2.3 Hits per day
Total of Hits occured on your website the last 10 days.
Presented for each day in a distinct row starting from today (Descenting).

### 2.4 Popular Posts
Most visited Posts. A list of top 10 most popular posts. Visitors data is being used (not Hits).

### 2.5 Popular Pages
Most visited Pages. A list of top 10 most popular pages. Visitors data is being used (not Hits).

### 2.6 Visitors per Hour
24 rows presenting the All-Time Total of visitors using hourly intervals. For example 00.00-01.00 your website has been visited 400 times.
Also on every row you will be presented with the percentage of visitors at this timeframe agaist the grand total.
For example 4.3% of your total visitors visit your website from 09.00-10.00.

## 3. Charts

### 3.1 Pie Chart - Visitors per Country (see 2.1)
A Pie Chart displaying Country Rank based on percentage of total visitors.

### 3.2 Line Chart - Visitors per Day (see 2.2)
A Line Chart displaying Visitors per Day.

### 3.3 Line Chart - Hits per Day (see 2.3)
A Line Chart displaying Hits per Day.

## Built With
* Java SE 12
* GUI using JavaFX
* Documentation according to Javadoc guidelines

## Authors
* Sabine Sander (GUI)
* Lukas Kerkhoff (Database, Functions)
* Tom Papatolis (Database, Functions, Releases)

## Prerequisites
Data comes from a pre-existing stats.sql backup file. In order to use this software you should have a local MySQL database installed (Like Xampp).
However our software also runs using a SQlite database. Your MySQL data will be converted into SQlite with a press of a button.

The table structure of stats is 

CREATE TABLE `stats` (
  `id` int(11) NOT NULL,
  `ip` varchar(50) NOT NULL,
  `os` varchar(50) NOT NULL,
  `browser` varchar(50) NOT NULL,
  `browser_ver` varchar(50) NOT NULL,
  `post_id` int(11) NOT NULL,
  `url` varchar(100) NOT NULL,
  `referral` varchar(100) NOT NULL,
  `mobile` varchar(50) NOT NULL,
  `robot` varchar(50) NOT NULL,
  `languages` varchar(50) NOT NULL,
  `country` varchar(64) NOT NULL DEFAULT '0',
  `country_code` varchar(2) NOT NULL,
  `created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

## Installing
Your computer needs a Java Runtime (https://www.java.com/en/download/). A local MySQL database and a pre-existing stats.sql backup file should be available.
Included in our Project is a sample.sql file.
