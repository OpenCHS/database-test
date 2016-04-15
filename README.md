#Database comparison

| MongoDB        | CouchDB          | Cassandra        | PostgreSQL       | Elassandra       |
|----------------|:----------------:|:----------------:|:----------------:|:----------------:|


#PostgreSQL
With 33 Million Patients, 10K providers, 10K facilities, 33 Million Bulk Data with references to other tables.
The total space occupied by the database is `6409`MBs.

With 10 concurrent threads firing `Inserts` into a table with primary key index and 2 foreign keys, each query takes 
`0.0015047999999999928` seconds and median time of `0.001`

Selects with 3 left outer joins are also extremely fast. 


All of this on a Macbook with 16 gigs of Memory.

#MongoDB
With 33 Million patients, 10K Providers, 10K facilities, 33 Million Patients with Documents.
The total space occupied by the database is `2867`MBs.

With 10 concurrent threads firing `Inserts` into a table with primary key index and 2 foreign keys, each query takes 
`0.00686919999999998` seconds and median time of `0.005`

