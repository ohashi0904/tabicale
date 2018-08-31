set names utf8;
set foreign_key_checks=0;

drop database if exists tabicale;
create database if not exists tabicale;

use tabicale;

create table user_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) unique not null comment "ユーザーID",
password varchar(16) not null comment "パスワード",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓ふりがな",
first_name_kana varchar(32) not null comment "名ふりがな",
sex tinyint not null default 0 comment "性別",
email varchar(32) not null comment "メールアドレス",
status tinyint not null default 0 comment "ステータス",
logined tinyint not null default 0 comment "ログインフラグ",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日"
)
default charset=utf8
comment="会員情報テーブル"
;
insert into user_info values
(1,"guest","guest","インターノウス","ゲストユーザー","いんたーのうす","げすとゆーざー",0,"guest@gmail.com",0,0,now(),now()),
(2,"guest2","guest2","インターノウス","ゲストユーザー2","いんたーのうす","げすとゆーざー2",0,"guest2@gmail.com",0,0,now(),now()),
(3,"guest3","guest3","インターノウス","ゲストユーザー3","いんたーのうす","げすとゆーざー3",0,"guest3@gmail.com",0,0,now(),now()),
(4,"guest4","guest4","インターノウス","ゲストユーザー4","いんたーのうす","げすとゆーざー4",0,"guest4@gmail.com",0,0,now(),now()),
(5,"guest5","guest5","インターノウス","ゲストユーザー5","いんたーのうす","げすとゆーざー5",0,"guest5@gmail.com",0,0,now(),now()),
(6,"guest6","guest6","インターノウス","ゲストユーザー6","いんたーのうす","げすとゆーざー6",0,"guest6@gmail.com",0,0,now(),now()),
(7,"guest7","guest7","インターノウス","ゲストユーザー7","いんたーのうす","げすとゆーざー7",0,"guest7@gmail.com",0,0,now(),now()),
(8,"guest8","guest8","インターノウス","ゲストユーザー8","いんたーのうす","げすとゆーざー8",0,"guest8@gmail.com",0,0,now(),now()),
(9,"guest9","guest9","インターノウス","ゲストユーザー9","いんたーのうす","げすとゆーざー9",0,"guest9@gmail.com",0,0,now(),now()),
(10,"guest10","guest10","インターノウス","ゲストユーザー10","いんたーのうす","げすとゆーざー10",0,"guest10@gmail.com",0,0,now(),now()),
(11,"guest11","guest11","インターノウス","ゲストユーザー11","いんたーのうす","げすとゆーざー11",0,"guest11@gmail.com",0,0,now(),now()),
(12,"guest12","guest12","インターノウス","ゲストユーザー12","いんたーのうす","げすとゆーざー12",0,"guest12@gmail.com",0,0,now(),now()),
(13,"guest13","guest13","インターノウス","ゲストユーザー13","いんたーのうす","げすとゆーざー13",0,"guest13@gmail.com",0,0,now(),now()),
(14,"guest14","guest14","インターノウス","ゲストユーザー14","いんたーのうす","げすとゆーざー14",0,"guest14@gmail.com",0,0,now(),now()),
(15,"admin","admin","インターノウス","管理者ユーザー","いんたーのうす","かんりしゃゆーざー",0,"admin@gmail.com",1,0,now(),now()),
(16,"admin2","admin2","インターノウス","管理者ユーザー2","いんたーのうす","かんりしゃゆーざー2",0,"admin2@gmail.com",1,0,now(),now()),
(17,"admin3","admin3","インターノウス","管理者ユーザー3","いんたーのうす","かんりしゃゆーざー3",0,"admin3@gmail.com",1,0,now(),now()),
(18,"admin4","admin4","インターノウス","管理者ユーザー4","いんたーのうす","かんりしゃゆーざー4",0,"admin4@gmail.com",1,0,now(),now()),
(19,"admin5","admin5","インターノウス","管理者ユーザー5","いんたーのうす","かんりしゃゆーざー5",0,"admin5@gmail.com",1,0,now(),now()),
(20,"admin6","admin6","インターノウス","管理者ユーザー6","いんたーのうす","かんりしゃゆーざー6",0,"admin6@gmail.com",1,0,now(),now()),
(21,"admin7","admin7","インターノウス","管理者ユーザー7","いんたーのうす","かんりしゃゆーざー7",0,"admin7@gmail.com",1,0,now(),now()),
(22,"admin8","admin8","インターノウス","管理者ユーザー8","いんたーのうす","かんりしゃゆーざー8",0,"admin8@gmail.com",1,0,now(),now()),
(23,"admin9","admin9","インターノウス","管理者ユーザー9","いんたーのうす","かんりしゃゆーざー9",0,"admin9@gmail.com",1,0,now(),now()),
(24,"admin10","admin10","インターノウス","管理者ユーザー10","いんたーのうす","かんりしゃゆーざー10",0,"admin10@gmail.com",1,0,now(),now()),
(25,"admin11","admin11","インターノウス","管理者ユーザー11","いんたーのうす","かんりしゃゆーざー11",0,"admin11@gmail.com",1,0,now(),now()),
(26,"admin12","admin12","インターノウス","管理者ユーザー12","いんたーのうす","かんりしゃゆーざー12",0,"admin12@gmail.com",1,0,now(),now()),
(27,"admin13","admin13","インターノウス","管理者ユーザー13","いんたーのうす","かんりしゃゆーざー13",0,"admin13@gmail.com",1,0,now(),now()),
(28,"admin14","admin14","インターノウス","管理者ユーザー14","いんたーのうす","かんりしゃゆーざー14",0,"admin14@gmail.com",1,0,now(),now());

