const {v4} = require('uuid');
const fs = require('fs');

const FILE_PATH = require('path').join(__dirname,"..", "data", "user.json");

function findAll(){
  if(!fs.existsSync(FILE_PATH)) return [];
  const rawData = fs.readFileSync(FILE_PATH);
  return JSON.parse(rawData);
}

function findUser(id){
  return findAll().find(item => item.id === id)
}

function  createUser(user){
  const users = findAll();
  user.id =v4();
  users.push(user);
  fs.writeFileSync(FILE_PATH, JSON.stringify(users));
  return user
}

function updateUser(id, user, overwrite){
  const users = findAll();
  const index = users.findIndex(item => (item.id === id));

  if(index === -1) return {};

  if(overwrite)
      users[index] = user;
  else{
    for(let key in user){
      users[index][key] = user[key];
    }
  }

  fs.writeFileSync(FILE_PATH, JSON.stringify(users));
  return  users[index];
}

function deleteUser(id) {
    const users = findAll();
    users.forEach((item, index, array) => {
        if (item.id === id)
            array.splice(index, 1);
    })
    fs.writeFileSync(FILE_PATH, JSON.stringify(users));
    return id;
}


module.exports={
  findAll,
  findUser,
  createUser,
  updateUser,
  deleteUser,
}