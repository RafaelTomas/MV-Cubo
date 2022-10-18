const express = require('express');
const logger = require('morgan');

const indexRouter = require('./routes/index');
const usersRouter = require('./routes/users');

const authenticationMiddleware = require('./middlewares/authenticationMiddleware');

const app = express();

app.use(logger('dev'));
app.use(express.json());

app.use('/', indexRouter);
app.use('/users',authenticationMiddleware, usersRouter);


app.use(function(err, req, res, next) {
  console.log(err)
  res.status(err.status || 500);
  res.json({
    message: err.message,
    error: err
  });
});

module.exports = app;