create table product_info(
id int primary key not  null auto_increment comment "ID",
product_id int unique not null comment "商品ID",
product_name varchar(50) unique not null comment "商品名",
product_name_kana varchar(50) unique not null comment "商品名かな",
product_description varchar(255) not null comment "商品詳細",
category_id int not null comment "カテゴリID",
price int comment "価格",
image_file_path varchar(100) comment "画像ファイルパス",
image_file_name varchar(50) comment "画像ファイル名",
image_file_name_2 varchar(50) comment "画像ファイル名2",
release_date datetime not null comment "発売年月",
release_company varchar(50) comment "発売会社",
status tinyint not null default 0 comment "ステータス",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日",
foreign key(category_id) references m_category(category_id)
)
default charset=utf8
comment="商品情報テーブル"
;
insert into product_info values
(1,1,"アジアの建築物のカレンダー1","あじあのけんちくぶつのかれんだー1","アジアの建築物のカレンダーです。",2,1000,"./images","Asia_Front_1.jpg","Asia_Cale_1.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(2,2,"アジアの風景のカレンダー2","あじあのふうけいのかれんだー2","アジアの風景のカレンダーです。",2,2000,"./images","Asia_Front_2.jpg","Asia_Cale_2.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(3,3,"アジアの建築物のカレンダー3","あじあのけんちくぶつのかれんだー3","アジアの建築物のカレンダーです。",2,3000,"./images","Asia_Front_3.jpg","Asia_Cale_3.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(4,4,"アメリカの風景のカレンダー1","あめりかのふうけいのかれんだー1","アメリカの風景のカレンダーです。",3,1500,"./images","America_Front_1.jpg","America_Cale_1.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(5,5,"アメリカの建築物のカレンダー2","あめりかのけんちくぶつのかれんだー2","アメリカの建築物カレンダーです。",3,2500,"./images","America_Front_2.jpg","America_Cale_2.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(6,6,"アメリカの風景のカレンダー3","あめりかのふうけいのかれんだー3","アメリカの風景のカレンダーです。",3,3500,"./images","America_Front_3.jpg","America_Cale_3.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(7,7,"アフリカの風景のカレンダー1","あふりかのふうけいのかれんだー1","アフリカの風景のカレンダーです。",4,2000,"./images","Africa_Front_1.jpg","Africa_Cale_1.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(8,8,"アフリカの風景のカレンダー2","あふりかのふうけいのかれんだー2","アフリカの風景のカレンダーです。",4,3000,"./images","Africa_Front_2.jpg","Africa_Cale_2.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(9,9,"アフリカの風景のカレンダー3","あふりかのふうけいのかれんだー3","アフリカの風景のカレンダーです。",4,4000,"./images","Africa_Front_3.jpg","Africa_Cale_3.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(10,10,"ヨーロッパの風景のカレンダー1","よーろっぱのふうけいのかれんだー1","ヨーロッパの風景のカレンダーです。",5,2500,"./images","Europa_Front_1.jpg","Europa_Cale_1.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(11,11,"ヨーロッパの建築物のカレンダー2","よーろっぱのけんちくぶつのかれんだー2","ヨーロッパの建築物のカレンダーです。",5,3500,"./images","Europa_Front_2.jpg","Europa_Cale_2.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(12,12,"ヨーロッパの建築物のカレンダー3","よーろっぱのけんちくぶつのかれんだー3","ヨーロッパの建築物のカレンダーです。",5,4500,"./images","Europa_Front_3.jpg","Europa_Cale_3.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(13,13,"オセアニアの風景のカレンダー1","おせあにあのふうけいのかれんだー1","オセアニアの風景のカレンダーです。",6,3000,"./images","Oceania_Front_1.jpg","Oceania_Cale_1.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(14,14,"オセアニアの動物のカレンダー2","おせあにあのどうぶつのかれんだー2","オセアニアの動物のカレンダーです。",6,4000,"./images","Oceania_Front_2.jpg","Oceania_Cale_2.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(15,15,"オセアニアの風景のカレンダー3","おせあにあのふうけいのかれんだー3","オセアニアの風景のカレンダーです。",6,5000,"./images","Oceania_Front_3.jpg","Oceania_Cale_3.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(16,16,"アジアの風景のカレンダー4","あじあのふうけいのかれんだー4","アジアの風景のカレンダーです。",2,1500,"./images","Asia_Front_4.jpg","Asia_Cale_4.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(17,17,"アジアの風景のカレンダー5","あじあのふうけいのかれんだー5","アジアの風景のカレンダーです。",2,2500,"./images","Asia_Front_5.jpg","Asia_Cale_5.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(18,18,"南アメリカの建築物のカレンダー4","みなみあめりかのけんちくぶつのかれんだー4","南アメリカの建築物のカレンダーです。",3,2000,"./images","America_Front_4.jpg","America_Cale_4.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(19,19,"南アメリカの風景のカレンダー5","みなみあめりかのふうけいのかれんだー5","南アメリカの風景のカレンダーです。",3,3000,"./images","America_Front_5.jpg","America_Cale_5.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(20,20,"アフリカの動物のカレンダー4","あふりかのどうぶつのかれんだー4","アフリカのどうぶつのカレンダーです。",4,2500,"./images","Africa_Front_4.jpg","Africa_Cale_4.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(21,21,"アフリカの動物のカレンダー5","あふりかのどうぶつのかれんだー5","アフリカのどうぶつのカレンダーです。",4,3500,"./images","Africa_Front_5.jpg","Africa_Cale_5.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(22,22,"ヨーロッパの風景のカレンダー4","よーろっぱのふうけいのかれんだー4","ヨーロッパの風景のカレンダーです。",5,3000,"./images","Europa_Front_4.jpg","Europa_Cale_4.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(23,23,"ヨーロッパの建築物のカレンダー5","よーろっぱのけんちくぶつのかれんだー5","ヨーロッパの建築物のカレンダーです。",5,4000,"./images","Europa_Front_5.jpg","Europa_Cale_5.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(24,24,"オセアニアの動物のカレンダー4","おせあにあのどうぶつのかれんだー4","オセアニアの動物のカレンダーです。",6,3500,"./images","Oceania_Front_4.jpg","Oceania_Cale_4.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now()),
(25,25,"オセアニアの建築物のカレンダー5","おせあにあのけんちくぶつのかれんだー5","オセアニアの建築物のカレンダーです。",6,4500,"./images","Oceania_Front_5.jpg","Oceania_Cale_5.jpg","2018-08-10 12:00:00","project.TabiCale",0,now(),now());

create table cart_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
temp_user_id varchar(16) comment "仮ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カート情報テーブル"
;

create table purchase_history_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
product_id int not null comment "商品ID",
product_count int not null comment "個数",
price int not null comment "金額",
destination_id int not null comment "宛先情報ID",
regist_date datetime not null comment "登録日",
update_date datetime not null comment "更新日",
foreign key(product_id) references product_info(product_id)
)
default charset=utf8
comment="購入履歴情報テーブル"
;
create table destination_info(
id int primary key not null auto_increment comment "ID",
user_id varchar(16) not null comment "ユーザーID",
family_name varchar(32) not null comment "姓",
first_name varchar(32) not null comment "名",
family_name_kana varchar(32) not null comment "姓ふりがな",
first_name_kana varchar(32) not null comment "名ふりがな",
email varchar(32) not null comment "メールアドレス",
tel_number varchar(13) not null comment "電話番号",
user_address varchar(50) not null comment "住所",
regist_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="宛先情報テーブル"
;
insert into destination_info values
(1,"guest","インターノウス","テストユーザー","いんたーのうす","てすとゆーざー","guest@internous.co.jp","080-1234-5678","東京都千代田区三番町１ー１　ＫＹ三番町ビル１Ｆ",now(),now());

create table m_category(
id int primary key not null comment "ID",
category_id int not null unique comment "カテゴリID",
category_name varchar(20) not null unique comment "カテゴリ名",
category_description varchar(100) comment "カテゴリ詳細",
insert_date datetime not null comment "登録日",
update_date datetime comment "更新日"
)
default charset=utf8
comment="カテゴリマスタテーブル"
;
insert into m_category values
(1,1,"全てのカテゴリー","全てのカテゴリーが対象になります",now(),null),
(2,2,"アジア","アジアに関するカテゴリーが対象になります",now(),null),
(3,3,"アメリカ","アメリカに関するカテゴリーが対象になります",now(),null),
(4,4,"アフリカ","アフリカに関するカテゴリーが対象になります",now(),null),
(5,5,"ヨーロッパ","ヨーロッパに関するカテゴリーが対象になります",now(),null),
(6,6,"オセアニア","オセアニアに関するカテゴリーが対象になります",now(),null);