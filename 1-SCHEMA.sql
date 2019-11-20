drop schema if exists `cuisine-db`;
  create schema if not exists `cuisine-db`;
  use `cuisine-db`;

  drop table if exists ingredients;
  drop table if exists company;
  drop table if exists users;

  create table ingredients (
    ingredient_id             bigint not null auto_increment,
    name                      varchar(255),
    constraint pk_ingredients primary key (ingredient_id))
  ;

  create table recipe_ingredients (
    recipe_ingredient_id      bigint not null auto_increment,
    ingredients_id            bigint,
    quantity                  varchar(255),
    unit                      varchar(255),
    constraint pk_recipe_ingredients primary key (recipe_ingredient_id))
  ;

  create table recipe (
    recipe_id		      bigint not null auto_increment,
    name		      varchar(255),
    pswrd                     varchar(255),
    constraint pk_recipe primary key (id))
  ;

  alter table computer add constraint fk_computer_company_1 foreign key (company_id) references company (id) on delete restrict on update restrict;
  create index ix_computer_company_1 on computer (company_id);
