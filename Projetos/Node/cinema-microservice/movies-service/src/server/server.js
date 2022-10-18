const express = require('express');
const morgan = require('morgan');
const helmet = require('helmet');
const logger = require('../config/logger');
let server = null;

async function start(){
  const app = express();

  app.use(helmet())
    .use(express.json())
    .use(morgan('dev'))
    .use((err, req, res, next) => {
      logger.error(err.message);
      res.sendStatus(500);
    });

  app.get('/health', (req, res, next) => {
        res.send(`The service ${process.env.MS_NAME} is running at ${process.env.PORT}`);
    })

  server = app.listen(process.env.PORT, () => {
    console.log(`The service  ${process.env.MS_NAME} already started at ${process.env.PORT}`)
  })  

  return server;
}

async function stop() {
    if (server) await server.close();
    return true;
}

module.exports = { start, stop }