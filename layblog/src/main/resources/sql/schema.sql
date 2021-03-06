/*文章分类*/
CREATE TABLE T_CATE (
  ID          INTEGER           NOT NULL AUTO_INCREMENT,
  NAME        VARCHAR(50)       NOT NULL comment '分类名称',
  CN_NAME     VARCHAR(50)       DEFAULT NULL comment '分类描述',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*文章*/
CREATE TABLE T_ARTICLE (
  ID           VARCHAR(50)  NOT NULL comment 'id',
  TITLE        VARCHAR(100) NOT NULL comment '标题',
  CATE_ID      INTEGER      NOT NULL comment '文章分类',
  COVER        VARCHAR(255) DEFAULT NULL comment '文章封面',
  SUMMARY      VARCHAR(300) DEFAULT NULL comment '文章摘要',
  CONTENT      TEXT         NOT NULL comment '内容',
  AUTHOR_ID    INTEGER      NOT NULL comment '作者',
  POST_TIME    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP() comment '创建时间',
  MODIFY_TIME  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP() comment '更改时间',
  VIEWS_CNT    INTEGER      NOT NULL DEFAULT '0' comment '浏览数',
  APPROVE_CNT  INTEGER      NOT NULL DEFAULT '0' comment '点赞数',
  APPRECIABLE  TINYINT(1)   NOT NULL DEFAULT '1' comment '是否开启点赞功能',
  COMMENTED    TINYINT(1)   NOT NULL DEFAULT '1' comment '是否开启评论功能',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*评论*/
CREATE TABLE T_COMMENT (
  ID         INTEGER 		  NOT NULL AUTO_INCREMENT comment 'id',
  USER_ID    INTEGER 		  NOT NULL comment '用户ID',
  ARTICLE_ID VARCHAR(50)     NOT NULL comment '文章ID',
  COMMENT    VARCHAR(1000)    DEFAULT NULL comment '评论内容',
  POST_TIME  TIMESTAMP        DEFAULT CURRENT_TIMESTAMP() comment '创建时间',
  IP_ADDR    VARCHAR(50)      DEFAULT NULL comment '用户IP',
  IP_CN_ADDR VARCHAR(100)     DEFAULT NULL comment '用户IP中文名',
  USER_AGENT VARCHAR(255)     DEFAULT NULL comment '用户代理',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*角色*/
CREATE TABLE T_ROLE (
  ID      INTEGER              NOT NULL AUTO_INCREMENT,
  NAME    VARCHAR(50)          NOT NULL comment '角色名称',
  CN_NAME VARCHAR(50)          DEFAULT NULL comment '角色描述',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*用户*/
CREATE TABLE T_USER (
  ID              INTEGER          NOT NULL AUTO_INCREMENT,
  USERNAME        VARCHAR(20)      DEFAULT NULL,
  NICKNAME        VARCHAR(50)      DEFAULT NULL,
  PASSWORD        VARCHAR(50)      DEFAULT NULL,
  AVATAR          VARCHAR(255)     DEFAULT NULL,
  QQ_NUM          VARCHAR(20)      DEFAULT NULL,
  ROLE_ID         INTEGER          NOT NULL,
  ENABLE          INTEGER          DEFAULT '1',
  CREATE_TIME     TIMESTAMP        DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*标签*/
CREATE TABLE T_TAG (
  ID              INTEGER         NOT NULL AUTO_INCREMENT,
  NAME            VARCHAR(50)     NOT NULL comment '标签名称',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*标签关联*/
CREATE TABLE T_TAG_REFER (
  ID              INTEGER         NOT NULL AUTO_INCREMENT,
  REFER_ID        VARCHAR(50)     NOT NULL comment '关联ID',
  TAG_ID          INTEGER         NOT NULL comment '标签ID',
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/**
 * 上传文件映射表
 */
CREATE TABLE T_UPLOAD (
  ID           INTEGER      NOT NULL AUTO_INCREMENT,
  DISK_PATH    VARCHAR(255) NOT NULL,
  VIRTUAL_PATH VARCHAR(255) NOT NULL,
  UPLOAD       TIMESTAMP    DEFAULT CURRENT_TIMESTAMP(),
  FILE_TYPE    VARCHAR(50)  NOT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;