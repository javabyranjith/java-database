--INNER JOIN (SIMPLE JOIN)
SELECT ei.empid, ei.firstname, ei.designation, ec.country
FROM empinfo ei, empcontact ec
WHERE ei.empid=ec.empid;

--LEFT OUTER JOIN 1 (LEFT JOIN or LEFT OUTER JOIN)
SELECT ei.empid, ei.firstname, es.basic
FROM empinfo ei
LEFT JOIN empsalary es
ON ei.empid=1000;

1000	Ranjith	10000
1000	Ranjith	15000
1000	Ranjith	12000
1000	Ranjith	20000
1000	Ranjith	18000
2000	Kumar	NULL
3000	Bala	NULL
4000	Ganesh	NULL
5000	Suresh	NULL

--LEFT OUTER JOIN 2
SELECT ei.empid, ei.firstname, es.basic
FROM empinfo ei
LEFT JOIN empsalary es
ON ei.empid=es.empid;

1000	Ranjith	10000
2000	Kumar	15000
3000	Bala	12000
4000	Ganesh	20000
5000	Suresh	18000

--RIGHT OUTER JOIN 1
SELECT ei.empid, ei.firstname, es.basic
FROM empinfo ei
RIGHT OUTER JOIN empsalary es
ON es.basic>15000;

NULL	NULL	10000
NULL	NULL	15000
NULL	NULL	12000
1000	Ranjith	20000
2000	Kumar	20000
3000	Bala	20000
4000	Ganesh	20000
5000	Suresh	20000
1000	Ranjith	18000
2000	Kumar	18000
3000	Bala	18000
4000	Ganesh	18000
5000	Suresh	18000

--RIGHT OUTER JOIN 2
SELECT ei.empid, ei.firstname, es.basic
FROM empinfo ei
RIGHT OUTER JOIN empsalary es
ON ei.empid=es.empid;

1000	Ranjith	10000
2000	Kumar	15000
3000	Bala	12000
4000	Ganesh	20000
5000	Suresh	18000
