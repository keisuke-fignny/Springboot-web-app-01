CREATE TABLE `user`
(
    `id`           int          NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) NOT NULL DEFAULT '',
    `mail_address` varchar(255) NOT NULL DEFAULT '',
    `pict_path`    varchar(255) NOT NULL DEFAULT '/user_pict/default.png',
    `created_at`   datetime     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
)
