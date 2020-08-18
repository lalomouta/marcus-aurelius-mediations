--fuente: https://www.microfocus.com/documentation/borland-connect/3.1/install-help/GUID-B4126D72-0803-472F-B8A8-ED8965BE236B.html


--ejecutar en ij>
connect 'jdbc:derby:marcus-aurelius-db;create=true;territory=en_US;collation=TERRITORY_BASED;user=derby;password=derby';

connect 'jdbc:derby:marcus-aurelius-db;create=false;user=derby;password=derby';

call SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.connection.requireAuthentication','true');
call SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.authentication.provider','BUILTIN');
call SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.user.<admin user name>', 'derby');
call SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY('derby.database.fullAccessusers', 'derby');

//devolver primer registro
 select * from tweets fetch first row only;

SELECT * FROM tweets where wastweeted='false' ORDER BY id FETCH first row ONLY;