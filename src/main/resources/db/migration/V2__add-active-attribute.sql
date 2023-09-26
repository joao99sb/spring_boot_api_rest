alter table medicos add active boolean not null default true;
update medicos set active = true;
