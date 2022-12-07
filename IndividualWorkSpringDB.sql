-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 07 2022 г., 10:01
-- Версия сервера: 5.7.39-log
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `IndividualWorkSpringDB`
--

-- --------------------------------------------------------

--
-- Структура таблицы `direction_group`
--

CREATE TABLE `direction_group` (
  `id` bigint(20) NOT NULL,
  `name_direction` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `direction_group`
--

INSERT INTO `direction_group` (`id`, `name_direction`) VALUES
(1, 'Физ-мат'),
(2, 'Хим-био'),
(3, 'Гуманитарный');

-- --------------------------------------------------------

--
-- Структура таблицы `final_lesson`
--

CREATE TABLE `final_lesson` (
  `id` bigint(20) NOT NULL,
  `home_work` varchar(50) DEFAULT NULL,
  `topic` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(3);

-- --------------------------------------------------------

--
-- Структура таблицы `lesson`
--

CREATE TABLE `lesson` (
  `id` bigint(20) NOT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `teacher_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `lesson`
--

INSERT INTO `lesson` (`id`, `subject_id`, `teacher_id`) VALUES
(1, 1, 1),
(2, 2, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `member`
--

CREATE TABLE `member` (
  `id` bigint(20) NOT NULL,
  `place` int(11) NOT NULL,
  `olympiad_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `member`
--

INSERT INTO `member` (`id`, `place`, `olympiad_id`, `student_id`) VALUES
(1, 1, 1, 1),
(2, 2, 2, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `olympiad`
--

CREATE TABLE `olympiad` (
  `id` bigint(20) NOT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `subject_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `olympiad`
--

INSERT INTO `olympiad` (`id`, `date_time`, `name`, `subject_id`, `type_id`) VALUES
(1, '2022-12-06 23:03:00.000000', 'Мишка', 1, 1),
(2, '2022-12-21 06:32:00.000000', 'Мишка2', 2, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `squad`
--

CREATE TABLE `squad` (
  `id` bigint(20) NOT NULL,
  `amount` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `direction_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `squad`
--

INSERT INTO `squad` (`id`, `amount`, `name`, `direction_id`) VALUES
(1, 30, 'П50-1-19', 1),
(2, 640, 'БИ-2-20', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `student_group`
--

CREATE TABLE `student_group` (
  `id` bigint(20) NOT NULL,
  `group_squad_id` bigint(20) DEFAULT NULL,
  `student_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `student_group`
--

INSERT INTO `student_group` (`id`, `group_squad_id`, `student_id`) VALUES
(1, 1, 3),
(2, 2, 3);

-- --------------------------------------------------------

--
-- Структура таблицы `subject_lesson`
--

CREATE TABLE `subject_lesson` (
  `id` bigint(20) NOT NULL,
  `hours` int(11) DEFAULT NULL,
  `name_subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `subject_lesson`
--

INSERT INTO `subject_lesson` (`id`, `hours`, `name_subject`) VALUES
(1, 56, 'Литература'),
(2, 60, 'Русский язык'),
(3, 70, 'Математика');

-- --------------------------------------------------------

--
-- Структура таблицы `subject_olympiad`
--

CREATE TABLE `subject_olympiad` (
  `id` bigint(20) NOT NULL,
  `name_subject` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `subject_olympiad`
--

INSERT INTO `subject_olympiad` (`id`, `name_subject`) VALUES
(1, 'Русский язык'),
(2, 'Русская литература');

-- --------------------------------------------------------

--
-- Структура таблицы `type_olympiad`
--

CREATE TABLE `type_olympiad` (
  `id` bigint(20) NOT NULL,
  `name_type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `type_olympiad`
--

INSERT INTO `type_olympiad` (`id`, `name_type`) VALUES
(1, 'Городская'),
(2, 'Областная');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `middle_name` varchar(50) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(250) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `first_name`, `last_name`, `middle_name`, `active`, `password`, `username`) VALUES
(1, 'Екатерина', 'Ситникова', 'Георгиевна', b'1', '$2a$08$IGBGay8Z89hv9BH4onwWNOOCvSWj2xoScB4yyX5X6FutSvBGZngUG', 'admin'),
(3, 'Лиза', 'Анохина', '', b'1', '$2a$08$zqx7e.3/wHbVBZ2enKxJfeJ7WHbC1EeRpHx8J2EtWrOcAp5vCmwzi', 'sitkat'),
(4, '', '', '', b'1', '$2a$08$hCyHKc4g7//UkN7RgJaJGOkuNTB9lgUicOgD68skPvTrU8yTwGfp6', 'teacher');

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'ADMIN'),
(3, 'STUDENT'),
(4, 'TEACHER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `direction_group`
--
ALTER TABLE `direction_group`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `final_lesson`
--
ALTER TABLE `final_lesson`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `lesson`
--
ALTER TABLE `lesson`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2yvwrtffkfijhokahkx3txhan` (`subject_id`),
  ADD KEY `FKe90hlqoby7nbcgxgb169cb2dg` (`teacher_id`);

--
-- Индексы таблицы `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqrodrx7nhjbl2f5b4e1d2j7kx` (`olympiad_id`),
  ADD KEY `FK51iqu2r7nllil9qr28a6wsbt9` (`student_id`);

--
-- Индексы таблицы `olympiad`
--
ALTER TABLE `olympiad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK22uvpix5gsq9xgds5s62ilvcm` (`subject_id`),
  ADD KEY `FK80daak2yol4dkibcx5tpy4o8f` (`type_id`);

--
-- Индексы таблицы `squad`
--
ALTER TABLE `squad`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK82gl3cfav6rymdyx47rgjb4cf` (`direction_id`);

--
-- Индексы таблицы `student_group`
--
ALTER TABLE `student_group`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkkhrdrmylkd9fjh61w1yaacel` (`group_squad_id`),
  ADD KEY `FKo0h5m694ojcark4483a26idiq` (`student_id`);

--
-- Индексы таблицы `subject_lesson`
--
ALTER TABLE `subject_lesson`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `subject_olympiad`
--
ALTER TABLE `subject_olympiad`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `type_olympiad`
--
ALTER TABLE `type_olympiad`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `direction_group`
--
ALTER TABLE `direction_group`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `final_lesson`
--
ALTER TABLE `final_lesson`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `lesson`
--
ALTER TABLE `lesson`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `olympiad`
--
ALTER TABLE `olympiad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `squad`
--
ALTER TABLE `squad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `student_group`
--
ALTER TABLE `student_group`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `subject_lesson`
--
ALTER TABLE `subject_lesson`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `subject_olympiad`
--
ALTER TABLE `subject_olympiad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `type_olympiad`
--
ALTER TABLE `type_olympiad`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `lesson`
--
ALTER TABLE `lesson`
  ADD CONSTRAINT `FK2yvwrtffkfijhokahkx3txhan` FOREIGN KEY (`subject_id`) REFERENCES `subject_lesson` (`id`),
  ADD CONSTRAINT `FKe90hlqoby7nbcgxgb169cb2dg` FOREIGN KEY (`teacher_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `FK51iqu2r7nllil9qr28a6wsbt9` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKqrodrx7nhjbl2f5b4e1d2j7kx` FOREIGN KEY (`olympiad_id`) REFERENCES `olympiad` (`id`);

--
-- Ограничения внешнего ключа таблицы `olympiad`
--
ALTER TABLE `olympiad`
  ADD CONSTRAINT `FK22uvpix5gsq9xgds5s62ilvcm` FOREIGN KEY (`subject_id`) REFERENCES `subject_olympiad` (`id`),
  ADD CONSTRAINT `FK80daak2yol4dkibcx5tpy4o8f` FOREIGN KEY (`type_id`) REFERENCES `type_olympiad` (`id`);

--
-- Ограничения внешнего ключа таблицы `squad`
--
ALTER TABLE `squad`
  ADD CONSTRAINT `FK82gl3cfav6rymdyx47rgjb4cf` FOREIGN KEY (`direction_id`) REFERENCES `direction_group` (`id`);

--
-- Ограничения внешнего ключа таблицы `student_group`
--
ALTER TABLE `student_group`
  ADD CONSTRAINT `FKkkhrdrmylkd9fjh61w1yaacel` FOREIGN KEY (`group_squad_id`) REFERENCES `squad` (`id`),
  ADD CONSTRAINT `FKo0h5m694ojcark4483a26idiq` FOREIGN KEY (`student_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
