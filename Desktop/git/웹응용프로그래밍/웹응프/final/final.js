const express = require('express')
const app = express()
const port = 3000

const maria = require('mysql')
const db_config = {
    host:'localhost',
    port:3306,
    user:'root',
    password:'025122',
    database:'201824446'
};

app.use(express.static('public'))
app.use(express.json())


app.get('/bookmarks', function (req, res) {
    const conn = maria.createConnection(db_config);
    conn.connect();
    conn.query('select * from bookmarks order by title asc', function(error, rows, fields) {
        if (!error) {
            res.json(rows);
        }
        else {
            console.log(error);
            res.json({ "err": error });
        }
    });
    conn.end();
})

app.post('/bookmarks', function (req, res) {  
    var title = req.body.title;
    var src = req.body.src;

    const conn = maria.createConnection(db_config);
    conn.connect();
    conn.query('insert into bookmarks set name = "' + name + '", link = "' + link + '"', function(error, rows, fields) {
        if (!error) {
            console.log("insert Success.");
        }
        else {
            console.log(error);
            res.json({ "err": error });
        }
    });
    conn.query('insert into bookmarks set kind = "' + kind + '", icon = "' + icon + '"', function(error, rows, fields) {
        if (!error) {
            console.log("insert Success.");
        }
        else {
            console.log(error);
            res.json({ "err": error });
        }
    
    });
    conn.query('insert into bookmarks set visit = "' + visit + '"', function(error, rows, fields) {
        if (!error) {
            console.log("insert Success.");
        }
        else {
            console.log(error);
            res.json({ "err": error });
        }
    });
    conn.end();
})



app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})