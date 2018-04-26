--More Chinook Practice
--Andrew Ahn
--andrewsrahn@gmail.com
--Revature
--JTA 1804
--April 25, 2018

--Write a SQL Query that contains the names of all tracks that are longer than 6 minutes
select name from track where milliseconds>6000;
--Write a SQL Query to find the biggest song (which takes up the most space)
select * from track where bytes =
    (select max(bytes) from track);
    
--Write a SQL Query that contains the titles of all albums with tracks longer than 6 minutes in them 
select title from album where albumid in(
    select trackid from track where milliseconds>6000);
    
--Write a SQL Query that contains the albumId and number of songs in the album
select t.albumid, count(t.albumid) as numberofsongs from album a left join track t on a.albumid=t.albumid group by t.albumid;

--Write a SQL query that contains artist's names and the number of tracks they have produced (assume an artist produced a track 
--if it appears in one of their albums)


--Write a SQL Query that returns the most purchased media type

--Write a SQL Query showing customers not in the US


--Write a SQL Query showing a unique list of billing countries on the Invoice table


--Write a SQL Query that shows the Invoice Total, Customer Name, Country, and Sales agent for all invoices and customers 


--Write a SQL Query that shows all Tracks, but displays no IDs. Should also include the Album name, Media Type, and Genre


--Write a SQL Query that returns the Top 40 Songs for 2013


--Write a SQL Query that shows which sales agent made the most in sales overall


--Write a SQL Query that shows the top 3 best selling artists 


--Write a SQL Query that returns which albums have no Heavy Metal tracks


--Write a SQL Query to find the the managers of employees supporting Brazilian customers 