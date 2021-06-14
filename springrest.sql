-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14-Jun-2021 às 13:24
-- Versão do servidor: 10.4.14-MariaDB
-- versão do PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `springrest`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `campanha`
--

CREATE TABLE `campanha` (
  `id` bigint(20) NOT NULL,
  `imgperfil` varchar(255) NOT NULL,
  `imgpix` varchar(255) NOT NULL,
  `info` varchar(255) NOT NULL,
  `meta` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `campanha`
--

INSERT INTO `campanha` (`id`, `imgperfil`, `imgpix`, `info`, `meta`, `nome`) VALUES
(3, 'alimentos.png', 'alimentos.png', 'teste', '40.000,00', 'testee'),
(4, 'loteste.png', 'latestita.png', 'latestada', '1.000,00', 'New teste2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `carrossel`
--

CREATE TABLE `carrossel` (
  `id` bigint(20) NOT NULL,
  `Position` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  `texto` varchar(255) NOT NULL,
  `titulo` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `carrossel`
--

INSERT INTO `carrossel` (`id`, `Position`, `img`, `texto`, `titulo`) VALUES
(2, '2', 'banner1.png', ' Ajude o Lar a arrecadar fundos para a compra de aparelhos de ar condicionado para uma melhor qualidade de vida para nossos veteranos.', 'Tchau, Calor!'),
(5, '3', 'agasalho.png', 'Vamos unir forças! Com solidariedade e amor, é possível transformar frio em calor!', 'Campanha do agasalho');

-- --------------------------------------------------------

--
-- Estrutura da tabela `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(7);

-- --------------------------------------------------------

--
-- Estrutura da tabela `item`
--

CREATE TABLE `item` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `quantidade` varchar(255) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `item`
--

INSERT INTO `item` (`id`, `nome`, `quantidade`, `valor`) VALUES
(3, 'Pacote de fraldas geriátricas GG', '30', 50),
(4, 'Pacotes de copos plásticos de 180 ml', '15', 11.79),
(5, 'Pacote de  saco de lixo de 40 litros', '30', 31.99),
(6, 'Álcool em gel antisséptico 420 g', '40', 12.9),
(7, 'Muletas', '20', 120),
(8, ' Pacote de toalhas umedecidas', '45', 8.99),
(9, 'Pacote de fraldas geriátricas G', '34', 47.88);

-- --------------------------------------------------------

--
-- Estrutura da tabela `mensagem`
--

CREATE TABLE `mensagem` (
  `id` bigint(20) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `mensagem` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `mensagem`
--

INSERT INTO `mensagem` (`id`, `cidade`, `mensagem`, `nome`) VALUES
(1, 'Matão', 'testee', 'Mensageiro'),
(6, 'tet', 'tt', 'teste');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `valor` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `campanha`
--
ALTER TABLE `campanha`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `carrossel`
--
ALTER TABLE `carrossel`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `mensagem`
--
ALTER TABLE `mensagem`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
