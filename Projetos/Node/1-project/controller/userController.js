const db = require("../models/userModel");

module.exports = {

 getUsers(req, res){
    const findUsers = db.findAll();
    res.json(findUsers);
  },

  getUserById(req, res){
    const id = req.params.id;
    res.json(db.findUser(id));
  },

  postUser(req, res){
    const user = db.createUser(req.body);
    res.status(201).json(user);
  },

  putUser(req,res){
    const id = req.params.id;
    const userBody = req.body;
    const user = db.updateUser(id, userBody, true);
    res.status(200).json(user);
  },

  patchUser(req, res) {
    const id = req.params.id;
    const userBody = req.body;
    const user = db.updateUser(id, userBody, false);
    res.status(200).json(user);
  },

  deleteUser(req, res) {
    const id = req.params.id;
    const user = db.deleteUser(id);
    res.status(200).json(user);
  }

}