-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 07/12/2024 às 18:53
-- Versão do servidor: 8.3.0
-- Versão do PHP: 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `smartcompany`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `alertas_estoque`
--

DROP TABLE IF EXISTS `alertas_estoque`;
CREATE TABLE IF NOT EXISTS `alertas_estoque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_produto` bigint DEFAULT NULL,
  `data_alerta` date DEFAULT NULL,
  `mensagem` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produto` (`id_produto`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `alertas_estoque`
--

INSERT INTO `alertas_estoque` (`id`, `id_produto`, `data_alerta`, `mensagem`) VALUES
(1, 1, '2024-09-28', 'Produto com Estoque baixo'),
(2, 1, '2024-10-20', 'Estoque baixo para o produto ID 1. Quantidade atual: 5');

-- --------------------------------------------------------

--
-- Estrutura para tabela `caixa`
--

DROP TABLE IF EXISTS `caixa`;
CREATE TABLE IF NOT EXISTS `caixa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `data_abertura` datetime DEFAULT NULL,
  `data_fechamento` datetime DEFAULT NULL,
  `saldo` decimal(10,2) DEFAULT NULL,
  `registros` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `caixa`
--

INSERT INTO `caixa` (`id`, `data_abertura`, `data_fechamento`, `saldo`, `registros`) VALUES
(1, '2024-10-13 00:00:00', '2024-10-14 00:00:00', 100.00, 'Saldo Inicial');

-- --------------------------------------------------------

--
-- Estrutura para tabela `clientes`
--

DROP TABLE IF EXISTS `clientes`;
CREATE TABLE IF NOT EXISTS `clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `email` varchar(80) DEFAULT NULL,
  `telefone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `email`, `telefone`) VALUES
(4, 'Gabriel', 'gabriel@gmail.com', '15997671792');

-- --------------------------------------------------------

--
-- Estrutura para tabela `estoque`
--

DROP TABLE IF EXISTS `estoque`;
CREATE TABLE IF NOT EXISTS `estoque` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_venda` bigint DEFAULT NULL,
  `id_produto` bigint DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_venda` (`id_venda`),
  KEY `id_produto` (`id_produto`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `estoque`
--

INSERT INTO `estoque` (`id`, `id_venda`, `id_produto`, `quantidade`) VALUES
(1, 1, 1, 37),
(2, NULL, 9, 10),
(3, NULL, 10, 100),
(4, NULL, 11, 100),
(5, NULL, 12, 50),
(6, NULL, 13, 50),
(7, NULL, 14, 10);

-- --------------------------------------------------------

--
-- Estrutura para tabela `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
CREATE TABLE IF NOT EXISTS `fornecedores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `contato` varchar(15) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `cnpj` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `pagamentos`
--

DROP TABLE IF EXISTS `pagamentos`;
CREATE TABLE IF NOT EXISTS `pagamentos` (
  `id` int NOT NULL,
  `id_venda` bigint DEFAULT NULL,
  `metodo_pagamento` varchar(20) DEFAULT NULL,
  `data_pagamento` date DEFAULT NULL,
  `valor_pago` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_venda` (`id_venda`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `pagamentos`
--

INSERT INTO `pagamentos` (`id`, `id_venda`, `metodo_pagamento`, `data_pagamento`, `valor_pago`) VALUES
(1, 1, 'a vista', '2024-09-28', 10.00);

-- --------------------------------------------------------

--
-- Estrutura para tabela `produtos`
--

DROP TABLE IF EXISTS `produtos`;
CREATE TABLE IF NOT EXISTS `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(80) DEFAULT NULL,
  `categoria` varchar(30) DEFAULT NULL,
  `preco` decimal(10,2) DEFAULT NULL,
  `quantidade_estoque` int DEFAULT NULL,
  `limite_estoque` int DEFAULT NULL,
  `data_adicao` date DEFAULT NULL,
  `id_fornecedor` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_fornecedor` (`id_fornecedor`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `produtos`
--

INSERT INTO `produtos` (`id`, `nome`, `categoria`, `preco`, `quantidade_estoque`, `limite_estoque`, `data_adicao`, `id_fornecedor`) VALUES
(13, 'Hortela', 'Hortaliça', 8.00, 50, 80, '2024-12-03', 1),
(11, 'Alface', 'Vegetal', 10.00, 100, 150, '2024-12-03', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `vendas`
--

DROP TABLE IF EXISTS `vendas`;
CREATE TABLE IF NOT EXISTS `vendas` (
  `id` bigint NOT NULL,
  `data_venda` date DEFAULT NULL,
  `valor_total` decimal(10,2) DEFAULT NULL,
  `id_cliente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_cliente` (`id_cliente`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Despejando dados para a tabela `vendas`
--

INSERT INTO `vendas` (`id`, `data_venda`, `valor_total`, `id_cliente`) VALUES
(1, '2024-09-28', 150.00, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
