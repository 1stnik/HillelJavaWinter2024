-- group list
select distinct s.student_group from student s order by s.student_group;

select * from student where student_group = :groupName;


select * from student where last_name like 'U%' and student_group = 'GR-01';

select * from student where last_name like 'A%';

insert into student (first_name, last_name, date_of_birth, email, student_group, country)
values ('Alex', 'Stepurko', '1983-12-08', 'mail@mail.com', 'GR-71', 'Ukraine');


update student set first_name = '1',
                   last_name = '2',
                   date_of_birth = '1983-08-21',
                   email = '1@1.com',
                   student_group = '1',
                   country = '1'
where id = 1001;


delete from student where id = 1001;
