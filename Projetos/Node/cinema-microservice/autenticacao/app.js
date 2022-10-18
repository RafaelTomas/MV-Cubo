const passport = require('passport');
const session = require('express-session');
const MongoStore = require('connect-mongo');

var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');

global.authenticationMiddleware = () => {
  return function (req, res, next) {
    if (req.isAuthenticated() && require("./permissions")(req)) {
      return next()
    }
    res.redirect('/login?fail=true')
  }
};

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');
var loginRouter = require('./routes/login');
var reportsRouter = require('./routes/reports');

var app = express();

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));

require('./auth')(passport);
app.use(session({
  store: MongoStore.create({
    mongoUrl: process.env.MONGO_CONNECTION,
    ttl: 30 * 60,
    autoRemove: 'native'
  }),
  secret: process.env.MONGO_STORE_SECRET,
  resave: false,
  saveUninitialized: false,
  cookie: { maxAge: 30 * 60 * 1000 }
}))
app.use(passport.initialize());
app.use(passport.session());

app.use('/index', indexRouter);
app.use('/users', usersRouter);
app.use('/reports', reportsRouter);
app.use('/', loginRouter);

app.use(function (req, res, next) {
  next(createError(404));
});

app.use(function (err, req, res, next) {
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;