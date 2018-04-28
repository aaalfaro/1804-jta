--Write a SQL Query that contains the names of all tracks that are longer than 6 minutes
select * FROM track WHERE MILLISECONDS > 360000;
--Write a SQL Query to find the biggest song (which takes up the most space)
select * FROM track ORDER BY BYTES DESC;
--Write a SQL Query that contains the titles of all albums with tracks longer than 6 minutes in them 
select * FROM album WHERE albumid IN(
select albumid FROM track WHERE MILLISECONDS > 360000
);
--Write a SQL Query that contains the albumId and number of songs in the album 
select albumid, COUNT(albumid) FROM (
select album.albumid FROM album, track WHERE album.albumid = track.albumid )
GROUP BY albumid HAVING COUNT(albumid) > 1;
--Write a SQL query that contains artist's names and the number of tracks they have produced (assume an artist produced a track if it appears in one of their albums)

--Write a SQL Query that returns the most purchased media type
SELECT mediatypeid, COUNT(mediatypeid), name FROM (
SELECT track.mediatypeid, mediatype.NAME FROM mediatype, track WHERE mediatype.mediatypeid = track.mediatypeid)
GROUP BY mediatypeid, name HAVING COUNT(mediatypeid) > 1;
--Write a SQL Query showing customers not in the US
SELECT * FROM customer WHERE country <> 'USA';
--Write a SQL Query showing a unique list of billing countries on the Invoice table
SELECT DISTINCT billingcountry FROM invoice;
--Write a SQL Query that shows the Invoice Total, Customer Name, Country, and Sales agent for all invoices and customers 
SELECT invoice.total, invoice.billingcountry, customer.CUSTOMERID FROM invoice, customer WHERE customer.CUSTOMERID = invoice.CUSTOMERID ;
--Write a SQL Query that shows all Tracks, but displays no IDs. Should also include the Album name, Media Type, and Genre

--Write a SQL Query that returns the Top 40 Songs for 2013

--Write a SQL Query that shows which sales agent made the most in sales overall

--Write a SQL Query that shows the top 3 best selling artists 

--Write a SQL Query that returns which albums have no Heavy Metal tracks

--Write a SQL Query to find the the managers of employees supporting Brazilian customers 