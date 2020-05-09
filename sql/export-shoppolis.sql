-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 09, 2020 at 09:36 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shoppolis`
--

-- --------------------------------------------------------

--
-- Table structure for table `desktops`
--

CREATE TABLE `desktops` (
  `id` int(11) NOT NULL,
  `name` varchar(512) DEFAULT NULL,
  `manufacturer` varchar(512) DEFAULT NULL,
  `gpu` varchar(512) DEFAULT NULL,
  `gpuName` varchar(512) DEFAULT NULL,
  `cpu` varchar(512) DEFAULT NULL,
  `cpuName` varchar(512) DEFAULT NULL,
  `cpuCores` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `ssd` int(11) DEFAULT NULL,
  `hdd` int(11) DEFAULT NULL,
  `image` varchar(512) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `desktops`
--

INSERT INTO `desktops` (`id`, `name`, `manufacturer`, `gpu`, `gpuName`, `cpu`, `cpuName`, `cpuCores`, `ram`, `ssd`, `hdd`, `image`, `price`, `stock`) VALUES
(56780002, 'Razer', 'HP', 'NVidia', 'GeForce GTX 1080', 'AMD', 'FX6300', 4, 16, 256, 1000, 'https://asset.conrad.com/media10/isa/160267/c1/-/global/873922_RB_01_FB/image.jpg?x=1000&y=1000&ex=1000&ey=1000&align=center', 3000, 10),
(56780001, 'Blackbourne', 'Logitech', 'Ryzen', 'R1180', 'Intel', 'i5', 8, 8, 512, 1000, 'https://egarner.hr/images/made/6665/slike/medion-erazer-p66056-desktop-pc-intel-i5-9400-8gb-ram-128gb-ssd-1tb-hdd-nvidia-geforce-gtx-1050-ti-win10-30618.jpg', 5000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `info`
--

CREATE TABLE `info` (
  `id` int(11) DEFAULT NULL,
  `promotion` varchar(512) DEFAULT NULL,
  `warranty` int(11) DEFAULT NULL,
  `brand` varchar(512) DEFAULT NULL,
  `color` varchar(512) DEFAULT NULL,
  `screenSize` float DEFAULT NULL,
  `screenType` varchar(512) DEFAULT NULL,
  `displayResolution` varchar(512) DEFAULT NULL,
  `officeIncluded` varchar(512) DEFAULT NULL,
  `operatingSystem` varchar(512) DEFAULT NULL,
  `bundledSoftware` varchar(512) DEFAULT NULL,
  `portsSlotsChassis` varchar(512) DEFAULT NULL,
  `cameraMicrophone` varchar(512) DEFAULT NULL,
  `processorBrand` varchar(512) DEFAULT NULL,
  `processor` varchar(512) DEFAULT NULL,
  `processorType` varchar(512) DEFAULT NULL,
  `clockSpeed` float DEFAULT NULL,
  `frontSideBus` float DEFAULT NULL,
  `ramSize` int(11) DEFAULT NULL,
  `maxExpandability` int(11) DEFAULT NULL,
  `memorySlots` int(11) DEFAULT NULL,
  `hardDrive` int(11) DEFAULT NULL,
  `ssd` int(11) DEFAULT NULL,
  `driveRotation` int(11) DEFAULT NULL,
  `opticalDriveType` varchar(512) DEFAULT NULL,
  `graphicsType` varchar(512) DEFAULT NULL,
  `wifi` varchar(512) DEFAULT NULL,
  `dlna` varchar(512) DEFAULT NULL,
  `bluetooth` varchar(512) DEFAULT NULL,
  `hdmi` varchar(512) DEFAULT NULL,
  `usb` varchar(512) DEFAULT NULL,
  `multicardReader` varchar(512) DEFAULT NULL,
  `compatibleMemoryCards` varchar(512) DEFAULT NULL,
  `batteryType` varchar(512) DEFAULT NULL,
  `batteryUpTo` float DEFAULT NULL,
  `width` float DEFAULT NULL,
  `depth` float DEFAULT NULL,
  `height` float DEFAULT NULL,
  `weight` float DEFAULT NULL,
  `more` varchar(512) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `info`
--

INSERT INTO `info` (`id`, `promotion`, `warranty`, `brand`, `color`, `screenSize`, `screenType`, `displayResolution`, `officeIncluded`, `operatingSystem`, `bundledSoftware`, `portsSlotsChassis`, `cameraMicrophone`, `processorBrand`, `processor`, `processorType`, `clockSpeed`, `frontSideBus`, `ramSize`, `maxExpandability`, `memorySlots`, `hardDrive`, `ssd`, `driveRotation`, `opticalDriveType`, `graphicsType`, `wifi`, `dlna`, `bluetooth`, `hdmi`, `usb`, `multicardReader`, `compatibleMemoryCards`, `batteryType`, `batteryUpTo`, `width`, `depth`, `height`, `weight`, `more`) VALUES
(12340001, '', 1, 'Lenovo', 'Black', 15.6, 'FHD', '1920x1080', 'No', 'Windows 10', '', '2x USB 3.0, 1x Ethernet (RJ-45), 1 x HDMI, 1 x AC power adapter jack, 1 x security keyhole, 1 x headphone / microphone combo jack', 'Webcam with Integrated microphone', 'AMD', 'A9', 'AMD A9-9425', 3.7, NULL, 8, NULL, 1, NULL, 256, NULL, 'None', 'Integrated AMD Radeon R5 Graphics', 'Yes', 'No', 'Yes', 'Yes', '2 x USB 3.0', 'Yes', 'DDR4', 'Integrated 30Wh', 6, 375, 253, 22.7, 2.1, '');

-- --------------------------------------------------------

--
-- Table structure for table `laptops`
--

CREATE TABLE `laptops` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `Manufacturer` varchar(255) DEFAULT NULL,
  `Gpu` varchar(255) DEFAULT NULL,
  `gpuName` varchar(512) DEFAULT NULL,
  `Cpu` varchar(255) DEFAULT NULL,
  `CpuName` varchar(512) DEFAULT NULL,
  `CpuCores` int(11) DEFAULT NULL,
  `Ram` int(11) DEFAULT NULL,
  `Ssd` varchar(255) DEFAULT NULL,
  `Hdd` int(11) DEFAULT NULL,
  `Image` varchar(255) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `laptops`
--

INSERT INTO `laptops` (`ID`, `Name`, `Manufacturer`, `Gpu`, `gpuName`, `Cpu`, `CpuName`, `CpuCores`, `Ram`, `Ssd`, `Hdd`, `Image`, `Price`, `Stock`) VALUES
(12340001, 'Ideapad', 'Lenovo', 'GeForce', '1080 GTX', 'AMD', 'A9-9425', 2, 8, '256', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/1/81mt000suk.jpg', 400, 10),
(12340002, 'Thinkpad', 'Lenovo', 'GeForce', '7800 GTX', 'AMD', 'A9-9425', 4, 4, '256', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/v/1/v145-81mt002_5.jpg', 500, 10),
(12340003, 'Satellite Pro 14', 'HP', 'GeForce', '7900 GS', 'AMD', 'A9-9425', 4, 8, '512', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/a/8ac00es_4.jpg', 600, 10),
(12340004, 'TUF', 'Lenovo', 'GeForce', '7900 GT', 'AMD', 'Ryzen 3', 6, 8, '0', 1000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/1/81mt00015uk_9.jpg', 700, 10),
(12340005, 'VivoBook', 'HP', 'GeForce', '7900 GT', 'AMD', 'Ryzen 3', 6, 16, '0', 2000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/d/o/download_3.jpg', 800, 10),
(12340006, 'ROG Strix', 'Toshiba', 'Quadro', 'FX 380M', 'Intel', 'i3', 8, 32, '0', 500, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/r/4/r40-c-163_5.jpg', 900, 10),
(12340007, 'Surface', 'Asus', 'Quadro', 'FX 240A', 'Intel', 'i3', 4, 4, '0', 250, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/_/6/_6737_g531gu-carousel_images_1000x1000_1__hero_image_1.jpg', 1000, 10),
(12340008, 'Ideapad', 'Lenovo', 'Quadro', 'FX 320G', 'Intel', 'i5', 4, 8, '0', 125, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/1/81uv0002uk_1.jpg', 1100, 10),
(12340009, 'Thinkpad', 'HP', 'Quadro', 'FX 310M', 'Intel', 'i7', 4, 12, '128', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/a/8ab98es_5.jpg', 1200, 10),
(12340010, 'Satellite Pro 14', 'Asus', 'Quadro', 'FX 360M', 'Intel', 'i9', 4, 4, '256', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/_/6/_6658_fx505_blue_1000x1000_3_.jpg', 1300, 10),
(12340011, 'TUF', 'Asus', 'GPU accelerator', 'M620', 'Intel', 'i5', 8, 4, '512', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/x/5/x509ua-ej064t_9.jpg', 1400, 10),
(12340012, 'VivoBook', 'Lenovo', 'GPU accelerator', 'M6202', 'Intel', 'i3', 8, 4, '256', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/0/80xu002yuk_4.jpg', 1500, 10),
(12340013, 'ROG Strix', 'Asus', 'GPU accelerator', 'M6123', 'Intel', 'i5', 4, 8, '128', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/g/l/gl704_scar_ii_11-1_light.jpg', 1600, 10),
(12340014, 'Surface', 'Asus', 'GPU accelerator', 'M62023', 'Intel', 'i7', 2, 8, '1024', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/_/6/_6654_fx705dt_1000x1000_7_.jpg', 1700, 10),
(12340015, 'Surface', 'Lenovo', 'GPU accelerator', 'M620', 'AMD', 'A9-9152', 2, 8, '0', 1000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/1/81uv0000uk.jpg', 1800, 10),
(12340016, 'Thinkpad', 'HP', 'GPU accelerator', 'M6123', 'AMD', 'A9-9436', 2, 8, '0', 2000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/6/m/6mp37es_2.jpg', 1900, 10),
(12340017, 'Thinkpad', 'Microsoft', 'GPU accelerator', 'M6123', 'AMD', 'A9-1255', 6, 4, '128', 1000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/v/g/vgy-00003_1.jpg', 2000, 10),
(12340018, 'Thinkpad', 'Asus', 'GPU accelerator', 'M6123', 'AMD', 'A9-1253', 4, 8, '256', 1000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/x/5/x512da-ej254t_1_1.jpg', 2100, 10),
(12340019, 'ROG Strix', 'Asus', 'GPU accelerator', 'M2223', 'AMD', 'A9-6434', 4, 8, '512', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/_/6/_6737_g531gu-carousel_images_1000x1000_1__hero_image.jpg', 2200, 10),
(12340020, 'ROG Strix', 'Asus', 'GPU accelerator', 'M2223', 'AMD', 'A9-9214', 4, 8, '512', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/6/3/6388_red_5..jpg', 2300, 10),
(12340021, 'ROG Strix', 'Microsoft', 'GPU accelerator', 'M2223', 'AMD', 'A9-1231', 8, 8, '256', 2000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/j/t/jtw-00002_1.jpg', 2400, 10),
(12340022, 'ROG Strix', 'Asus', 'GPU accelerator', 'M2223', 'Intel', 'i5', 8, 4, '512', 2000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/x/5/x509fa-ej077t_7.jpg', 2500, 10),
(12340023, 'Macbook', 'Apple', 'GPU accelerator', 'M2223', 'Intel', 'i3', 8, 4, '1024', 2000, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/m/v/mvfh2ba_1.jpg', 2600, 10),
(12340024, 'Macbook', 'Apple', 'GPU accelerator', 'M2223', 'Intel', 'i7', 8, 4, '1024', 0, 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/m/v/mvfl2ba_3.jpg', 2700, 10);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `phones`
--

CREATE TABLE `phones` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `manufacturer` varchar(512) DEFAULT NULL,
  `gpu` varchar(512) DEFAULT NULL,
  `gpuName` varchar(512) DEFAULT NULL,
  `cpu` varchar(512) DEFAULT NULL,
  `cpuName` varchar(512) DEFAULT NULL,
  `cpuCores` int(11) DEFAULT NULL,
  `ram` int(11) DEFAULT NULL,
  `hdd` int(11) DEFAULT NULL,
  `image` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `phones`
--

INSERT INTO `phones` (`ID`, `name`, `manufacturer`, `gpu`, `gpuName`, `cpu`, `cpuName`, `cpuCores`, `ram`, `hdd`, `image`, `price`, `stock`) VALUES
(43210001, 'Galaxy S10', 'Samsung', 'Adreno', 'A540', 'FX', '6300', 4, 4, 64, 'https://www.ft.com/__origami/service/image/v2/images/raw/https%3A%2F%2Fs3-ap-northeast-1.amazonaws.com%2Fpsh-ex-ftnikkei-3937bb4%2Fimages%2F7%2F8%2F7%2F3%2F23023787-1-eng-GB%2F20191015%20Huawei%20Mate%2020%20X%20.jpg?source=nar-cms', 600, 100),
(43210002, 'Galaxy S10', 'Samsung', 'Adreno', 'A540', 'FX', '6300', 4, 8, 64, 'https://www.ft.com/__origami/service/image/v2/images/raw/https%3A%2F%2Fs3-ap-northeast-1.amazonaws.com%2Fpsh-ex-ftnikkei-3937bb4%2Fimages%2F7%2F8%2F7%2F3%2F23023787-1-eng-GB%2F20191015%20Huawei%20Mate%2020%20X%20.jpg?source=nar-cms', 700, 100);

-- --------------------------------------------------------

--
-- Table structure for table `purchased`
--

CREATE TABLE `purchased` (
  `username` varchar(512) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(512) DEFAULT NULL,
  `image` varchar(512) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `purchased`
--

INSERT INTO `purchased` (`username`, `id`, `count`, `date`, `name`, `image`, `price`) VALUES
('bruno', 12340001, 1, '2020-03-28', 'Lenovo Ideapad AMD A9-9425 Dual-Core, GeForce 1080 GTX 8GB RAM, 256GB SSD', 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/1/81mt000suk.jpg', 400),
('bruno', 43210001, 1, '2020-03-28', 'Samsung Galaxy S10 FX 6300 Quad-Core, Adreno A540 4GB RAM, 64GB HDD', 'https://www.ft.com/__origami/service/image/v2/images/raw/https%3A%2F%2Fs3-ap-northeast-1.amazonaws.com%2Fpsh-ex-ftnikkei-3937bb4%2Fimages%2F7%2F8%2F7%2F3%2F23023787-1-eng-GB%2F20191015%20Huawei%20Mate%2020%20X%20.jpg?source=nar-cms', 600),
('bruno', 43210002, 1, '2020-03-28', 'Samsung Galaxy S10 FX 6300 Quad-Core, Adreno A540 8GB RAM, 64GB HDD', 'https://www.ft.com/__origami/service/image/v2/images/raw/https%3A%2F%2Fs3-ap-northeast-1.amazonaws.com%2Fpsh-ex-ftnikkei-3937bb4%2Fimages%2F7%2F8%2F7%2F3%2F23023787-1-eng-GB%2F20191015%20Huawei%20Mate%2020%20X%20.jpg?source=nar-cms', 700),
('bruno', 12340001, 1, '2020-03-28', 'Lenovo Ideapad AMD A9-9425 Dual-Core, GeForce 1080 GTX 8GB RAM, 256GB SSD', 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/1/81mt000suk.jpg', 400),
('brunotest', 12340006, 1, '2020-03-28', 'Toshiba ROG Strix Intel i3 Octa-Core, Quadro FX 380M 32GB RAM, 500GB HDD', 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/r/4/r40-c-163_5.jpg', 900),
('brunotest', 56780001, 1, '2020-03-28', 'Logitech Blackbourne Intel i5 Octa-Core, Ryzen R1180 8GB RAM, 512GB SSD, 1000GB HDD', 'https://egarner.hr/images/made/6665/slike/medion-erazer-p66056-desktop-pc-intel-i5-9400-8gb-ram-128gb-ssd-1tb-hdd-nvidia-geforce-gtx-1050-ti-win10-30618.jpg', 5000),
('brunotest', 12340002, 1, '2020-03-28', 'Lenovo Thinkpad AMD A9-9425 Quad-Core, GeForce 7800 GTX 4GB RAM, 256GB SSD', 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/v/1/v145-81mt002_5.jpg', 500),
('bruno', 56780001, 6, '2020-03-28', 'Logitech Blackbourne Intel i5 Octa-Core, Ryzen R1180 8GB RAM, 512GB SSD, 1000GB HDD', 'https://egarner.hr/images/made/6665/slike/medion-erazer-p66056-desktop-pc-intel-i5-9400-8gb-ram-128gb-ssd-1tb-hdd-nvidia-geforce-gtx-1050-ti-win10-30618.jpg', 5000),
('tutko', 12340002, 1, '2020-05-08', 'Lenovo Thinkpad AMD A9-9425 Quad-Core, GeForce 7800 GTX 4GB RAM, 256GB SSD', 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/v/1/v145-81mt002_5.jpg', 500),
('tutko', 12340003, 1, '2020-05-08', 'HP Satellite Pro 14 AMD A9-9425 Quad-Core, GeForce 7900 GS 8GB RAM, 512GB SSD', 'https://www.did.ie/media/catalog/product/cache/1/small_image/160x/9df78eab33525d08d6e5fb8d27136e95/8/a/8ac00es_4.jpg', 600);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL DEFAULT '',
  `password` varchar(200) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'admin', '$2a$10$Ii8O.wtxIeYQuXcbhcQ/WOngxwb1KrnAVOOLi6SaW8KfPWq7O6tsa'),
(2, 'bruno', '$2a$10$FzfrNjitRH599.TS20yL8uSWQtQgkzsbmIX7F7ngMy3L1nqeeYuiS'),
(10, 'test', '$2a$10$bTEc7JLWrj2Whbs3k774/.HV4l0VOEbhv8Ju2gknZX1j7cas2S0Um'),
(11, 'brunotest', '$2a$10$IhTbk7.cT7wyrN137a/fyuQBHg0DuzM8CrsIZGsG9dIbcp9LyVHg.'),
(12, 'tutko', '$2a$10$tUVLcOnnNp59.nDQlpe6seHgIa9icME8ppFZmZG8xVoZ1eVZ4zuA.'),
(13, 'asd', '$2a$10$xVEJsdla/Dzvh4qegEF8UupY5aPyGYra.eGcpQ4fCze0BM2TzEee2'),
(14, 'fe', '$2a$10$DSWF8gQ4UeclJez7LvoWzurIy49FHX24be2u4QEUo9CnIx/vZucL.'),
(15, 'abc222', '$2a$10$AoAo.eJpf9URzr2e.Cudc.uanmEGSZP5wJ1ig4b4qGL5cchpSduUq'),
(16, 'abed', '$2a$10$25g.bAM0mrqeBxjQ3hJGrO3xGQ92cr8gy72b2eTzZoXvdlS8tMj8q'),
(17, 'bebax', '$2a$10$ZiJWUdgM6iwnX23VoRneLu2NJj1DEo8vXNy9.w4L/8fGatfkK2vA2');

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL DEFAULT '',
  `role` varchar(45) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `username`, `role`) VALUES
(1, 'admin', 'ROLE_ADMIN'),
(2, 'bruno', 'ROLE_USER'),
(10, 'test', 'ROLE_USER'),
(11, 'brunotest', 'ROLE_USER'),
(12, 'tutko', 'ROLE_USER'),
(13, 'asd', 'ROLE_USER'),
(14, 'fe', 'ROLE_USER'),
(15, 'abc222', 'ROLE_USER'),
(16, 'abed', 'ROLE_USER'),
(17, 'bebax', 'ROLE_USER');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `desktops`
--
ALTER TABLE `desktops`
  ADD KEY `id` (`id`);

--
-- Indexes for table `info`
--
ALTER TABLE `info`
  ADD UNIQUE KEY `id` (`id`);

--
-- Indexes for table `laptops`
--
ALTER TABLE `laptops`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `persistent_logins`
--
ALTER TABLE `persistent_logins`
  ADD PRIMARY KEY (`series`);

--
-- Indexes for table `phones`
--
ALTER TABLE `phones`
  ADD UNIQUE KEY `ID` (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
