select c.name as company,
       t.plane as type,
       t.town_from as dep,
       t.town_to as arr
from Trip t
         left join Company c on t.ID_comp = c.ID_comp


SELECT p.name as name,
       Pit.place as plase,
       c.name as company,
       t.plane as type,
       t.town_from as dep,
       t.town_to as arr
from Passenger p
         join Pass_in_trip Pit on p.ID_psg = Pit.ID_psg
         join Trip t on Pit.trip_no = t.trip_no
         left join Company c on t.ID_comp = c.ID_comp
where p.name = 'Jennifer Lopez' and c.name = 'KLM' ;



SELECT p.name, count(*)
from Passenger p
         join Pass_in_trip Pit on p.ID_psg = Pit.ID_psg
         join Trip t on Pit.trip_no = t.trip_no
         left join Company c on t.ID_comp = c.ID_comp
where p.name = 'Jennifer Lopez' and c.name = 'KLM' ;



SELECT p.name, count(*)
from Passenger p
         join Pass_in_trip Pit on p.ID_psg = Pit.ID_psg
         join Trip t on Pit.trip_no = t.trip_no
         left join Company c on t.ID_comp = c.ID_comp
group by p.name
order by count(*) desc limit 3;
