//Generate JWT Token: Signup Route


router.post('/users/signup', function (req, res, next) {
   var body = req.body;
   var hash = bcrypt.hashSync(body.password.trim(), 10);
   var user = new user({
      name: body.name.trim(),
      username: body.username.trim(),
      email: body.email.trim(),
      password: hash,
      admin: false,
      isEmailVerified: false
   });

   //1/ Save User
   user.save(function (err, user) {
      if (err) throw err;
      //2/enerate Token
      var token = utils.generateToken(user);
      //3/Return both user and token
      res.json({
         user: user,
         token: token
      });
   });
});


//Generate JWT Token: SignIn Route
//1/Check username
router.post('‘/users/signin’', function (req, res) {
   User
      .findOne({ username: req.body.username })
      .exec(function (err, user) {
         if (err) throw err;
         if (!user) {
            return res.status(404).json({
               error: true,
               message: '‘Username or Password is Wrong’'
            });
         }
//2/ check pwd   
         bcrypt.compare(req.body.password, user.password,
            function (err, valid) {
               if (!valid) {
                  return res.status(404).json({
                     error: true,
                     message: '‘Username or Password is Wrong’'
                  });
               }
//3/ Generate token
               var token = utils.generateToken(user);
               user = utils.getCleanUser(user);
               export default generateToken;
//4/Return both user and token
               res.json({
                  user: user,
                  token: token
               });
            });
      });
});


// var jwt = require('jsonwebtoken');
// var tokenBase64 = 'eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiZXhwIjoiMTUxMTk1MDcwMyIsImFkbWluIjp0cnVlfQ.wFC-9ZsqA9QuvLkRSkQmVYpUmgH9R-j8M4D0GECuPHY';

// const token = jwt.decode(tokenBase64);
// const tokenExpirationDate = token.exp
// console.log(tokenExpirationDate);