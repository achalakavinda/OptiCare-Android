var cors = require('cors')
var express = require('express'),
    bodyParser = require('body-parser'),
    port = process.env.PORT || 3000,
    app = express(),
    server = require('http').Server(app);

    app.use(cors());



app.use(bodyParser.urlencoded({ extended: true })); //to get information in html forms
app.use(bodyParser.json());

app.get('/',function(req,res){
    res.send('running peer');
});

app.post('/api/login',function(req,res){
    var x = {id:1,username:'test user',success:true , req:req.body};
    
    res.send(x);
});



app.post('/api/test/myopia',function(req,res){
    var x = req.body;

    let data = JSON.parse(x['Data']);
    data.forEach(element => {
        console.log(element);
    });

    res.send(x);
});

app.get('/api/user/:id/optician/locations',function (req,res){

    var x = {
        user: { id:1 ,username:'test user'},
        opticians: [
            {id:1 , name:'Cabraal Opticions' , lat:6.902255, lng:79.916294},
            {id:2 , name:'Wickramarachchi Opticians' , lat:6.902606, lng:79.912947 },
            {id:2 , name:'Ekanayake Opticians' , lat:6.902020, lng:79.912947 },
        ]
    }
    console.log(x);
    res.send(x);

});

server.listen(port,function(){
    console.log('http://www.localhost:'+port);
})