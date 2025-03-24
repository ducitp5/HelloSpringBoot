-- test.users definition

CREATE TABLE `users` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `name` varchar(255) DEFAULT NULL,
                         `email` varchar(255) DEFAULT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.posts definition

CREATE TABLE `posts` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `content` text NOT NULL,
                         `user_id` bigint NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `fk_posts_user` (`user_id`),
                         CONSTRAINT `fk_posts_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.profiles definition

CREATE TABLE `profiles` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `avatar_url` varchar(255) DEFAULT NULL,
                            `bio` varchar(255) DEFAULT NULL,
                            `user_id` bigint NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `UK4ixsj6aqve5pxrbw2u0oyk8bb` (`user_id`),
                            CONSTRAINT `fk_profiles_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- test.comments definition

CREATE TABLE `comments` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `content` text,
                            `post_id` bigint NOT NULL,
                            `user_id` bigint NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `fk_comments_post` (`post_id`),
                            KEY `fk_comments_user` (`user_id`),
                            CONSTRAINT `fk_comments_post` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`) ON DELETE CASCADE,
                            CONSTRAINT `fk_comments_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;