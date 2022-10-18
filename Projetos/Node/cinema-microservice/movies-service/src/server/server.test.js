const request = require('supertest');
const { test, expect } = require('@jest/globals');
const server = require('./server');

const apiMock = jest.fn((app, repository) => {
  app.get('/error', (req, res, next) => {
    throw new Error('Mock Error');
  })
})

test('Server start',async () => {
  const app = await server.start();
  expect(app).toBeTruthy();
})

test('Server stop',async () => {
  const isStop = await server.stop();
  expect(isStop).toBeTruthy();
})

test('Server stop 2x',async () => {
  await server.stop();
  const isStop = await server.stop();
  expect(isStop).toBeTruthy();
})

test('Health Check', async () => {
  process.env.PORT = 3004;
  const app = await server.start(apiMock);
  const response = await request(app).get('/health');
  expect(response.status).toEqual(200);
})