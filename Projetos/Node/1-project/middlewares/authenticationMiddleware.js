const keyModel = require('../models/keyModel');

module.exports = (req, res, next) => {
  const key = req.headers['authorization'];
  const apikey = keyModel.find(key.replace('ApiKey ', ''));

  if(apikey && apikey.enabled)
    return next();
  else
    res.sendStatus(401);
}