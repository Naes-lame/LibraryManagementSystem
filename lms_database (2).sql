-- phpMyAdmin SQL Dump
-- version 5.2.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 15, 2025 at 04:17 PM
-- Server version: 8.4.3
-- PHP Version: 8.3.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lms_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `bookrecords`
--

CREATE TABLE `bookrecords` (
  `book_id` int NOT NULL,
  `book_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Author` varchar(255) NOT NULL,
  `Genre` varchar(255) NOT NULL,
  `ISBN` varchar(255) NOT NULL,
  `Quantity` int NOT NULL,
  `DateAdded` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `bookrecords`
--

INSERT INTO `bookrecords` (`book_id`, `book_title`, `Author`, `Genre`, `ISBN`, `Quantity`, `DateAdded`, `deleted_at`) VALUES
(1, 'To Kill a Mockingbird', 'Harper Lee', 'Fiction', '9780061120084', 10, '2025-04-30 16:00:00', NULL),
(2, '1984', 'George Orwell', 'Fiction', '9780451524935', 15, '2024-08-06 16:00:00', NULL),
(3, 'Sapiens: A Brief History of Humankind', 'Yuval Noah Harari', 'History', '9780062316097', 20, '2024-08-21 16:00:00', NULL),
(4, 'A Brief History of Time', 'Stephen Hawking', 'Science', '9780553380163', 25, '2025-01-11 16:00:00', NULL),
(5, 'The Innovators', 'Walter Isaacson', 'Information Technology', '9781476708690', 30, '2024-11-15 16:00:00', NULL),
(6, 'Brave New World', 'Aldous Huxley', 'Fiction', '9780060850524', 35, '2024-11-28 16:00:00', NULL),
(7, 'The Wright Brothers', 'David McCullough', 'History', '9781476728742', 40, '2024-07-22 16:00:00', NULL),
(8, 'Cosmos', 'Carl Sagan', 'Science', '9780345331359', 45, '2024-09-08 16:00:00', NULL),
(9, 'The Code Book', 'Simon Singh', 'Information Technology', '9780385495325', 50, '2024-05-30 16:00:00', NULL),
(10, 'The Catcher in the Rye', 'J.D. Salinger', 'Fiction', '9780316769488', 55, '2024-08-16 16:00:00', NULL),
(11, 'Guns, Germs, and Steel', 'Jared Diamond', 'History', '9780393354324', 60, '2024-07-11 16:00:00', NULL),
(12, 'The Selfish Gene', 'Richard Dawkins', 'Science', '9780198788607', 65, '2024-05-21 16:00:00', NULL),
(13, 'Hackers: Heroes of the Computer Revolution', 'Steven Levy', 'Information Technology', '9781449388393', 70, '2024-12-27 16:00:00', NULL),
(14, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Fiction', '9780743273565', 75, '2024-06-02 16:00:00', NULL),
(15, 'The Diary of a Young Girl', 'Anne Frank', 'History', '9780553296983', 80, '2024-10-04 16:00:00', NULL),
(16, 'The Elegant Universe', 'Brian Greene', 'Science', '9780393338101', 85, '2025-03-04 16:00:00', NULL),
(17, 'The Mythical Man-Month', 'Frederick P. Brooks Jr.', 'Information Technology', '9780201835953', 90, '2025-03-21 16:00:00', NULL),
(18, 'Moby-Dick', 'Herman Melville', 'Fiction', '9780142437247', 95, '2025-03-17 16:00:00', NULL),
(19, '1776', 'David McCullough', 'History', '9780743226710', 100, '2025-01-09 16:00:00', NULL),
(20, 'The Feynman Lectures on Physics', 'Richard P. Feynman', 'Science', '9780465023820', 105, '2025-02-16 16:00:00', NULL),
(21, 'Brave New World', 'Aldous Huxley', 'Information Technology', '9780060850524', 35, '2025-05-15 10:54:29', '2025-05-15 10:55:00');

-- --------------------------------------------------------

--
-- Table structure for table `borrowerrecords`
--

CREATE TABLE `borrowerrecords` (
  `borrower_id` int NOT NULL,
  `borrower_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Phone` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `membership_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `deleted_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `borrowerrecords`
--

INSERT INTO `borrowerrecords` (`borrower_id`, `borrower_name`, `Address`, `Phone`, `Email`, `membership_date`, `deleted_at`) VALUES
(9, 'sean', 's', '09066749590', 'e@gmail.com', '2025-05-15 15:24:49', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `issuedbooks`
--

CREATE TABLE `issuedbooks` (
  `issuedbook_id` int NOT NULL,
  `transaction_id` int NOT NULL,
  `borrower_name` varchar(255) NOT NULL,
  `book_title` varchar(255) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Triggers `issuedbooks`
--
DELIMITER $$
CREATE TRIGGER `after_issue` AFTER INSERT ON `issuedbooks` FOR EACH ROW BEGIN
    UPDATE bookrecords
    SET quantity = quantity - 1
    WHERE book_id = NEW.book_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `returned_books`
--

CREATE TABLE `returned_books` (
  `returnedbook_id` int NOT NULL,
  `transaction_id` int NOT NULL,
  `borrower_name` varchar(255) NOT NULL,
  `book_title` varchar(255) NOT NULL,
  `date_returned` date DEFAULT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Triggers `returned_books`
--
DELIMITER $$
CREATE TRIGGER `after_return` AFTER INSERT ON `returned_books` FOR EACH ROW BEGIN
    UPDATE bookrecords
    SET quantity = quantity + 1
    WHERE book_id = NEW.book_id;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transaction_id` int NOT NULL,
  `borrower_name` varchar(255) NOT NULL,
  `book_title` varchar(255) NOT NULL,
  `transaction_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `due_date` datetime DEFAULT NULL,
  `status` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Triggers `transactions`
--
DELIMITER $$
CREATE TRIGGER `move_issued_books` AFTER INSERT ON `transactions` FOR EACH ROW BEGIN
    IF NEW.status = 'Issued' THEN
        INSERT INTO issuedbooks (transaction_id, borrower_id, book_id, issue_date, due_date, status)
        VALUES (NEW.transaction_id, NEW.borrower_id, NEW.book_id, NEW.transaction_date, NEW.due_date, NEW.status);
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `move_returned_books` AFTER UPDATE ON `transactions` FOR EACH ROW BEGIN
    IF NEW.status = 'Returned' THEN
        INSERT INTO returned_books (transaction_id, borrower_id, book_id, date_returned, status)
        VALUES (NEW.transaction_id, NEW.borrower_id, NEW.book_id, NOW(), NEW.status);
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `move_to_overdue_books` AFTER UPDATE ON `transactions` FOR EACH ROW BEGIN
    IF NEW.due_date < NOW() AND NEW.status != 'Returned' THEN
        INSERT INTO overduebooks (transaction_id, borrower_id, book_id, issue_date, due_date, days_overdue, fine_amount, status)
        VALUES (
            NEW.transaction_id, 
            NEW.borrower_id, 
            NEW.book_id, 
            NEW.transaction_date, 
            NEW.due_date, 
            DATEDIFF(NOW(), NEW.due_date), 
            CASE WHEN DATEDIFF(NOW(), NEW.due_date) > 0 THEN DATEDIFF(NOW(), NEW.due_date) * 10 ELSE 0 END, 
            'Overdue'
        );
    END IF;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `set_due_date` BEFORE INSERT ON `transactions` FOR EACH ROW BEGIN
    SET NEW.transaction_date = NOW();
    SET NEW.due_date = DATE_ADD(NOW(), INTERVAL 7 DAY);
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `full_name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` bigint NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `full_name`, `email`, `phone`, `address`, `username`, `password`, `created_at`) VALUES
(1, 'Marlon O. Calixton', 'marlOrtalla@gmail.com', 9066749590, 'Jugan Consolacion', 'Marlon_Tolix', '123456', '2025-05-03 03:14:02'),
(2, 'Glenn Mykhel V. Gulfan', 'gg', 9, 'Jugan', 'mykhel', '123', '2025-05-03 05:05:37'),
(3, 'Ranela Esgana', 'rainela@gmail.com', 9359412042, 'Consolacion, Cebu', 'RANE', 'Raine_la', '2025-05-03 06:54:47'),
(4, 'Sean Cole Calixton', 'Sean@gmail.com', 9887685940, 'Jugan', 'Sean', 'sean@gmail', '2025-05-03 10:18:03'),
(5, 'Panfilo Remedio', 'panfilo@gmail.com', 9354910224, 'Consolacion', 'Panfilo', 'panfilo@gmail.com', '2025-05-08 00:07:17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bookrecords`
--
ALTER TABLE `bookrecords`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `borrowerrecords`
--
ALTER TABLE `borrowerrecords`
  ADD PRIMARY KEY (`borrower_id`);

--
-- Indexes for table `issuedbooks`
--
ALTER TABLE `issuedbooks`
  ADD PRIMARY KEY (`issuedbook_id`),
  ADD KEY `transaction_id` (`transaction_id`);

--
-- Indexes for table `returned_books`
--
ALTER TABLE `returned_books`
  ADD PRIMARY KEY (`returnedbook_id`),
  ADD KEY `transaction_id` (`transaction_id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transaction_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `password` (`password`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookrecords`
--
ALTER TABLE `bookrecords`
  MODIFY `book_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `borrowerrecords`
--
ALTER TABLE `borrowerrecords`
  MODIFY `borrower_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `issuedbooks`
--
ALTER TABLE `issuedbooks`
  MODIFY `issuedbook_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `returned_books`
--
ALTER TABLE `returned_books`
  MODIFY `returnedbook_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transaction_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `issuedbooks`
--
ALTER TABLE `issuedbooks`
  ADD CONSTRAINT `issuedbooks_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `returned_books`
--
ALTER TABLE `returned_books`
  ADD CONSTRAINT `returned_books_ibfk_1` FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`transaction_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
