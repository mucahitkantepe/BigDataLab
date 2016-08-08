CREATE TABLE user_info (
   name         VARCHAR(80)         NOT NULL,
   lastname     VARCHAR(80)         NOT NULL,
   email        VARCHAR(256)        PRIMARY KEY  NOT NULL,
   phone        VARCHAR(20)         NOT NULL,
   photo        TEXT,
   website      VARCHAR(256),
   notes        TEXT
);

# --- !Downs
drop table user_info;

