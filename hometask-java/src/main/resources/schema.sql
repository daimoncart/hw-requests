CREATE TABLE IF NOT EXISTS `request` (
  `id`          INTEGER  PRIMARY KEY AUTO_INCREMENT,
  `reasoning`   VARCHAR(120) NOT NULL,
  `status`      VARCHAR(10)  NOT NULL,
  `total`      DOUBLE  NOT NULL,
  `createdDate`    TIMESTAMP WITH TIME ZONE,
  PRIMARY KEY(`id`)
);