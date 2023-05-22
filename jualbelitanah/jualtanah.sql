-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 21 Bulan Mei 2023 pada 06.50
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `jualtanah`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbljualtanah`
--

CREATE TABLE `tbljualtanah` (
  `id` int(1) NOT NULL,
  `pembeli` varchar(15) NOT NULL,
  `penjual` varchar(15) NOT NULL,
  `harga` varchar(255) NOT NULL,
  `luas` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `tbljualtanah`
--

INSERT INTO `tbljualtanah` (`id`, `pembeli`, `penjual`, `harga`, `luas`) VALUES
(1, 'Arif', 'Irfan', '1.000.000', '9.0000'),
(2, 'Sulaiman', 'Ali', '500.0000', '1.0000'),
(3, 'Dika', 'Malik', '50.000.000', '90.0000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tbljualtanah`
--
ALTER TABLE `tbljualtanah`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `tbljualtanah`
--
ALTER TABLE `tbljualtanah`
  MODIFY `id` int(1) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
