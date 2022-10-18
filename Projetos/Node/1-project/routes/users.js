const express = require('express');
const router = express.Router();
const userController = require('../controller/userController');
const validationMiddleware = require('../middlewares/validationMiddleware');

/* GET users listing. */
router.get('/', userController.getUsers);

router.get('/:id', userController.getUserById);

router.post('/',validationMiddleware, userController.postUser);

router.put('/:id', validationMiddleware,userController.putUser);

router.patch('/:id',validationMiddleware, userController.patchUser);

router.delete('/:id', userController.deleteUser);

module.exports = router;
